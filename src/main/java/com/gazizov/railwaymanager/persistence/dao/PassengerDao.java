package com.gazizov.railwaymanager.persistence.dao;

import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;

import javax.persistence.Query;
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
