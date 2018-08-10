package com.kajie88.bootexplore.controller;

import com.kajie88.base.dto.req.BasePageInfoReqDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.base.enums.common.SqlSortType;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import com.kajie88.user.domain.UserInfoDomain;
import com.kajie88.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("getUserList")
    public Map<String,Object> getUserList(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO){
        UserInfoDomain userInfoDomain = new UserInfoDomain();
        userInfoDomain.setPageInfo(reqDTO.getPage());
        userInfoDomain.setName(reqDTO.getParam().get("likeName"));
        userInfoDomain.setCreateTimeSortType(SqlSortType.DESC);
        List<UserInfoDomain> userList = userInfoService.getDomainList(userInfoDomain);
        return new BaseRespDTO().page(userInfoDomain.getPageInfo()).success("userList",userList).result();
    }
    @RequestMapping("getUserInfoById")
    public Map<String,Object> getUserInfoById(@RequestBody BasePageInfoReqDTO<Map<String,Object>> reqDTO){
        UserInfoDomain userInfoDomain = new UserInfoDomain();
        userInfoDomain.setId(Integer.valueOf((String)reqDTO.getParam().get("id")));
        userInfoDomain = userInfoService.getDomainByQuery(userInfoDomain);
        return new BaseRespDTO().success("userInfo",userInfoDomain).result();
    }
    @RequestMapping("deleteUserById")
    public Map<String,Object> deleteUserById(@RequestBody BasePageInfoReqDTO<Map<String,Object>> reqDTO){
        if(reqDTO.getParam().get("id")==null){
            throw new CommonException(CommonError.SYSTEM_ERROR,"id不能为空");
        }
        userInfoService.deleteDomian((Integer) reqDTO.getParam().get("id"));
        return new BaseRespDTO().success().result();
    }

    @RequestMapping("editUserInfo")
    public Map<String,Object> editUserInfo(@RequestBody BasePageInfoReqDTO<UserInfoDomain> reqDTO){
        UserInfoDomain waitUserInfo = reqDTO.getParam();
        //有id 就更新 没有就 新增
        if(waitUserInfo.getId()==null){
            userInfoService.insertDomain(waitUserInfo);
        }else {
            userInfoService.updateDomainById(waitUserInfo);
        }
        return new BaseRespDTO().success().result();
    }
}
