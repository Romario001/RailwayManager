package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 14.11.2019
 *
 * @author Roman Gazizov
 */

@Getter
@Setter
@Entity
@Table(name = "routes")
public class RoutePO {

    @Id
    @Column(name = "route_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    @Column(name = "route_name")
    private String routeName;

    @Column(name = "train_id")
    private Integer trainId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routePO")
    private List<RouteSegmentsPO> allRouteSegments = new ArrayList<>();

    @Override
    public String toString() {
        return "RoutePO{" +
                "routeId=" + routeId +
                ", routeName='" + routeName + '\'' +
                ", trainId=" + trainId +
                '}';
    }
}
