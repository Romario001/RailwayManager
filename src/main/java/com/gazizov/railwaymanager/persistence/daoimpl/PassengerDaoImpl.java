package com.gazizov.railwaymanager.persistence.daoimpl;

import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import com.gazizov.railwaymanager.persistence.dao.PassengerDao;
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

public class PassengerDaoImpl
        implements PassengerDao {

//    private final AtomicLong idGenerator = new AtomicLong();

    private EntityManager entityManager;

    @Transactional
    public void savePassenger(PassengerPO passengerPO) {
        if (Objects.isNull(passengerPO.getPassengerId())) {
//            passengerPO.setPassengerId(idGenerator.incrementAndGet());
            passengerPO.setFirstName(passengerPO.getFirstName());
            passengerPO.setLastName(passengerPO.getLastName());
            passengerPO.setPassword(passengerPO.getPassword());
            passengerPO.setLogin(passengerPO.getLogin());
            passengerPO.setRoleId(passengerPO.getRoleId());
            passengerPO.setPassengerTickets(passengerPO.getPassengerTickets());
        }

        entityManager.persist(passengerPO);
    }

    @Override
    public Collection<PassengerPO> findAll() {
        return entityManager.createQuery("from PassengerPO").getResultList();
    }

    @PersistenceContext(unitName = "pu_railwaymanager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
