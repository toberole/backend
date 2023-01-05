package com.zw.springboot.domain;

public class Person {
    public String name;
    public int age;
    public String gender;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
