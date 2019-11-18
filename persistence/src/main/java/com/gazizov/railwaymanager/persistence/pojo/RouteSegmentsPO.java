package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * 14.11.2019
 *
 * @author Roman Gazizov
 */

@Getter
@Setter
@Entity
@Table(name = "route_segments")
public class RouteSegmentsPO {

    @Id
    @Column(name = "route_segments_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeSegmentsId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private RoutePO routePO;

    @ManyToOne
    @JoinColumn(name = "station_id_start")
    private StationPO stationPO1;

    @ManyToOne
    @JoinColumn(name = "station_id_end")
    private StationPO stationPO2;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "travel_time")
    private Integer travelTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteSegmentsPO)) return false;
        RouteSegmentsPO that = (RouteSegmentsPO) o;
        return routeSegmentsId.equals(that.routeSegmentsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeSegmentsId);
    }

    @Override
    public String toString() {
        return "RouteSegmentsPO{" +
//                "routeSegmentsId=" + routeSegmentsId +
                ", routePO=" + routePO.getRouteName() +
                ", stationPO1=" + stationPO1.getStationName() +
                ", stationPO2=" + stationPO2.getStationName() +
//                ", orderNumber=" + orderNumber +
//                ", travelTime=" + travelTime +
                '}';
    }
}

