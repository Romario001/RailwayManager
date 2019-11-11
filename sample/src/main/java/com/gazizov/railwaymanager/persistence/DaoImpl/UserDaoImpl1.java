package com.gazizov.railwaymanager.persistence.DaoImpl;

import com.gazizov.railwaymanager.persistence.dao.UserDao;
import com.gazizov.railwaymanager.persistence.pojo.UserPO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 06.11.2019
 *
 * @author Roman Gazizov
 */


public class UserDaoImpl1
        implements UserDao {

    private final AtomicLong idGenerator = new AtomicLong();

    private EntityManager entityManager;

    @Transactional
    public void saveUser(UserPO userPO) {
        if (Objects.isNull(userPO.getUserId())) {
            userPO.setUserId(idGenerator.incrementAndGet());
            userPO.setFirstName(userPO.getFirstName());
            userPO.setLastName(userPO.getLastName());
            userPO.setPassword(userPO.getPassword());
            userPO.setLogin(userPO.getLogin());
        }

        entityManager.persist(userPO);
    }

    @Override
    public Collection<UserPO> findAll() {
        return entityManager.createQuery("from UserPO").getResultList();
    }

    @PersistenceContext(unitName = "pu_sample")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
