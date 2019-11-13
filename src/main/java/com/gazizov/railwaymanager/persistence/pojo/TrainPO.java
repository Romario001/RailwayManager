package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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
@Table(name = "trains")
public class TrainPO {

    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainId;

    @Column(name = "passenger_count")
    private Integer passengerCount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainPO", fetch = FetchType.EAGER)
    private List<TicketPO> trainTickets = new ArrayList<>();

    @Override
    public String toString() {
        return "TrainPO{" +
                "trainId=" + trainId +
                ", passengerCount=" + passengerCount +
                '}';
    }
}
