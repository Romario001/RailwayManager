package com.gazizov.railwaymanager;

import com.gazizov.railwaymanager.persistence.Configuration.PersistenceConfig;
import com.gazizov.railwaymanager.persistence.DaoImpl.UserDaoImpl1;
import com.gazizov.railwaymanager.persistence.DaoImpl.UserDaoImpl2;
import com.gazizov.railwaymanager.persistence.dao.UserDao;
import com.gazizov.railwaymanager.persistence.pojo.UserPO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 07.11.2019
 *
 * @author Roman Gazizov
 */
public class StartApp {


    private static UserDao userDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);

        if (false) {
            userDao = context.getBean(UserDaoImpl1.class);
        } else {
            userDao = new UserDaoImpl2();
        }

        List<UserPO> userPOList = new ArrayList<>();

        UserPO User1 = new UserPO();
        User1.setLogin("Flash");
        User1.setPassword("Flash");
        User1.setFirstName("Flash");
        User1.setLastName("Flash");
        User1.setUserId(1);

        userPOList.add(User1);

        System.out.println(userPOList);
        System.out.println(User1);

        userDao.saveUser(User1);

        userDao.findAll().

                stream().

                forEach(System.out::println);
    }
}
