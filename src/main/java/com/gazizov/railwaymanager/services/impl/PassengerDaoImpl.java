package com.gazizov.railwaymanager.services.impl;

import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import com.gazizov.railwaymanager.services.PassengerDao;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
@AllArgsConstructor
public class PassengerDaoImpl
        implements PassengerDao {

    private EntityManager entityManager;

    @Override
    public void savePassenger(PassengerPO passengerPO) {
        entityManager.persist(passengerPO);
    }

    @Override
    public Collection<PassengerPO> findAll() {
        Query query = entityManager.createQuery("select * from PassengerPO.class");
        return query.getResultList();
    }
}
