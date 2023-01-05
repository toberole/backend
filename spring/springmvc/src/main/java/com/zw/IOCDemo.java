package com.zw;

import com.zw.dao.impl.BookDaoImpl;
import com.zw.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 第一步，添加依赖
 * 修改pom.xml文件
 * <dependency>
 * <groupId>org.springframework</groupId>
 * <artifactId>spring-context</artifactId>
 * <version>5.3.15</version>
 * </dependency>
 * 第二步，添加bean配置文件,也可以使用注解
 * 在resources文件夹下面创建一个applicationContext.xml
 * 第三步，使用ioc
 */
public class IOCDemo {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // 获取IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取bean
        BookDaoImpl bookDao = (BookDaoImpl) applicationContext.getBean("bookDao");
        System.out.println(bookDao);
        bookDao = (BookDaoImpl) applicationContext.getBean("bookDao");
        System.out.println(bookDao);

        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.save();
    }
}