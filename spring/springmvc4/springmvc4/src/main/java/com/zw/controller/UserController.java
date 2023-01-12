package com.zw.controller;

import com.zw.bean.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public Result save() {
        return new Result(0, "hello_" + System.currentTimeMillis());
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return "Hello_" + id;
    }

    @PostMapping("/update")
    public String update(@RequestBody User user) {
        System.out.println(user);
        return user.toString();
    }
}
