package com.zw.services.impl;

import com.zw.dao.UserDao;
import com.zw.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;

    @Override
    public void save() {
        System.out.println("UserServiceImpl save ......");
        userDao.save(1, "hello");
    }
}
