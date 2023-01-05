package com.zw.factory;

import com.zw.dao.OrderDao;
import com.zw.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }
}
