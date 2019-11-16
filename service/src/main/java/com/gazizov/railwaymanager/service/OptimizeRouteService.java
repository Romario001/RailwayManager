package com.gazizov.railwaymanager.service;

import com.gazizov.railwaymanager.persistence.dao.RouteSegmentDao;
import com.gazizov.railwaymanager.persistence.dao.StationDao;
import com.gazizov.railwaymanager.persistence.pojo.RouteSegmentsPO;
import com.gazizov.railwaymanager.persistence.pojo.StationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 16.11.2019
 *
 * @author Roman Gazizov
 */

    /*
Реализуйте алгоритм Дейкстры поиска кратчайшего пути в графе.
Входные данные: В первой строке указаны два числа: число вершин и число ребер графа.
Далее идут строки с описанием ребер. Их количество равно числу ребер.
В каждой строке указаны 3 числа: исходящая вершина, входящая вершина, вес ребра.
В последней строке указаны 2 номера вершины: начальная и конечная вершина, кратчайший путь между которыми нужно найти.
Выходные данные: минимальное расстояние между заданными вершинами. Если пути нет, то нужно вернуть -1.
Sample Input:
4 8
1 2 6
1 3 2
1 4 10
2 4 4
3 1 5
3 2 3
3 4 8
4 2 1
1 4
Sample Output:
9
*/

@Service
public class OptimizeRouteService {

    @Autowired
    static RouteSegmentDao routeSegmentDao;

    @Autowired
    static RouteSegmentsPO routeSegmentsPO;

    @Autowired
    static StationDao stationDao;

    @Autowired
    static StationPO stationPO;

//    private static int stationFrom, stationTo;//от клиента

    //    Завайрили это все
//    private static class Segments {
//        int station_id_from;
//        int station_id_to;
//        int weight; // пока weight=1, потом будем определять расстояние/время/деньги
//
//        private Segments(int station_id_from, int station_id_to, int weight) {
//            this.station_id_from = station_id_from;
//            this.station_id_to = station_id_to;
//            this.weight = weight;
//        }
//    }

    // Завайрили
//    private static void initialize(Scanner in) {
//        stationCount = in.nextInt();
//        segmentsCount = in.nextInt();
//        segments = new LinkedList<>();
//        for (int i = 0; i < segmentsCount; i++) {
//            segments.add(new Segments(in.nextInt(), in.nextInt(), in.nextInt()));
//        }
//        stationFrom = in.nextInt();
//        stationTo = in.nextInt();
//    }

    public Integer findCountOfStationsByTheWay(Integer stationFrom, Integer stationTo) throws Exception {
//        Scanner in = new Scanner(System.in);
//        initialize(in);

        int stationCount = stationDao.findStationCount();
        int segmentsCount = routeSegmentDao.findSegmentsCount();
        Collection<RouteSegmentsPO> segments = routeSegmentDao.findAllRouteSegments();

        if (segmentsCount != 0) {
            List<Integer> usedStations = new LinkedList<>();
            usedStations.add(stationFrom);
            int currentStation = stationFrom;
            int result = 0;

            //костыль на случай, если из заданного старта есть прямой
            //путь в заданный финиш, т.к. итоговый путь может оказаться
            //больше него
            int directLineWeight = 0;

            for (RouteSegmentsPO r : segments) {
                if (routeSegmentsPO.getStationPO1().getStationId() == stationFrom
                        && routeSegmentsPO.getStationPO2().getStationId() == stationTo) {
                    directLineWeight = routeSegmentsPO.getTravelTime();
                }
            }

            while (currentStation != stationTo && usedStations.size() != stationCount) {
                List<RouteSegmentsPO> currentSegmentsList = new LinkedList<>();

                //составляем список возможных для использования сегментов
                for (RouteSegmentsPO r : segments) {
                    if (routeSegmentsPO.getStationPO1().getStationId() == currentStation &&
                            !usedStations.contains(routeSegmentsPO.getStationPO2().getStationId())) {
                        currentSegmentsList.add(r);
                    }
                }

                //если не найдено ни одного подходящего ребра
                if (currentSegmentsList.size() == 0) {
                    System.out.println(-1);
                    return 0;
                }
                segments.removeAll(currentSegmentsList);

                //ищем в этом списке ребро, с использованием которого
                //удастся достичь наименьшего НА ДАННЫЙ МОМЕНТ веса
                int minWeight = Integer.MAX_VALUE;
                RouteSegmentsPO segmentsToUsePO = null;
                for (RouteSegmentsPO r : currentSegmentsList) {
                    if (routeSegmentsPO.getTravelTime() + result < minWeight) {
                        minWeight = routeSegmentsPO.getTravelTime();
                        segmentsToUsePO = r;
                    }
                }
                currentSegmentsList.remove(segmentsToUsePO);
                segments.addAll(currentSegmentsList);

                //меняем текущие значения для переменных-показателей статуса
                currentStation = segmentsToUsePO.getStationPO2().getStationId();
                usedStations.add(segmentsToUsePO.getStationPO2().getStationId());
                result += segmentsToUsePO.getTravelTime();

                //выводит список вершин, обойденных на данный момент
				/*for(int r : usedStations) {
					System.out.print(r);
				}
				System.out.println();*/
            }

            //если нужного пути не существует, выводится -1
            if (currentStation != stationTo && usedStations.size() == stationCount) {
                System.out.println(-1);
            } else {
                if (directLineWeight != 0 && result > directLineWeight) {
                    System.out.println(directLineWeight);
                } else {
                    System.out.println(result);
                    return result;
                }
            }
        } else {
            System.out.println(-1);
            return -1;
        }
        return 47;
    }
}
