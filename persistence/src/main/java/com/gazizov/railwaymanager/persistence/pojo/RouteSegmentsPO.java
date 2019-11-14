package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @JoinColumn(name = "station_id")
    private StationPO stationPO;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Override
    public String toString() {
        return "RouteSegmentsPO{" +
                "routeSegmentsId=" + routeSegmentsId +
                ", routeId=" + routePO +
                ", stationId=" + stationPO +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
