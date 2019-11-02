package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

/**
 * 25.10.2019
 *
 * @author Roman Gazizov
 */

@Getter
@Setter
@Entity
@Table(name="stations")
public class StationPO {

    @Id
    @Column(name="station_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer stationId;

    @Column(name="station_name")
    private String stationName;

    //private Map<Integer, Date> stationSchedule; //Integer - trainId
    // /Вопрос по поводу совпадения таблиц с сущностями
}
