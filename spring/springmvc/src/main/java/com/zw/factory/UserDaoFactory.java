package com.zw.factory;

import com.zw.dao.UserDao;
import com.zw.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
