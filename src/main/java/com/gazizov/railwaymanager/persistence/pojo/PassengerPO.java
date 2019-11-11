package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 25.10.2019
 *
 * @author Roman Gazizov
 */

@ToString
@Getter
@Setter
@Entity
@Table(name = "passengers")
public class PassengerPO {

    @Id
    @Column(name = "passenger_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToMany(targetEntity = TicketPO.class)
    private Long passengerId;

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

    @OneToMany(mappedBy = "passengers")
    private List<TicketPO> passengerTickets;



    //private Boolean active;

//    private List<RolePO> roles = new ArrayList<>();

}
