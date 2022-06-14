package com.junbin.springcloud.Commom.service;

import java.io.Serializable;

public class ServiceResult<T> implements Serializable {
    private static final long serialVersionUID = 4173167326671661848L;
    private Boolean success;

    private String mess;

    private T data;

    public ServiceResult() {}

    public ServiceResult(Boolean success, String mess, T data) {
        this.success = success;
        this.mess = mess;
        this.data = data;
    }
}
