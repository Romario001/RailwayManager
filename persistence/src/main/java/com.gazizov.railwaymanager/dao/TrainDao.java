package com.gazizov.railwaymanager.dao;

import com.gazizov.railwaymanager.pojo.PassengerPO;
import com.gazizov.railwaymanager.pojo.TrainPO;

import java.util.Collection;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
public interface TrainDao {

    void addTrain(TrainPO trainPO);

    Collection<TrainPO> findAllTrain();

    Collection<TrainPO> findTrainByTime();

    Collection<TrainPO> findTrainByRoute();

    Collection<PassengerPO> findAllTrainPassengers();
    
}
