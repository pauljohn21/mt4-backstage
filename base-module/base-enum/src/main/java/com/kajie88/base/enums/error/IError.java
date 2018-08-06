package com.kajie88.base.enums.error;

/**
 * 错误信息枚举接口
 * Created by wangnan on 2016/6/21.
 */
public interface IError {
    String getErrorCode();
    String getErrorTitle();
    String getErrorMsg();
    String getErrorMsgCn();
}
