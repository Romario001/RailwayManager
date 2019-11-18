package com.gazizov.railwaymanager.persistence.configuration;


import com.gazizov.railwaymanager.persistence.dao.*;
import com.gazizov.railwaymanager.persistence.daoimpl.*;
import com.gazizov.railwaymanager.persistence.pojo.RouteSegmentsPO;
import com.gazizov.railwaymanager.persistence.pojo.StationPO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * 06.11.2019passengers
 *
 * @author Roman Gazizov
 */

@Configuration
@ComponentScan
@EnableTransactionManagement
public class PersistenceConfig {

    @Bean
    public PassengerDao passengerDao() {
        return new PassengerDaoImpl();
    }

    @Bean
    public TicketDao ticketDao() {
        return new TicketDaoImpl();
    }

    @Bean
    public StationDao stationDao() {
        return new StationDaoImpl();
    }

    @Bean
    public TrainDao trainDao() {
        return new TrainDaoImpl();
    }


    @Bean
    public StationPO stationPO() {
        return new StationPO();
    }

    @Bean
    public RouteSegmentsPO routeSegmentPO() {
        return new RouteSegmentsPO();
    }

    @Bean
    public RouteSegmentDao routeSegmentDao() {
        return new RouteSegmentDaoImpl();
    }

    @Bean
    public RouteDao routeDao() {
        return new RouteDaoImpl();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(PersistenceUnitManager
                                                                               persistenceUnitManager) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory
                = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setPersistenceUnitName("pu_railwaymanager");
        entityManagerFactory.setPersistenceUnitManager(persistenceUnitManager);

        return entityManagerFactory;
    }


    @Bean
    public PersistenceUnitManager persistenceUnitManager(final DataSource dataSource) {
        DefaultPersistenceUnitManager persistenceUnitManager = new DefaultPersistenceUnitManager();

        persistenceUnitManager.setDataSources(new HashMap<String, DataSource>() {
            {
                put("ds_railwaymanager", dataSource);
            }
        });
        persistenceUnitManager.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");

        return persistenceUnitManager;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

//        dataSource.setDriverClassName(Preconditions.checkNotNull(environment.getProperty("spring.datasource.driver-class-name")));
//        dataSource.setUsername(Preconditions.checkNotNull(environment.getProperty("spring.datasource.username")));
//        dataSource.setPassword(Preconditions.checkNotNull(environment.getProperty("spring.datasource.password")));
//        dataSource.setUrl(Preconditions.checkNotNull(environment.getProperty("spring.datasource.url")));

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setUrl("jdbc:mysql://localhost:3306" +
                "/railwaymanager?useUnicode=true&serverTimezone=UTC&createDatabaseIfNotExists=true");

        return dataSource;
    }

//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
//        localSessionFactoryBean.setDataSource(dataSource());
//        localSessionFactoryBean.setPackagesToScan("com.gazizov.railwaymanager");
//        localSessionFactoryBean.setHibernateProperties(additionalProperties());
//
//        return localSessionFactoryBean;
//    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }


//    private Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", Preconditions.checkNotNull(environment.getProperty("hibernate.dialect")));
//        properties.setProperty("hibernate.hbm2ddl.auto", Preconditions.checkNotNull(environment.getProperty("hibernate.hbm2ddl.auto")));
//        properties.setProperty("hibernate.connection.pool_size", Preconditions.checkNotNull(environment.getProperty("hibernate.connection.pool_size")));
//        properties.setProperty("hibernate.show_sql", Preconditions.checkNotNull(environment.getProperty("hibernate.show_sql")));
//        properties.setProperty("hibernate.current_session_context_class", Preconditions.checkNotNull(environment.getProperty("hibernate.current_session_context_class")));
//        properties.setProperty("hibernate.connection.CharSet", Preconditions.checkNotNull(environment.getProperty("hibernate.connection.CharSet")));
//        properties.setProperty("hibernate.connection.characterEncoding", Preconditions.checkNotNull(environment.getProperty("hibernate.connection.characterEncoding")));
//        properties.setProperty("hibernate.connection.useUnicode", Preconditions.checkNotNull(environment.getProperty("hibernate.connection.useUnicode")));
//
//        return properties;
//    }

}
