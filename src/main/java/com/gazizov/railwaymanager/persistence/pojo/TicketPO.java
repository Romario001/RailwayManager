package com.gazizov.railwaymanager.persistence.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

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

    @ManyToOne
    @JoinColumn(name = "train_id")
    private TrainPO trainPO;

//    @Column(name = "train_id")
//    private Integer trainId;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private PassengerPO passengerPO;


    @Override
    public String toString() {
        return "TicketPO{" +
                "ticketId=" + ticketId;
    }
}
