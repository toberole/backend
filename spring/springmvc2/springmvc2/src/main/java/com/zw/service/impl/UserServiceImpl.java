package com.zw.service.impl;

import com.zw.dao.UserDao;
import com.zw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

@Service("userServiceImpl")
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Autowired
    // 指定注入的类
    @Qualifier("userDao")
    public UserDao userDao;

    @PostConstruct()
    public void init() {
        System.out.println("UserServiceImpl init ......");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserServiceImpl destroy ......");
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl save ......");
        userDao.save();
    }
}
