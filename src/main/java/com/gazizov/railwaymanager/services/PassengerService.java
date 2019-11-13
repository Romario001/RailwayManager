package com.gazizov.railwaymanager.services;

import com.gazizov.railwaymanager.persistence.dao.PassengerDao;
import com.gazizov.railwaymanager.persistence.daoimpl.PassengerDaoImpl;
import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;

import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
public class PassengerService {

    PassengerDaoImpl passengerDaoImpl = new PassengerDaoImpl();

    PassengerPO createPassenger(String login, String pwd,
                                String firstName, String lastName, String birthDate) {

        return null;

    }

    public Boolean findPassengerByLoginAndCheckPassword(String login, String password) {
        PassengerPO passengerPO = passengerDaoImpl.findByLogin(login);
        if (passengerPO != null) {
            if (password.isEmpty()) {
                System.out.println("Enter password");
                return false;
            } else {
                if (password.equals(passengerPO.getPassword())) {
                    return true;
                } else {
                    System.out.println("Incorrect password");
                }
            }
        } else {
            return false;
        }
        return false;
    }

    void updatePassenger(String login, String pwd) {

    }

    void deletePassenger(String login, String pwd) {


    }


}

