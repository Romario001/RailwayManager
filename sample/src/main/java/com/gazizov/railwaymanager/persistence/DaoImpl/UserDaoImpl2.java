package com.gazizov.railwaymanager.persistence.DaoImpl;

import com.gazizov.railwaymanager.persistence.dao.UserDao;
import com.gazizov.railwaymanager.persistence.pojo.UserPO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 06.11.2019
 *
 * @author Roman Gazizov
 */


@AllArgsConstructor
public class UserDaoImpl2
        implements UserDao {

    public ArrayList<UserPO> userPOList;

    @Override
    public void saveUser(UserPO userPO) {
        userPOList.add(userPO);
    }

    @Override
    public Collection<UserPO> findAll() {
        return userPOList;
    }
}

