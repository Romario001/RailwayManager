package com.gazizov.railwaymanager.persistence.DaoImpl;

import com.gazizov.railwaymanager.persistence.dao.UserDao;
import com.gazizov.railwaymanager.persistence.pojo.UserPO;
import lombok.AllArgsConstructor;

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

    private EntityManagerFactory entityManagerFactory;

    public UserDaoImpl1(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }



    @Override
    public void saveUser(UserPO userPO) {
        entityManagerFactory.createEntityManager().persist(userPO);
    }

    @Override
    public List findAll() {
        Query query = entityManagerFactory.createEntityManager().createQuery("from UserPO");
        return query.getResultList();
    }
}
