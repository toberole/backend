package com.zw.domain;

public class Book {
    public Long id;

    public String name;
    public double price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
