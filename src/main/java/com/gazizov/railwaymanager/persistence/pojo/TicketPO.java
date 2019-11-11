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
    private Long ticketId;

    //@ManyToOne(targetEntity = TrainPO.class)
    @Column(name = "train_id")
    private Long trainId;

    @ManyToOne(targetEntity = PassengerPO.class)
    @JoinColumn (name = "passenger_id")
    private PassengerPO passengerPO;

}
