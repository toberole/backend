package com.zw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JumpView1 {
    @RequestMapping("/JumpView1/test1")
    public ModelAndView test1() {
        // ModelAndView 用来设置返回的视图
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", 123);
        modelAndView.addObject("hello1", "456");

        // 设置逻辑视图
        modelAndView.setViewName("test3");
        return modelAndView;
    }
}
