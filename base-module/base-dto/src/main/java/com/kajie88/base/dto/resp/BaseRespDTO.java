package com.kajie88.base.dto.resp;


import com.kajie88.base.dto.PageInfo;
import com.kajie88.base.enums.common.ResponseStatus;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.enums.error.IError;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangnan on 2016/6/21.
 */
public class BaseRespDTO {
    private Map<String,Object> map = new HashMap<>();
//    private PageInfo page = new PageInfo();

    public BaseRespDTO(){
        map.put("respStatus","");
        map.put("errorCode","");
        map.put("errorMsg","");
        map.put("errorMsgCn","");
        map.put("errorTitle","");
    }
    public BaseRespDTO success(){
        map.put("respStatus",ResponseStatus.SUCCESS);
        return this;
    }
    public BaseRespDTO success(Object data){
        map.put("respStatus",ResponseStatus.SUCCESS);
        map.put("data",data);
        return this;
    }
    public BaseRespDTO success(Object data, PageInfo pageInfo){
        map.put("respStatus",ResponseStatus.SUCCESS);
        map.put("data",data);
        map.put("page",pageInfo);
        return this;
    }
    public BaseRespDTO error(String errorMessage){
        map.put("respStatus",ResponseStatus.FAIL);
        map.put("errorCode",CommonError.SYSTEM_ERROR.getErrorCode());
        map.put("errorMsg",errorMessage);
        map.put("errorMsgCn",errorMessage);
        map.put("errorTitle",errorMessage);
        return this;
    }
    public BaseRespDTO error(IError commonError){
        map.put("respStatus",ResponseStatus.FAIL);
        map.put("errorCode",commonError.getErrorCode());
        map.put("errorMsg",commonError.getErrorMsg());
        map.put("errorMsgCn",commonError.getErrorMsgCn());
        map.put("errorTitle",commonError.getErrorTitle());
        return this;
    }

    public BaseRespDTO page(PageInfo pageInfo){
        map.put("page",pageInfo);
        return this;
    }


    public Map<String,Object> result(){
        return map;
    }
}