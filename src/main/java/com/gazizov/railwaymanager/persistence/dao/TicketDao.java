package com.gazizov.railwaymanager.persistence.dao;

import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import com.gazizov.railwaymanager.persistence.pojo.TicketPO;

import java.util.Collection;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
public interface TicketDao {

    void buyTicket(PassengerPO passengerPO);

    void saveTicket(TicketPO ticketPO);

    Collection<TicketPO> findAllTicketsToTrain();
}
