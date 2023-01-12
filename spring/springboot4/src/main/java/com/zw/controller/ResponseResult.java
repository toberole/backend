package com.zw.controller;

public class ResponseResult {
    public int code;
    public String msg;
    public Object data;

    public ResponseResult(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
