package com.gazizov.railwaymanager.dao;

import com.gazizov.railwaymanager.pojo.StationPO;
import com.gazizov.railwaymanager.pojo.TrainPO;

import java.util.Collection;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
public interface StationDao {

    void addStation (StationPO stationPO);

    Collection<TrainPO> findTrainByStation();

}
