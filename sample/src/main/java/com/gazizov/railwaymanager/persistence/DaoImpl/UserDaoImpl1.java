package com.gazizov.railwaymanager.persistence.DaoImpl;

import com.gazizov.railwaymanager.persistence.dao.UserDao;
import com.gazizov.railwaymanager.persistence.pojo.UserPO;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collection;

/**
 * 06.11.2019
 *
 * @author Roman Gazizov
 */

@AllArgsConstructor
public class UserDaoImpl1
        implements UserDao {

    private EntityManagerFactory entityManagerFactory;

    @Override
    public void saveUser(UserPO userPO) {
        entityManagerFactory.createEntityManager().persist(userPO);
    }

    @Override
    public Collection<UserPO> findAll() {
        Query query = entityManagerFactory.createEntityManager().createQuery("select login from UserPO.class");
        return query.getResultList();
    }
}
