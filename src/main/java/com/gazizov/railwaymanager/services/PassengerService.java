package com.gazizov.railwaymanager.services;

import com.gazizov.railwaymanager.persistence.dao.PassengerDao;
import com.gazizov.railwaymanager.persistence.daoimpl.PassengerDaoImpl;
import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
public class PassengerService {

    @Autowired
    PassengerDao passengerDao;

    PassengerPO createPassenger(String login, String pwd,
                                String firstName, String lastName, String birthDate) {

        return null;

    }

    public PassengerPO findPassengerByLoginAndCheckPassword(String login, String password) {
        PassengerPO passengerPO = passengerDao.findByLogin(login);
        if (passengerPO != null) {
            if (password.isEmpty()) {
                System.out.println("Enter password");
                return null;
            } else {
                if (password.equals(passengerPO.getPassword())) {
                    return passengerPO;
                } else {
                    System.out.println("Incorrect password");
                }
            }
        } else {
            return null;
        }
        return null;
    }

    void updatePassenger(String login, String pwd) {

    }

    void deletePassenger(String login, String pwd) {


    }


}

