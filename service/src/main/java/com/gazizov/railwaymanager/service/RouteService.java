package com.gazizov.railwaymanager.service;

import com.gazizov.railwaymanager.persistence.dao.RouteDao;
import com.gazizov.railwaymanager.persistence.pojo.RoutePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 13.11.2019
 *
 * @author Roman Gazizov
 */

@Service
public class RouteService {

    @Autowired
    RouteDao routeDao;

    public Collection<RoutePO> findAllRoutesByStation(Integer stationId) {
        Collection<RoutePO> routePOList = routeDao.findRoutesByStation(stationId);

        if (routePOList != null) {
            return routePOList;
        } else {
            System.out.println("Routes not found");
        }

        return routePOList;
    }


}
