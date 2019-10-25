package com.gazizov.railwaymanager.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 25.10.2019
 *
 * @author Roman Gazizov
 */

@Getter
@Setter
public class Passenger {

    private Integer passengerId;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String birthDate;

    //private Boolean active;

    private List<Role> roles = new ArrayList<>();
    private List<Ticket> passengerTickets;
}
