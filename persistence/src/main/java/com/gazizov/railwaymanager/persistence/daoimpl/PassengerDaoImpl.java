package com.gazizov.railwaymanager.persistence.daoimpl;


import com.gazizov.railwaymanager.persistence.dao.PassengerDao;
import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
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
//            passengerPO.setPassengerTickets(passengerPO.getPassengerTickets());
        }

        entityManager.persist(passengerPO);
    }

    @Override
    public Collection<PassengerPO> findAll() {
        return entityManager.createQuery("from PassengerPO").getResultList();
    }

    @Transactional
    public PassengerPO findByLogin(String login) {
        String queryString = "SELECT u FROM PassengerPO u WHERE LOWER(u.login) = :login";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("login", login.toLowerCase());
        List<PassengerPO> list = query.getResultList();
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @PersistenceContext(unitName = "pu_railwaymanager")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
