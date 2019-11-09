package com.gazizov.railwaymanager.persistence.Configuration;

import com.gazizov.railwaymanager.persistence.DaoImpl.UserDaoImpl1;
import com.gazizov.railwaymanager.persistence.dao.UserDao;
import com.google.common.base.Preconditions;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.PersistenceContext;
import java.util.Properties;

/**
 * 06.11.2019
 *
 * @author Roman Gazizov
 */

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence-mysql.properties")
@ComponentScan("com.gazizov.railwaymanager.persistence")
public class PersistenceConfig {

    private final Environment environment;

    public PersistenceConfig(Environment environment) {
        super();
        this.environment = environment;
    }

    @Bean
    public UserDao userDao() {
//        Properties properties = System.getProperties();
        return new UserDaoImpl1(entityManagerFactory().getNativeEntityManagerFactory());
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.gazizov.railwaymanager.persistence.pojo");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(Preconditions.checkNotNull(environment.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUsername(Preconditions.checkNotNull(environment.getProperty("spring.datasource.username")));
        dataSource.setPassword(Preconditions.checkNotNull(environment.getProperty("spring.datasource.password")));
        dataSource.setUrl(Preconditions.checkNotNull(environment.getProperty("spring.datasource.url")));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("com.gazizov.railwaymanager");
        localSessionFactoryBean.setHibernateProperties(additionalProperties());

        return localSessionFactoryBean;
    }


    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(sessionFactory);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", Preconditions.checkNotNull(environment.getProperty("hibernate.dialect")));
        properties.setProperty("hibernate.hbm2ddl.auto", Preconditions.checkNotNull(environment.getProperty("hibernate.hbm2ddl.auto")));
        properties.setProperty("hibernate.connection.pool_size", Preconditions.checkNotNull(environment.getProperty("hibernate.connection.pool_size")));
        properties.setProperty("hibernate.show_sql", Preconditions.checkNotNull(environment.getProperty("hibernate.show_sql")));
        properties.setProperty("hibernate.current_session_context_class", Preconditions.checkNotNull(environment.getProperty("hibernate.current_session_context_class")));
        properties.setProperty("hibernate.connection.CharSet", Preconditions.checkNotNull(environment.getProperty("hibernate.connection.CharSet")));
        properties.setProperty("hibernate.connection.characterEncoding", Preconditions.checkNotNull(environment.getProperty("hibernate.connection.characterEncoding")));
        properties.setProperty("hibernate.connection.useUnicode", Preconditions.checkNotNull(environment.getProperty("hibernate.connection.useUnicode")));

        return properties;
    }

}
