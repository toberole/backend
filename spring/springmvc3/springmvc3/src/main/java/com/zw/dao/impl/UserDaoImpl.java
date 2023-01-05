package com.zw.dao.impl;

import com.zw.dao.UserDao;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save(int a,String b) {
        System.out.println("UserDaoImpl save ......");
    }
}
