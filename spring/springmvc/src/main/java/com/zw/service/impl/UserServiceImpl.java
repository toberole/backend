package com.zw.service.impl;

import com.zw.dao.UserDao;
import com.zw.service.UserService;

public class UserServiceImpl implements UserService {
    public UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl save ......");
    }
}
