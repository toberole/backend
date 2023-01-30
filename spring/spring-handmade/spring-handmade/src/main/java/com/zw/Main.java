package com.zw;

import com.zw.spring.ZWApplicationContext;
import com.zw.test.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Test test = new Test();
        String sys = test.sys();
        ZWApplicationContext zwApplicationContext = new ZWApplicationContext(SpringConfig.class);
    }
}