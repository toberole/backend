package com.zw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/users/save")
    @ResponseBody
    public String save() {
        return "Hello_" + System.currentTimeMillis();
    }
}
