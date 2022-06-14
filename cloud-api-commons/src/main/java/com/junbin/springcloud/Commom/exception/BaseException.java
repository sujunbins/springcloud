package com.junbin.springcloud.Commom.exception;

import com.junbin.springcloud.Commom.Util.JSONUtils;
import com.junbin.springcloud.Commom.resultcode.BaseResultCode;



import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -685897613245421593L;

    protected String code;

    protected String message;

    public BaseException() {
    }

    protected BaseException(Throwable cause) {
        super(cause);
    }

    protected BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    protected BaseException(BaseResultCode e, String message) {
        Class<? extends BaseResultCode> clazz = e.getClass();
        try {
            Method getCode = clazz.getMethod("getCode");
            this.code = (String) getCode.invoke(e);
            this.message = message;
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }

    protected BaseException(BaseResultCode e) {
        Class<? extends BaseResultCode> clazz = e.getClass();
        try {
            Method getCode = clazz.getMethod("getCode");
            Method getMessage = clazz.getMethod("getMessage");
            this.code = (String) getCode.invoke(e);
            this.message = (String) getMessage.invoke(e);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }

    protected BaseException(BaseResultCode e, ErrorMessageParam errorMessageParam) {
        Class<? extends BaseResultCode> clazz = e.getClass();
        try {
            Method getCode = clazz.getMethod("getCode");
            Method getMessage = clazz.getMethod("getMessage");
            this.code = (String) getCode.invoke(e);
            this.message = (String) getMessage.invoke(e);
            Object[] formatArgs = errorMessageParam.getParams();
            if (errorMessageParam != null && errorMessageParam.getParams() != null
                    && errorMessageParam.getParams().length > 0) {

                StringBuffer buffer = new StringBuffer();
                for (Object object : formatArgs) {
                    buffer.append(JSONUtils.parseObject(object, String.class) + " ");
                }
                this.message = String.format(this.message, buffer.toString());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
