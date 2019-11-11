package com.gazizov.railwaymanager;

import com.gazizov.railwaymanager.configuration.PersistenceConfig;
import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import com.gazizov.railwaymanager.persistence.pojo.TicketPO;
import com.gazizov.railwaymanager.services.PassengerDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * 04.11.2019
 *
 * @author Roman Gazizov
 */
public class RailwayManagerApp {

//    public static void main(String[] args) {
//        try (Session session = getSession()) {
//            session.beginTransaction();
//
//            PassengerPO passengerPO1 = new PassengerPO();
//            passengerPO1.setLogin("Rom");
//            passengerPO1.setPassword("Rom");
//            passengerPO1.setFirstName("Roman");
//            passengerPO1.setLastName("Romanov");
//            passengerPO1.setBirthDate("11/12/13");
//
//            session.save(passengerPO1);
//
//            PassengerPO passengerPO2 = new PassengerPO();
//            passengerPO2.setLogin("Ivan");
//            passengerPO2.setPassword("Ivan");
//            passengerPO2.setFirstName("Ivan");
//            passengerPO2.setLastName("Ivanov");
//            passengerPO2.setBirthDate("01/02/03");
//
//            session.save(passengerPO2);
//
//            PassengerPO passengerPO3 = new PassengerPO();
//            passengerPO3.setLogin("Sam");
//            passengerPO3.setPassword("Sam");
//            passengerPO3.setFirstName("Sam");
//            passengerPO3.setLastName("Samov");
//            passengerPO3.setBirthDate("03/02/01");
//
//            session.save(passengerPO3);
//
//
//            session.getTransaction().commit();
//        } catch (Throwable cause) {
//            cause.printStackTrace();
//        }
//
//        List<PassengerPO> listOfPassenger = null;
//
//        try (Session session = getSession()) {
//            session.beginTransaction();
//
//            Query query = session.createQuery("FROM PassengerPO");
//            listOfPassenger = (List<PassengerPO>) query.list();
//
//            session.getTransaction().commit();
//
//        } catch (Throwable cause) {
//            cause.printStackTrace();
//        }
//
//        if (listOfPassenger != null && !listOfPassenger.isEmpty()) {
//            for (PassengerPO passengerPO : listOfPassenger) {
//                System.out.println(passengerPO);
//            }
//        }
//    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);

        PassengerDao passengerDao = context.getBean(PassengerDao.class);

        PassengerPO p1 = new PassengerPO();
        p1.setLogin("TheFirst");
        p1.setPassword("FirstMan");
        p1.setFirstName("First");
        p1.setLastName("First");
        p1.setBirthDate("01/02/03");
        p1.setRoleId(1);
        p1.setPassengerTickets(new ArrayList<>());

        passengerDao.savePassenger(p1);
        passengerDao.findAll().stream().forEach(System.out::println);
    }
}
