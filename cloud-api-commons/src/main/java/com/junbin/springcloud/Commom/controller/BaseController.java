package com.junbin.springcloud.Commom.controller;


import com.junbin.springcloud.Commom.resultcode.BaseResultCodeEnum;

public class BaseController {


    protected <T> HttpResult<T> successResult(T data) {
        return new HttpResult<T>(true, BaseResultCodeEnum.SUCCESS.getCode(), BaseResultCodeEnum.SUCCESS.getMessage(), data);
    }

    protected <T> HttpResult<T> successResult(BaseResultCodeEnum resultcode, T data) {
        return new HttpResult<T>(true, resultcode.getCode(), resultcode.getMessage(), data);
    }

    protected <T> HttpResult<T> successResult(String message, T data) {
        return new HttpResult<T>(true, BaseResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    protected <T> HttpResult<T> errorResult(T data) {
        return new HttpResult<T>(false, BaseResultCodeEnum.FAILD.getCode(), BaseResultCodeEnum.FAILD.getMessage(), data);
    }

    protected <T> HttpResult<T> errorResult(String message, T data) {
        return new HttpResult<T>(false, BaseResultCodeEnum.FAILD.getCode(), message, data);
    }

    protected <T> HttpResult<T> errorResult(BaseResultCodeEnum resultcode, T data) {
        return new HttpResult<T>(false, resultcode.getCode(), resultcode.getMessage(), data);
    }



}


