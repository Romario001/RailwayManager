package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 25.10.2019
 *
 * @author Roman Gazizov
 */

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class TicketPO {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @ManyToOne(targetEntity = TrainPO.class)
    @Column(name = "train_id")
    private Integer trainId;

    @ManyToOne(targetEntity = PassengerPO.class)
    @Column(name = "passenger_id")
    private Integer passengerId;

}
