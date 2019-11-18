package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stationPO1",fetch = FetchType.EAGER)
    private List<RouteSegmentsPO> allRouteSegmentsWithStartStation = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stationPO2",fetch = FetchType.EAGER)
    private List<RouteSegmentsPO> allRouteSegmentsWithEndStation = new ArrayList<>();

    @Override
    public String toString() {
        return "StationPO{" +
                "stationId=" + stationId +
                ", stationName='" + stationName + '\'' +
                '}';
    }

    //private Map<Integer, Date> stationSchedule; //Integer - trainId
    // /Вопрос по поводу совпадения таблиц с сущностями
}
