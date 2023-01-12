package com.zw.controller;

import com.zw.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/test")
    public void save() {
        System.out.println("save ......");
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        User user = new User();
        user.id = id;
        System.out.println(user);
        return user;
    }
}
