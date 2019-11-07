package com.gazizov.railwaymanager.persistence.DaoImpl;

import com.gazizov.railwaymanager.persistence.pojo.UserPO;
import lombok.AllArgsConstructor;
import com.gazizov.railwaymanager.persistence.dao.UserDao;

import javax.persistence.EntityManager;
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

    private EntityManager entityManager;

    @Override
    public void saveUser(UserPO userPO) {
        entityManager.persist(userPO);
    }

    @Override
    public Collection<UserPO> findAll() {
        Query query = entityManager.createQuery("select * from UserPO.class");
        return query.getResultList();
    }
}
