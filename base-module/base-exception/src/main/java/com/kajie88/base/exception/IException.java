package com.kajie88.base.exception;


import com.kajie88.base.enums.error.IError;

public interface IException {
    IError getError();
    String getErrorCode();
    String getErrorTitle();
    String getErrorMsg();
    String getErrorMsgCn();
}
