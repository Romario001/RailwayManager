package com.gazizov.railwaymanager.persistence.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import com.gazizov.railwaymanager.persistence.DaoImpl.UserDaoImpl1;
import com.gazizov.railwaymanager.persistence.dao.UserDao;

import javax.persistence.EntityManager;
import java.util.Properties;

/**
 * 06.11.2019
 *
 * @author Roman Gazizov
 */
public class PersistenceConfig {

    @Bean
    public UserDao UserDao() {
        Properties properties = System.getProperties();
        return new UserDaoImpl1(entityManager());
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
