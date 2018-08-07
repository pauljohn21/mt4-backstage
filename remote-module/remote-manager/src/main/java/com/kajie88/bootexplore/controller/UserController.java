package com.kajie88.bootexplore.controller;

import com.kajie88.base.dto.req.BasePageInfoReqDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
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
        userInfoDomain.setId(reqDTO.getParam().get("id"));
        List<UserInfoDomain> userList = userInfoService.getDomainList(userInfoDomain);
        return new BaseRespDTO().page(userInfoDomain.getPageInfo()).success(userList).result();
    }
}
