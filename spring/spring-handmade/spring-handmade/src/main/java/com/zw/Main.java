package com.zw;

import com.zw.spring.ZWApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ZWApplicationContext zwApplicationContext = new ZWApplicationContext(SpringConfig.class);
    }
}