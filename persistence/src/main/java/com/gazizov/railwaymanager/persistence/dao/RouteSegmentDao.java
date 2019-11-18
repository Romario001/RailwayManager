package com.gazizov.railwaymanager.persistence.dao;

import com.gazizov.railwaymanager.persistence.pojo.RouteSegmentsPO;

import java.util.Collection;

/**
 * 14.11.2019
 *
 * @author Roman Gazizov
 */


public interface RouteSegmentDao {

    void saveRouteSegment(RouteSegmentsPO routeSegmentsPO);

    Collection<RouteSegmentsPO> findAllRouteSegments();

    long findSegmentsCount();

    RouteSegmentsPO findRouteSegmentsByStationId(Integer stationIdStart, Integer stationIdEnd);
}
