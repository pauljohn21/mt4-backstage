package com.kajie88.base.exception;


import com.kajie88.base.enums.error.IError;

public class CommonException extends RuntimeException implements IException {

    private IError error;
    private String msg;

    public CommonException(IError error) {
        this(error, null, "");
    }

    public CommonException(IError error, String msg) {
        this(error, null, msg);
    }

    public CommonException(IError error, Throwable cause) {
        this(error, cause, "");
    }

    public CommonException(IError error, Throwable cause, String msg) {
        super("[" + error.getErrorCode() + "]:" + error.getErrorMsg() + ":" + msg, cause);
        this.error = error;
        this.msg = msg;
    }

    public IError getError() {
        return error;
    }

    public String getErrorCode() {
        return error.getErrorCode();
    }

    public String getErrorTitle() {
        return error.getErrorTitle();
    }

    public String getErrorMsg() {
        return error.getErrorMsg() + ":" + this.msg;
    }

    public String getErrorMsgCn() {
        if(this.msg!=null){
            return this.msg;
        }
        return this.error.getErrorMsgCn();
    }
}
