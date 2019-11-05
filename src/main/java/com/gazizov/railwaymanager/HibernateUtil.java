package com.gazizov.railwaymanager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 04.11.2019
 *
 * @author Roman Gazizov
 */
public class HibernateUtil {

    private static final SessionFactory currentSessionFactory;

    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();

            currentSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }

    }

    public static Session getSession() throws HibernateException{
        return currentSessionFactory.openSession();
    }
}
