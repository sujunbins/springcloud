package com.junbin.springcloud.Commom.exception;

import com.alibaba.fastjson.JSON;
import com.junbin.springcloud.Commom.resultcode.BaseResultCode;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


public class BusinessException extends BaseException {
    private static final long serialVersionUID = -3047704237593108621L;
    /**
     * 格式化的值
     */
    private Object[] formatValues;
    /**
     * 是否已经格式化的标志
     */
    private boolean isFormated;
    /**
     * 异常详情信息
     */
    private String exceptionDetail;

    public BusinessException() {
        super();
    }

    public BusinessException(BaseResultCode e) {
        super(e);
        buildCode(e.getCode());
}

    public BusinessException(BaseResultCode e, String message) {
        super(e, message);
        buildCode(e.getCode());
    }

    public BusinessException(BaseResultCode e, ErrorMessageParam errorMessageParam) {
        super(e, errorMessageParam);
        buildCode(e.getCode());
    }

    public BusinessException(BaseResultCode baseErrorCode, Object... formatValues) {
        this(baseErrorCode.getCode(), baseErrorCode.getMessage(),formatValues);
    }

    public BusinessException(String errorCode, String errorMsg, Object... formatValues) {
        buildCode(errorCode).buildMessage(errorMsg);
        this.buildFormatValues(formatValues);
    }

    /**
     * 构建errorCode
     */
    private BusinessException buildCode(String code) {
        super.setCode(code);
        return this;
    }

    /**
     * 构建errorMsg
     */
    private BusinessException buildMessage(String errorMsg) {
        super.setMessage(errorMsg);
        return this;
    }

    /**
     * 构建需要替换msg中参数的值
     */
    public BusinessException buildFormatValues(Object... formatValues) {
        if (ArrayUtils.isEmpty(formatValues)) {
            formatValues = new String[]{"数据"};
        }
        this.formatValues = formatValues;
        return this;
    }

    public BusinessException buildExceptionDetail(Throwable cause) {
        if (cause.getCause() != null) {
            this.exceptionDetail = cause.getCause().getMessage();
        }else {
            StackTraceElement[] stackTraceElements = cause.getStackTrace();

            StringBuffer buffer = new StringBuffer();
            buffer.append("\n" + cause.getClass().getCanonicalName() + ": " + cause.getMessage() + "\n");
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                buffer.append("\tat  ");
                buffer.append(stackTraceElement.toString());
                buffer.append("\n");
            }
            buffer.delete(buffer.length() - 1, buffer.length());

            this.exceptionDetail = buffer.toString();
        }
        return this;
    }

    public Object[] getFormatValues() {
        return formatValues;
    }

    public void setFormatValues(String[] formatValues) {
        this.formatValues = formatValues;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    @Override
    public String getMessage() {
        if (!isFormated) {
            if (StringUtils.isNotEmpty(super.getMessage()) && ArrayUtils.isNotEmpty(this.formatValues)) {
                this.setMessage(String.format(super.getMessage(), JSON.toJSONString(this.formatValues)));
                this.isFormated = true;
            }
        }
        return this.message;
    }

}
