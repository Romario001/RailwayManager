package com.gazizov.railwaymanager;

import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import com.gazizov.railwaymanager.persistence.pojo.RoutePO;
import com.gazizov.railwaymanager.persistence.pojo.RouteSegmentsPO;
import com.gazizov.railwaymanager.persistence.pojo.StationPO;
import com.gazizov.railwaymanager.service.OptimizeRouteService;
import com.gazizov.railwaymanager.service.RouteService;
import com.gazizov.railwaymanager.service.configuration.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class TicketsTest {

    @Autowired
    private RouteService routeService;

    @Autowired
    private OptimizeRouteService optimizeRouteService;

    @Test
    public void someTest() {
        PassengerPO p = new PassengerPO();

        assertNotNull(p);
    }


    @Test
    public void checkThatTicketCanNotBeBoughtIfRouteIsNotFoundForRequestedStation() {
        int desiredStationId = 1234;
        Collection<RoutePO> allRoutesByStation = routeService.findAllRoutesByStation(desiredStationId);

        assertEquals(0, allRoutesByStation.size());
    }

    @Test
    public void checkThatTicketCanNotBeBoughtIfThereAreNoTrainsForRequestedRoute() {
        Collection<RoutePO> allRoutesByStation = routeService.findAllRoutesByStation(1);

        for (RoutePO routePO : allRoutesByStation) {
            assertNull(routePO.getTrainId());
        }

    }

    @Test
    public void checkRoutesBuilding1() throws Exception {
        Collection<RouteSegmentsPO> routeSegmentsPOS =
                optimizeRouteService.findStationsByTheWay(1, 3);

        StationPO stationPO1 = new StationPO();
        StationPO stationPO2 = new StationPO();
        stationPO1.setStationName("Voronezh");
        stationPO1.setStationId(1);
        stationPO2.setStationName("Moskva");
        stationPO2.setStationId(3);

        RoutePO routePO = new RoutePO();
        routePO.setRouteId(2);
        routePO.setTrainId(3);
        routePO.setRouteName("Voronezh-Moskva");


        RouteSegmentsPO routeSegmentsPO1 = new RouteSegmentsPO();
        routeSegmentsPO1.setRouteSegmentsId(4);
        routeSegmentsPO1.setRoutePO(routePO);
        routeSegmentsPO1.setStationPO1(stationPO1);
        routeSegmentsPO1.setStationPO2(stationPO2);
        routeSegmentsPO1.setOrderNumber(1);
        routeSegmentsPO1.setTravelTime(1);

        Collection<RouteSegmentsPO> expectedRouteSegmentsPOS = new ArrayList<>();
        expectedRouteSegmentsPOS.add(routeSegmentsPO1);

        assertEquals(expectedRouteSegmentsPOS, routeSegmentsPOS);
    }

    @Test
    public void checkRoutesBuilding2() throws Exception {
        Collection<RouteSegmentsPO> routeSegmentsPOS =
                optimizeRouteService.findStationsByTheWay(1, 8);

        StationPO stationPO1 = new StationPO();
        StationPO stationPO2 = new StationPO();
        stationPO1.setStationName("Voronezh");
        stationPO1.setStationId(1);
        stationPO2.setStationName("Moskva");
        stationPO2.setStationId(3);

        RoutePO routePO = new RoutePO();
        routePO.setRouteId(2);
        routePO.setTrainId(3);
        routePO.setRouteName("Voronezh-Moskva");


        RouteSegmentsPO routeSegmentsPO1 = new RouteSegmentsPO();
        routeSegmentsPO1.setRouteSegmentsId(4);
        routeSegmentsPO1.setRoutePO(routePO);
        routeSegmentsPO1.setStationPO1(stationPO1);
        routeSegmentsPO1.setStationPO2(stationPO2);
        routeSegmentsPO1.setOrderNumber(1);
        routeSegmentsPO1.setTravelTime(1);

        Collection<RouteSegmentsPO> expectedRouteSegmentsPOS = new ArrayList<>();
        expectedRouteSegmentsPOS.add(routeSegmentsPO1);

        assertEquals(expectedRouteSegmentsPOS, routeSegmentsPOS);
    }

}

