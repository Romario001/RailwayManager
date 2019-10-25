package com.gazizov.railwaymanager.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 25.10.2019
 *
 * @author Roman Gazizov
 */

@Getter
@Setter
public class Train {
    private Integer trainId;
    private Integer passengerCount;

    private List<Ticket> trainTickets;
    private Map<Integer, Date> trainSchedule; //Maybe it's unnesessary due to stationSchedule
}
