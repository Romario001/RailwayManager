package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
@Entity
@Table(name="trains")
public class TrainPO {
    @Id
    @Column(name="train_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @OneToMany(targetEntity = TicketPO.class)
    private Integer trainId;

    @Column(name="passenger_count")
    private Integer passengerCount;

//    private List<TicketPO> trainTickets;
//    private Map<Integer, Date> trainSchedule; //Maybe it's unnesessary due to stationSchedule
}
