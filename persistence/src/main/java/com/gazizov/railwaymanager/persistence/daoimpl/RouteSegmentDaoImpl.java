package com.gazizov.railwaymanager.persistence.daoimpl;

import com.gazizov.railwaymanager.persistence.dao.RouteSegmentDao;
import com.gazizov.railwaymanager.persistence.pojo.RouteSegmentsPO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * 14.11.2019
 *
 * @author Roman Gazizov
 */
public class RouteSegmentDaoImpl implements RouteSegmentDao {

    private EntityManager entityManager;

    @Transactional
    public void saveRouteSegment(RouteSegmentsPO routeSegmentsPO) {
        if (Objects.isNull(routeSegmentsPO.getRouteSegmentsId())) {
            routeSegmentsPO.setOrderNumber(routeSegmentsPO.getOrderNumber());
            routeSegmentsPO.setRoutePO(routeSegmentsPO.getRoutePO());
            routeSegmentsPO.setRouteSegmentsId(routeSegmentsPO.getRouteSegmentsId());
            routeSegmentsPO.setStationPO1(routeSegmentsPO.getStationPO1());
            routeSegmentsPO.setStationPO2(routeSegmentsPO.getStationPO2());
        }

        entityManager.persist(routeSegmentsPO);
    }

    @Override
    public Collection<RouteSegmentsPO> findAllRouteSegments() {

        String queryString = "SELECT r" +
                " FROM RouteSegmentsPO r";

        Query query = entityManager.createQuery(queryString);

        List<RouteSegmentsPO> routeSegmentsPOList = query.getResultList();

        return routeSegmentsPOList;
    }

    @Override
    public int findSegmentsCount() {
        String queryString = "SELECT COUNT(*) FROM RouteSegmentsPO";
        Query query = entityManager.createQuery(queryString);

        return (int) query.getSingleResult();
    }


    @PersistenceContext(unitName = "pu_railwaymanager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
