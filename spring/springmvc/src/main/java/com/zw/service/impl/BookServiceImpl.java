package com.zw.service.impl;

import com.zw.dao.BookDao;
import com.zw.dao.UserDao;
import com.zw.factory.UserDaoFactoryBean;
import com.zw.service.BookService;

public class BookServiceImpl implements BookService {
    public BookDao bookDaoImpl;
    public UserDao userDaoImpl;

    public void setBookDaoImpl(BookDao bookDaoImpl) {
        this.bookDaoImpl = bookDaoImpl;
    }

    public void save() {
        bookDaoImpl.save();
        userDaoImpl.save();
    }

    public void setUserDaoImpl(UserDaoFactoryBean userDaoImpl) throws Exception {
        this.userDaoImpl = userDaoImpl.getObject();
    }
}
