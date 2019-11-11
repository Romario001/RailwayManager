package com.gazizov.railwaymanager.services;

import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import com.gazizov.railwaymanager.persistence.pojo.TicketPO;

import java.util.Collection;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
public interface TicketDao {

    void saveTicket(TicketPO ticketPO);

    Collection<TicketPO> findAll();
}
