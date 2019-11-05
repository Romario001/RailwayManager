package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 02.11.2019
 *
 * @author Roman Gazizov
 */

@Embeddable
class StationTrainId implements Serializable {
    @Column(name="station_id")
    private Integer stationId;

    @Column(name="train_id")
    private Integer trainId;
};

@Getter
@Setter
@Entity
@Table(name = "schedule")
public class SchedulePO {

    @EmbeddedId
    StationTrainId stationTrainId;

    @Column(name="departure_time")
    private String departureTime;
}
