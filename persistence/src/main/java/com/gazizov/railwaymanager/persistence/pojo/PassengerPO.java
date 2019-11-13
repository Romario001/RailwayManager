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
@Table(name = "passengers")
public class PassengerPO {

    @Id
    @Column(name = "passenger_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passengerId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "active")
//    @Builder.Default
    private boolean active = true;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passengerPO", fetch = FetchType.EAGER)
    private List<TicketPO> passengerTickets = new ArrayList<>();

    @Override
    public String toString() {
        return "PassengerPO{" +
                "passengerId=" + passengerId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", roleId=" + roleId +
                ", passengerTickets=" + passengerTickets +
                ", active=" + active +
                '}';
    }
}

//private Boolean active;

//    private List<RolePO> roles = new ArrayList<>();


