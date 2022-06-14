package com.junbin.springcloud.Commom.controller;


import com.junbin.springcloud.Commom.resultcode.BaseResultCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class HttpResult<T> implements Serializable {

    private static final long serialVersionUID = 8576705255973815976L;
    private Boolean success;

    private String code;

    private String mess;

    private T data;

    public HttpResult() {
    }

    public HttpResult(Boolean success, String code, String mess, T data) {
        this.success = success;
        this.code = code;
        this.mess = mess;
        this.data = data;
    }

    public HttpResult(Boolean success, BaseResultCode resultCode, T data) {
        this.success = success;
        this.code = resultCode.getCode();
        this.mess = resultCode.getMessage();
        this.data = data;
    }

}