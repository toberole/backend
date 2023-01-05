package com.zw.dao.impl;

import com.zw.dao.BookDao;

public class BookDaoImpl implements BookDao {
    public BookDaoImpl() {
        System.out.println("BookDaoImpl ......");
    }

    @Override
    public void save() {
        System.out.println("BookDaoImpl save ......");
    }

    public void init(){
        System.out.println("BookDaoImpl init ......");
    }

    public void destroy(){
        System.out.println("BookDaoImpl destroy ......");
    }
}
