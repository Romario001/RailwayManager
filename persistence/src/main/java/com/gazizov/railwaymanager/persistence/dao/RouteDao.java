package com.gazizov.railwaymanager.persistence.dao;

import com.gazizov.railwaymanager.persistence.pojo.RoutePO;

import java.util.Collection;

/**
 * 14.11.2019
 *
 * @author Roman Gazizov
 */


public interface RouteDao {

    void saveRoute(RoutePO routePO);

    Collection<RoutePO> findAllRoutes();

    Collection<RoutePO> findRoutesByStation(Integer stationId);



}
