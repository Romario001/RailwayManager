package com.gazizov.railwaymanager.persistence.daoimpl;

import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import com.gazizov.railwaymanager.persistence.pojo.TrainPO;
import com.gazizov.railwaymanager.persistence.dao.TrainDao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Objects;

/**
 * 13.11.2019
 *
 * @author Roman Gazizov
 */
public class TrainDaoImpl implements TrainDao {

    private EntityManager entityManager;

    @Transactional
    public void addTrain(TrainPO trainPO) {
        if (Objects.isNull(trainPO.getTrainId())) {

            trainPO.setPassengerCount(trainPO.getPassengerCount());

        }

        entityManager.persist(trainPO);
    }

    @Override
    public Collection<TrainPO> findAllTrain() {
        return null;
    }

    @Override
    public Collection<TrainPO> findTrainByTime() {
        return null;
    }

    @Override
    public Collection<TrainPO> findTrainByRoute() {
        return null;
    }

    @Override
    public Collection<PassengerPO> findAllTrainPassengers() {
        return null;
    }

    @PersistenceContext(unitName = "pu_railwaymanager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
