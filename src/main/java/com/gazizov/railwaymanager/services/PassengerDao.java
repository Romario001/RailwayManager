package com.gazizov.railwaymanager.services;

import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;

import java.util.Collection;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
public interface PassengerDao {

    void savePassenger(PassengerPO passengerPO);

    Collection<PassengerPO> findAll();
}
