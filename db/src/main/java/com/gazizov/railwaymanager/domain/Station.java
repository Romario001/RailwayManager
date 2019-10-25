package com.gazizov.railwaymanager.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

/**
 * 25.10.2019
 *
 * @author Roman Gazizov
 */

@Getter
@Setter
public class Station {
    private Integer stationId;
    private String stationName;

    private Map<Integer, Date> stationSchedule; //Integer - trainId
}
