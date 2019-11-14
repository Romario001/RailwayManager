package com.gazizov.railwaymanager.persistence.daoimpl;

import com.gazizov.railwaymanager.persistence.dao.StationDao;
import com.gazizov.railwaymanager.persistence.pojo.StationPO;
import com.gazizov.railwaymanager.persistence.pojo.TrainPO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext(unitName = "pu_railwaymanager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
