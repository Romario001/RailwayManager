package com.gazizov.railwaymanager.persistence.dao;

import com.gazizov.railwaymanager.persistence.pojo.StationPO;
import com.gazizov.railwaymanager.persistence.pojo.TrainPO;

import java.util.Collection;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */

public interface StationDao {

    void addStation (StationPO stationPO);

    Collection<TrainPO> findTrainByStation();

    int findStationCount();

}
