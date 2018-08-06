package com.kajie88.bootexplore.controller;

import com.kajie88.base.dto.req.BasePageInfoReqDTO;
import com.kajie88.base.dto.resp.BasePageInfoRespDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.user.domain.UserDomain;
import com.kajie88.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("getUserList")
    public Map<String,Object> getUserList(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO){
        UserDomain userDomain = new UserDomain();
        userDomain.setPageInfo(reqDTO.getPage());

        List<UserDomain> userList = userService.getUserList(userDomain);
        return new BaseRespDTO().page(userDomain.getPageInfo()).success(userList).result();
    }
}
