package com.gazizov.railwaymanager.configuration;

import com.gazizov.railwaymanager.services.PassengerDao;
import com.gazizov.railwaymanager.services.impl.PassengerDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import java.util.Properties;

/**
 * 05.11.2019
 *
 * @author Roman Gazizov
 */
@Configuration
public class PersistenseConfiguration {

    @Bean
    public PassengerDao passengerDao() {
        Properties properties = System.getProperties();
        return new PassengerDaoImpl(entityManager());
    }

    @Bean
    public EntityManager entityManager() {
        return null;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        return null;
    }

}
