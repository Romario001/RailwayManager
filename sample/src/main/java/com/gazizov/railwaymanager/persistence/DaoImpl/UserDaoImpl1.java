package com.gazizov.railwaymanager.persistence.DaoImpl;

import com.gazizov.railwaymanager.persistence.dao.UserDao;
import com.gazizov.railwaymanager.persistence.pojo.UserPO;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 06.11.2019
 *
 * @author Roman Gazizov
 */


public class UserDaoImpl1
        implements UserDao {

    private EntityManager entityManager;

    public UserDaoImpl1(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void saveUser(UserPO userPO) {
        entityManager.persist(userPO);
    }

    @Override
    public List findAll() {
        Query query = entityManager.createQuery("from UserPO");
        return query.getResultList();
    }
}
