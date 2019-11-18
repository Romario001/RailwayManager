package com.gazizov.railwaymanager.service;

import com.gazizov.railwaymanager.persistence.dao.RouteSegmentDao;
import com.gazizov.railwaymanager.persistence.dao.StationDao;
import com.gazizov.railwaymanager.persistence.pojo.RouteSegmentsPO;
import com.gazizov.railwaymanager.persistence.pojo.StationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    RouteSegmentDao routeSegmentDao;

    @Autowired
    RouteSegmentsPO routeSegmentsPO;

    @Autowired
    StationDao stationDao;

    @Autowired
    StationPO stationPO;

    public Collection<RouteSegmentsPO> findStationsByTheWay(Integer stationFrom, Integer stationTo) throws Exception {

        long stationCount = stationDao.findStationCount();
        long segmentsCount = routeSegmentDao.findSegmentsCount();
        Collection<RouteSegmentsPO> segments = routeSegmentDao.findAllRouteSegments();
        Collection<RouteSegmentsPO> preparedSegments = new ArrayList<>();

        if (segmentsCount != 0) {
            List<Integer> usedStations = new ArrayList<>();
            usedStations.add(stationFrom);
            int currentStation = stationFrom;
            long result = 0l;


            //Если из заданного старта есть прямой путь в заданный финиш

            long directLineWeight = 0;

            for (RouteSegmentsPO r : segments) {

                if (r.getStationPO1().getStationId() == stationFrom
                        && r.getStationPO2().getStationId() == stationTo) {

                    System.out.println("direct travel =");
                    directLineWeight = r.getTravelTime();
                    preparedSegments.add(r);

                    return preparedSegments;
                }

            }

            while (currentStation != stationTo && usedStations.size() != stationCount) {
                List<RouteSegmentsPO> currentSegmentsList = new ArrayList<>();

                //составляем список возможных для использования сегментов
                for (RouteSegmentsPO r : segments) {
                    if (r.getStationPO1().getStationId() == currentStation &&
                            !usedStations.contains(r.getStationPO2().getStationId())) {
                        currentSegmentsList.add(r);
                    }
                }

                System.out.println(currentSegmentsList);

                //если не найдено ни одного подходящего ребра
                if (currentSegmentsList.size() == 0) {
                    System.out.println(-1);
                }
                segments.removeAll(currentSegmentsList);

                //ищем в этом списке ребро, с использованием которого
                //удастся достичь наименьшего НА ДАННЫЙ МОМЕНТ веса
                int minWeight = Integer.MAX_VALUE;
                RouteSegmentsPO segmentsToUsePO = null;
                for (RouteSegmentsPO r : currentSegmentsList) {
                    if (r.getTravelTime() + result < minWeight) {
                        minWeight = r.getTravelTime();
                        segmentsToUsePO = r;
                    }
                }
                currentSegmentsList.remove(segmentsToUsePO);
                segments.addAll(currentSegmentsList);

                //меняем текущие значения для переменных-показателей статуса
                currentStation = segmentsToUsePO.getStationPO2().getStationId();
                usedStations.add(segmentsToUsePO.getStationPO2().getStationId());
                preparedSegments.add(segmentsToUsePO);
                result += segmentsToUsePO.getTravelTime();


                //выводит список вершин, обойденных на данный момент
				/*for(int r : usedStations) {
					System.out.print(r);
				}
				System.out.println();*/
            }

            //если нужного пути не существует, выводится -1
            if (currentStation != stationTo && usedStations.size() == stationCount) {
                System.out.println("Route not found");
                Collections.emptyList();
            } else {
                return preparedSegments;
            }

        }
        System.out.println("Route not found");
        return Collections.emptyList();
    }

}
