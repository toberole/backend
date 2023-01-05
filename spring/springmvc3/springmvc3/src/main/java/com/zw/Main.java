package com.zw;

import com.zw.config.SpringConfig;
import com.zw.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}