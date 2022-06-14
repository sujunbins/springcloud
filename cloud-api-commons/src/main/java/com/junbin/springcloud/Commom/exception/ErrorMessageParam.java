package com.junbin.springcloud.Commom.exception;

public class ErrorMessageParam {
    private Object[] params;

    private ErrorMessageParam() {
    }

    public static ErrorMessageParam setParams(Object... o) {
        ErrorMessageParam errorMessageParam = new ErrorMessageParam();
        errorMessageParam.params = o;
        return errorMessageParam;
    }

    public Object[] getParams() {
        return this.params;
    }
}
