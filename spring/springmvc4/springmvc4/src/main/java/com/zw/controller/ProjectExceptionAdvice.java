package com.zw.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 异常处理
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public void doHandler(Exception exception) {
        System.out.println("doHandler: " + exception.getMessage());
    }
}
