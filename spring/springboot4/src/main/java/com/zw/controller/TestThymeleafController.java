package com.zw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestThymeleafController {
    @RequestMapping("/test/thymeleaf_page")
    public String test1(Model model) {
        System.out.println("test1 model: " + model);
        model.addAttribute("data", "test thymeleaf ......");
        // thymeleaf_page 为对应页面的名称
        return "thymeleaf_page";
    }
}
