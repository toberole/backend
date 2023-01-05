package com.zw;

import com.zw.config.SpringConfig;
import com.zw.config.SpringConfig1;
import com.zw.dao.UserDao;
import com.zw.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//        userDao.save();
//
//        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
//        userService.save();

        // 注解方案
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//        userDao.save();
//
//        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
//        userService.save();
//
//        applicationContext.registerShutdownHook();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig1.class);
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);
        applicationContext.registerShutdownHook();
    }
}