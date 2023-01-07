package com.zw.bean;

public class User {
    public Integer id;
    public String name;
    public Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
