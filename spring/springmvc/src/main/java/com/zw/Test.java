package com.zw;

import org.reflections.Reflections;

import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Reflections reflections = new Reflections("");
        Set<Class<? extends SomeType>> subTypes = reflections.getSubTypesOf(SomeType.class);
        for (Class t : subTypes) {
            System.out.println(t.getName());
        }
    }
}
