package com.gazizov.railwaymanager.persistence.daoimpl;

import com.gazizov.railwaymanager.persistence.dao.StationDao;
import com.gazizov.railwaymanager.persistence.pojo.StationPO;
import com.gazizov.railwaymanager.persistence.pojo.TrainPO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Objects;

/**
 * 14.11.2019
 *
 * @author Roman Gazizov
 */

public class StationDaoImpl implements StationDao {

    private EntityManager entityManager;

    @Override
    @Transactional
    public void addStation(StationPO stationPO) {
        if (Objects.isNull(stationPO.getStationId())) {
            stationPO.setStationName(stationPO.getStationName());

        }

        entityManager.persist(stationPO);
    }

    @Override
    public Collection<TrainPO> findTrainByStation() {
        return null;
    }

    @Transactional
    public long findStationCount() {
        String queryString = "SELECT COUNT(*) FROM StationPO";
        Query query = entityManager.createQuery(queryString);

        return (long) query.getSingleResult();
    }

    @Transactional
    public StationPO findStationByStationId(Integer stationId) {
        String queryString = "SELECT s FROM StationPO s WHERE s.stationId=:stationId";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("stationId", stationId);

        return (StationPO) query.getSingleResult();
    }


    @PersistenceContext(unitName = "pu_railwaymanager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
