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
@Table(name="passengers")
public class PassengerPO {

    @Id
    @Column(name="passenger_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @OneToMany(targetEntity = TicketPO.class)
    private Integer passengerId;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last name")
    private String lastName;

    @Column(name="birth_date")
    private String birthDate;

    //private Boolean active;

//    private List<RolePO> roles = new ArrayList<>();
//    private List<TicketPO> passengerTickets;//ontomany,
}
