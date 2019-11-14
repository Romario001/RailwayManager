package com.gazizov.railwaymanager.persistence.daoimpl;

import com.gazizov.railwaymanager.persistence.dao.RouteDao;
import com.gazizov.railwaymanager.persistence.pojo.RoutePO;
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
public class RouteDaoImpl implements RouteDao {

    private EntityManager entityManager;

    @Transactional
    public void saveRoute(RoutePO routePO) {
        if (Objects.isNull(routePO.getRouteId())) {
            routePO.setAllRouteSegments(routePO.getAllRouteSegments());
            routePO.setRouteName(routePO.getRouteName());
            routePO.setTrainId(routePO.getTrainId());
        }

        entityManager.persist(routePO);
    }

    @Override
    public Collection<RoutePO> findRoutesByStation(Integer stationId) {

        String queryString = "SELECT r" +
                " FROM RoutePO r,RouteSegmentsPO rs" +
                " WHERE r.routeId = rs.routePO.routeId and " +
                "rs.stationPO = :stationId";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("stationId", stationId);

        List<RoutePO> routePOList = query.getResultList();

        return routePOList;
    }

    @Override
    public Collection<RoutePO> findAllRoutes() {
        return null;
    }

    @PersistenceContext(unitName = "pu_railwaymanager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
