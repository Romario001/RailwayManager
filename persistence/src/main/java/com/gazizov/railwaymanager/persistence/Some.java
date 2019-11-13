package com.gazizov.railwaymanager.persistence;

import com.gazizov.railwaymanager.persistence.configuration.PersistenceConfig;
import com.gazizov.railwaymanager.persistence.dao.PassengerDao;
import com.gazizov.railwaymanager.persistence.dao.TrainDao;
import com.gazizov.railwaymanager.persistence.pojo.PassengerPO;
import com.gazizov.railwaymanager.persistence.pojo.TicketPO;
import com.gazizov.railwaymanager.persistence.pojo.TrainPO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * 04.11.2019
 *
 * @author Roman Gazizov
 */
public class Some {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);

        PassengerDao passengerDao = context.getBean(PassengerDao.class);
        TrainDao trainDao = context.getBean(TrainDao.class);

//        PassengerService passengerService = context.getBean(PassengerService.class);
//        TicketDao ticketDao = context.getBean(TicketDao.class);

        PassengerPO p1 = new PassengerPO();
        p1.setLogin("TheFirst");
        p1.setPassword("FirstMan");
        p1.setFirstName("First");
        p1.setLastName("First");
        p1.setBirthDate("01/02/03");
        p1.setRoleId(1);

        TrainPO trainPO1 = new TrainPO();
        trainPO1.setPassengerCount(10);
        trainDao.addTrain(trainPO1);


        TicketPO ticketPO1 = new TicketPO();
        ticketPO1.setPassengerPO(p1);

        ticketPO1.setTrainPO(trainPO1);

        List<TicketPO> tl1 = new ArrayList<TicketPO>();
        tl1.add(ticketPO1);

//        trainPO.setTrainTickets(tl1);

//        ticketPO1.setTrainId(1L);
//        ticketPO1.setTicketId();

        p1.setPassengerTickets(tl1);

        passengerDao.savePassenger(p1);
        passengerDao.findAll().stream().forEach(System.out::println);


//        System.out.println();
//        System.out.println(passengerService.findPassengerByLoginAndCheckPassword("TheFirst3", "FirstMan"));


    }
}
