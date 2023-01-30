package com.zw.dao.impl;

import com.zw.bean.User;
import com.zw.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(User user) {
        System.out.println(user);
        return 0;
    }
}
