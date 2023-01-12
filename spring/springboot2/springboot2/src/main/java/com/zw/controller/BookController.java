package com.zw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Value("${person.name}")
    private String name;

    @GetMapping("/{id}")
    public String getById(@PathVariable int id) {
        System.out.println("id: " + id + ",name: " + name);
        return "Hello Boot";
    }
}
