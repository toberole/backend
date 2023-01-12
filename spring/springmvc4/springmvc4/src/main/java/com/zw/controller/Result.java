package com.zw.controller;

public class Result {
    public Integer code;
    public String msg;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Object data;
}
