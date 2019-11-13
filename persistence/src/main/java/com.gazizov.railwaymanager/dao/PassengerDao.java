package com.gazizov.railwaymanager.dao;

import com.gazizov.railwaymanager.pojo.PassengerPO;

import java.util.Collection;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
public interface PassengerDao {

    void savePassenger(PassengerPO passengerPO);

    Collection<PassengerPO> findAll();

    PassengerPO findByLogin(String login);

}
