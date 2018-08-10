package com.kajie88.base.enums.error;

/**
 * Created by wangnan on 2016/6/21.
 */
public enum CommonError implements IError {

    SYSTEM_ERROR("COMMON_ERROR_000001", "系统异常", "System Error", "系统异常"),
    INDEX_OUT_OF_RANG("INDEX_OUT_OF_RANG_000001", "下标越界", "System Error", "下标越界"),
    USER_TOKEN_ERROR("CUSTOMER_TOKEN_ERROR", "登录失效", "Customer token Error", "登录失效")
    ;
    //Others


    private String errorCode;
    private String errorTitle;
    private String errorMsg;
    private String errorMsgCn;

    CommonError(String errorCode, String errorTitle, String errorMsg, String errorMsgCn) {
        this.errorCode = errorCode;
        this.errorTitle = errorTitle;
        this.errorMsg = errorMsg;
        this.errorMsgCn = errorMsgCn;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorTitle() {
        return this.errorTitle;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getErrorMsgCn() {
        return this.errorMsgCn;
    }
}