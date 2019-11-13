package com.gazizov.railwaymanager.daoimpl;

import com.gazizov.railwaymanager.pojo.PassengerPO;
import com.gazizov.railwaymanager.pojo.TicketPO;
import com.gazizov.railwaymanager.dao.TicketDao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Objects;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */

public class TicketDaoImpl
        implements TicketDao {

//    private final AtomicLong idGenerator = new AtomicLong();

    private EntityManager entityManager;

    @Transactional
    public void saveTicket(TicketPO ticketPO) {
        if (Objects.isNull(ticketPO.getTicketId())) {
//            passengerPO.setPassengerId(idGenerator.incrementAndGet());
//            ticketPO.setPassengerPO(ticketPO.getPassengerPO());
//            ticketPO.setTrainId(ticketPO.getTrainId());

        }

        entityManager.persist(ticketPO);
    }

    @PersistenceContext(unitName = "pu_railwaymanager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void buyTicket(PassengerPO passengerPO) {

    }

    @Override
    public Collection<TicketPO> findAllTicketsToTrain() {
        return null;
    }
}
