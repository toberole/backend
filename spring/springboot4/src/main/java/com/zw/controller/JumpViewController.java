package com.zw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JumpView {
    @RequestMapping("/test1")
    public ModelAndView test1() {
        // ModelAndView 用来设置返回的视图
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", 123);
        modelAndView.addObject("hello1", "456");

        // 设置逻辑视图
        modelAndView.setViewName("test1");
        return modelAndView;
    }

    @RequestMapping("/test2")
    public String test2(Model model) {// 注意返回值就是返回的view的名称
        model.addAttribute("hello", 123);
        // 返回的html 需要放在templates目录下面
        String view = "test2";
        return view;
    }
}
