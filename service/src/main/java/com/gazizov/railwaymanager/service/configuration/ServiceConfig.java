package com.gazizov.railwaymanager.service.configuration;

import com.gazizov.railwaymanager.persistence.configuration.PersistenceConfig;
import com.gazizov.railwaymanager.service.OptimizeRouteService;
import com.gazizov.railwaymanager.service.PassengerService;
import com.gazizov.railwaymanager.service.RouteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 14.11.2019
 *
 * @author Roman Gazizov
 */

@Configuration
//@ComponentScan(basePackages = "com.gazizov.railwaymanager.service")
@Import(PersistenceConfig.class)
public class ServiceConfig {

    private final PersistenceConfig persistenceConfig;

    public ServiceConfig(PersistenceConfig persistenceConfig) {
        this.persistenceConfig = persistenceConfig;
    }

    @Bean
    public PassengerService passengerService() {
        return new PassengerService();
    }

    @Bean
    public RouteService routeService() {
        return new RouteService();
    }

    @Bean
    public OptimizeRouteService optimizeRouteService() {
        return new OptimizeRouteService();
    }
}
