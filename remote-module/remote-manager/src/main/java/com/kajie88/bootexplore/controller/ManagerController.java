package com.kajie88.bootexplore.controller;

import com.kajie88.base.dto.req.BasePageInfoReqDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import com.kajie88.base.po.Admin;
import com.kajie88.base.utils.StringUtil;
import com.kajie88.system.domain.AdminDomain;
import com.kajie88.system.service.AdminService;
import com.kajie88.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("manager")
public class ManagerController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public Map<String,Object> login(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO){
        String name = reqDTO.getParam().get("name");
        String pwd = reqDTO.getParam().get("pwd");
        AdminDomain adminDomain = adminService.login(name, pwd);
        return new BaseRespDTO().success("adminInfo",adminDomain).result();
    }

    @RequestMapping("getLoginInfo")
    public Map<String,Object> getLoginInfo(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO){
        String token = reqDTO.getToken();
        if(StringUtil.isEmptyForTrim(token)){
            throw new CommonException(CommonError.USER_TOKEN_ERROR);
        }
        AdminDomain queryDomain = new AdminDomain();
        queryDomain.setToken(token);
        queryDomain = adminService.getDomainByQuery(queryDomain);
        return new BaseRespDTO().success("adminInfo",queryDomain).result();
    }
}
