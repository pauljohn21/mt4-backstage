package com.kajie88.base.dto.req;


import com.kajie88.base.enums.common.TerminalType;

/**
 * Created by wangnan on 2016/6/21.
 * @ApiModel("App基础信息")

 */
public class BaseReqDTO<T> {

    /** 用户token令牌*/
    private String token;
    /** App内部版本号*/
    private String appVersion;
    /** 请求来源，andriod or ios*/
    private TerminalType source = TerminalType.WEB;

    private T param;


    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TerminalType getSource() {
        return source;
    }

    public void setSource(TerminalType source) {
        this.source = source;
    }


    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}