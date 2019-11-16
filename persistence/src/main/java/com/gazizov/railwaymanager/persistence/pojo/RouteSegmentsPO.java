package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 14.11.2019
 *
 * @author Roman Gazizov
 */

@Getter
@Setter
@Entity
@Table(name = "route_segments")
public class RouteSegmentsPO implements Iterable {

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
    public String toString() {
        return "RouteSegmentsPO{" +
                "routeSegmentsId=" + routeSegmentsId +
                ", routePO=" + routePO +
                ", stationPO1=" + stationPO1 +
                ", stationPO2=" + stationPO2 +
                ", orderNumber=" + orderNumber +
                '}';
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}

