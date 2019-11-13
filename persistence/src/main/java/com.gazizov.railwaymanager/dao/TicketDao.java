package com.gazizov.railwaymanager.dao;

import com.gazizov.railwaymanager.pojo.PassengerPO;
import com.gazizov.railwaymanager.pojo.TicketPO;

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
