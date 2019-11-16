package com.gazizov.railwaymanager;


import com.gazizov.railwaymanager.persistence.dao.*;
import com.gazizov.railwaymanager.service.OptimizeRouteService;
import com.gazizov.railwaymanager.service.PassengerService;
import com.gazizov.railwaymanager.service.RouteService;
import com.gazizov.railwaymanager.service.configuration.ServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 04.11.2019
 *
 * @author Roman Gazizov
 */
public class RailwayManagerApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);

        PassengerDao passengerDao = context.getBean(PassengerDao.class);
        TrainDao trainDao = context.getBean(TrainDao.class);
        TicketDao ticketDao = context.getBean(TicketDao.class);
        RouteDao routeDao = context.getBean(RouteDao.class);
        StationDao stationDao = context.getBean(StationDao.class);
        RouteSegmentDao routeSegmentDao = context.getBean(RouteSegmentDao.class);

        PassengerService passengerService = context.getBean(PassengerService.class);
        RouteService routeService = context.getBean(RouteService.class);
        OptimizeRouteService optimizeRouteService = context.getBean(OptimizeRouteService.class);


        try {
            System.out.println(optimizeRouteService.findCountOfStationsByTheWay(1,4));
        } catch (Exception e) {
            e.printStackTrace();
        }
////        TicketDao ticketDao = context.getBean(TicketDao.class);
//
//        PassengerPO p1 = new PassengerPO();
//        p1.setLogin("TheFirst");
//        p1.setPassword("FirstMan");
//        p1.setFirstName("First");
//        p1.setLastName("First");
//        p1.setBirthDate("01/02/03");
//        p1.setRoleId(1);
//
//        TrainPO trainPO1 = new TrainPO();
//        trainPO1.setPassengerCount(10);
//        trainDao.addTrain(trainPO1);
//
//
//        TicketPO ticketPO1 = new TicketPO();
//        ticketPO1.setPassengerPO(p1);
//
//        ticketPO1.setTrainPO(trainPO1);
//
//        List<TicketPO> tl1 = new ArrayList<TicketPO>();
//        tl1.add(ticketPO1);
//
////        trainPO.setTrainTickets(tl1);
//
////        ticketPO1.setTrainId(1L);
////        ticketPO1.setTicketId();
//
//        p1.setPassengerTickets(tl1);
//
//        passengerDao.savePassenger(p1);
////        passengerDao.findAll().stream().forEach(System.out::println);
//
//
//        System.out.println();
//        System.out.println(passengerService.findPassengerByLoginAndCheckPassword("TheFirst", "FirstMan"));
//
//        StationPO stationPO1 = new StationPO();
//        stationPO1.setStationName("Moskva - St.Peterburg");
//        stationDao.addStation(stationPO1);
//
//        RoutePO routePO1 = new RoutePO();
//        routePO1.setRouteName("Capitals");
//        routeDao.saveRoute(routePO1);
//
//
//        System.out.println(routeService.findAllRoutesByStation(1));



    }
}
