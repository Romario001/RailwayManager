package com.gazizov.railwaymanager.persistence.dao;

import com.gazizov.railwaymanager.persistence.pojo.UserPO;

import java.util.List;

/**
 * 06.11.2019
 *
 * @author Roman Gazizov
 */


public interface UserDao {

    void saveUser(UserPO userPO);

    List findAll();
}
