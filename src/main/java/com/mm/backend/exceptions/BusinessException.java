package com.mm.backend.exceptions;

import com.mm.backend.common.ResponseCode;

/**
 * @Classname BussnessException
 * @Description TODO
 * @Author xujian
 * @Create 2019-10-18 18:53
 **/
public class BusinessException extends RuntimeException {
    protected Integer errorCode;
    protected String errorMsg;
    private String msg;

    public BusinessException() {
        this.msg = "";
    }

    public BusinessException(ResponseCode responseCode) {
        this.msg = "";
        this.errorCode = responseCode.getCode();
        this.errorMsg = responseCode.getMsg();
    }

    public BusinessException(Integer errorCode, String msg) {
        super("ErrorCode:" + errorCode + ";ErrorMsg:" + msg);
        this.msg = "";
        this.errorCode = errorCode;
        this.errorMsg = msg;
    }

    public BusinessException(Integer errorCode, String msg, Throwable e) {
        super("ErrorCode:" + errorCode + ";ErrorMsg:" + msg, e);
        this.msg = "";
        this.errorCode = errorCode;
        this.errorMsg = msg;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

