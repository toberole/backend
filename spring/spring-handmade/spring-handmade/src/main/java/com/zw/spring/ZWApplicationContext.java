package com.zw.spring;

public class ZWApplicationContext {
    public ZWApplicationContext(Class clazz) {
       ComponentScan componentScan = (ComponentScan) clazz.getAnnotation(ComponentScan.class);

    }
}
