package com.gazizov.railwaymanager;

import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import com.gazizov.railwaymanager.persistence.pojo.RoutePO;
import com.gazizov.railwaymanager.service.RouteService;
import com.gazizov.railwaymanager.service.configuration.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class TicketsTest {

    @Autowired
    private RouteService routeService;

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
}
