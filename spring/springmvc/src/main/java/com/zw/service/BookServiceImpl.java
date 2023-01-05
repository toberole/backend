package com.zw.service;

import com.zw.dao.BookDao;

public class BookServiceImpl implements BookService {
    public BookDao bookDaoImpl;

    public void setBookDaoImpl(BookDao bookDaoImpl) {
        this.bookDaoImpl = bookDaoImpl;
    }

    public void save(){
        bookDaoImpl.save();
    }
}
