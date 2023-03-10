package com.zw.dao.impl;

import com.zw.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Value("${name}")
    public String name;

    @Override
    public void save() {
        System.out.println("UserDaoImpl save ......" + name);
    }
}
