package com.gazizov.railwaymanager.services;

import javax.transaction.Transactional;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
public interface PassengerService {

    void createPassenger(String login, String pwd);
}

class PassengerServiceImpl implements PassengerService {

    @Override
    public void createPassenger(String login, String pwd) {

    }
}
