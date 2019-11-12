package com.gazizov.railwaymanager.persistence.daoimpl;

import com.gazizov.railwaymanager.persistence.pojo.TicketPO;
import com.gazizov.railwaymanager.persistence.dao.TicketDao;
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
            ticketPO.setPassengerPO(ticketPO.getPassengerPO());
            ticketPO.setTrainId(ticketPO.getTrainId());

        }

        entityManager.persist(ticketPO);
    }

    @Override
    public Collection<TicketPO> findAll() {
        return entityManager.createQuery("from TicketPO").getResultList();
    }

    @PersistenceContext(unitName = "pu_railwaymanager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
