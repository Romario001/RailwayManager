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


        return findTheWay(segments,stationFrom,stationTo);


//        System.out.println("temp1");
//        System.out.println(segments);
//
//        if (segmentsCount != 0) {
//            List<Integer> usedStations = new ArrayList<>();
//            usedStations.add(stationFrom);
//            int currentStation = stationFrom;
//            long result = 0l;
//
//
//            //Если из заданного старта есть прямой путь в заданный финиш
//
//            long directLineWeight = 0;
//
//            for (RouteSegmentsPO r : segments) {
//
//                if (r.getStationPO1().getStationId() == stationFrom
//                        && r.getStationPO2().getStationId() == stationTo) {
//
//                    System.out.println("direct travel =");
//                    directLineWeight = r.getTravelTime();
//                    preparedSegments.add(r);
//
//                    return preparedSegments;
//                }
//
//            }
//
//            int minWeight = Integer.MAX_VALUE;
//            RouteSegmentsPO segmentsToUsePO = null;
//
//            while (currentStation != stationTo && usedStations.size() != stationCount) {
//                List<RouteSegmentsPO> currentSegmentsList = new ArrayList<>();
//
////                составляем список возможных для использования сегментов
//                for (RouteSegmentsPO r : segments) {
//                    if (r.getStationPO1().getStationId() == currentStation
//                            && !usedStations.contains(r.getStationPO2().getStationId())) {
//                        currentSegmentsList.add(r);
//                    }
//                }
//                System.out.println("temp2");
//                System.out.println(currentSegmentsList);
//
//                //если не найдено ни одного подходящего ребра
//                if (currentSegmentsList.size() == 0) {
//                    System.out.println(-1);
//                    continue;
//                }
//
//
//                //ищем в этом списке ребро, с использованием которого удастся достичь наименьшего НА ДАННЫЙ МОМЕНТ веса
//
//                for (RouteSegmentsPO r : currentSegmentsList) {
//                    if (r.getTravelTime() + result < minWeight) {
//                        minWeight = r.getTravelTime();
//                        segmentsToUsePO = r;
//                    }
//                }
//                currentSegmentsList.remove(segmentsToUsePO);
//                segments.remove(segmentsToUsePO);
//
//                //меняем текущие значения для переменных-показателей статуса
//                currentStation = segmentsToUsePO.getStationPO2().getStationId();
//                usedStations.add(currentStation);
//                preparedSegments.add(segmentsToUsePO);
//                result += segmentsToUsePO.getTravelTime();
//
//
//                //выводит список вершин, обойденных на данный момент
//				/*for(int r : usedStations) {
//					System.out.print(r);
//				}
//				System.out.println();*/
//            }
//
//            //если нужного пути не существует, выводится -1
//            if (currentStation != stationTo && usedStations.size() == stationCount) {
//                System.out.println("Route not found");
//                Collections.emptyList();
//            } else {
//                return preparedSegments;
//            }
//
//        }
//        System.out.println("Route not found");
//        return Collections.emptyList();
    }

    Map<StationPO, Collection<RouteSegmentsPO>> mapOfWays = new HashMap<>();

    public Collection<RouteSegmentsPO> findTheWay(Collection<RouteSegmentsPO> segmentsPOCollection, int stationFrom, int stationTo) {
        Collection<RouteSegmentsPO> currentSegmentsList = new ArrayList<>();
        Collection<RouteSegmentsPO> resultSegmentsList = new ArrayList<>();

        for (RouteSegmentsPO rs : segmentsPOCollection) {
            if (rs.getStationPO2().getStationId() == stationTo) {
                resultSegmentsList.add(rs);
                return  resultSegmentsList;
            }
            if (rs.getStationPO1().getStationId() == stationFrom) {
                currentSegmentsList.add(rs);
            }
            segmentsPOCollection.remove(currentSegmentsList);
        }

        if (currentSegmentsList.size() == 0) {
            System.out.println("no segments found");
            return resultSegmentsList;
        }

        for (RouteSegmentsPO rs : currentSegmentsList) {
            mapOfWays.put(rs.getStationPO1(),
                    findTheWay(segmentsPOCollection, rs.getStationPO2().getStationId(), stationTo));
            System.out.println(mapOfWays.keySet());

        }

        return Collections.emptyList();
    }

}
