package com.kajie88.bootexplore.controller;

import com.kajie88.base.dto.req.BasePageInfoReqDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.base.enums.common.SqlSortType;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import com.kajie88.user.domain.UserInfoDomain;
import com.kajie88.user.service.UserInfoService;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        userInfoService.deleteDomain((Integer) reqDTO.getParam().get("id"));
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

    @RequestMapping("regNewUser")
    public Map<String,Object> regNewUser(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO) throws ParseException {

        UserInfoDomain newUserInfo = new UserInfoDomain();
        newUserInfo.setName(reqDTO.getParam().get("name"));
        newUserInfo.setIdentityCard(reqDTO.getParam().get("identityCard"));
        newUserInfo.setPhone(reqDTO.getParam().get("phone"));
        newUserInfo.setEmail(reqDTO.getParam().get("email"));
        newUserInfo.setAccountType(reqDTO.getParam().get("accountType"));
        newUserInfo.setMoneyType(reqDTO.getParam().get("symoblType"));
        newUserInfo.setLeverage(Integer.valueOf(reqDTO.getParam().get("rateRang")));
        newUserInfo.setAdvanceDepost(Double.valueOf(reqDTO.getParam().get("startMoney")));
        newUserInfo.setResidentialCountry(reqDTO.getParam().get("country"));
        newUserInfo.setAddress(reqDTO.getParam().get("street"));
        newUserInfo.setPostcode(reqDTO.getParam().get("postal"));
        newUserInfo.setCity(reqDTO.getParam().get("city"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        newUserInfo.setBirthday(sdf.parse(reqDTO.getParam().get("brothday")));
        newUserInfo.setJobState(reqDTO.getParam().get("isJob"));
        newUserInfo.setJobExperience(reqDTO.getParam().get("whereJob"));
        newUserInfo.setEducationLevel(reqDTO.getParam().get("lvJob"));
        newUserInfo.setAnnualIncome(reqDTO.getParam().get("salary"));
        newUserInfo.setSumMoney(reqDTO.getParam().get("equity"));
        newUserInfo.setMoneyResource(reqDTO.getParam().get("moneySource"));
        newUserInfo.setRiskAwareness(reqDTO.getParam().get("moneyIdeal"));
        //language 字段丢失
        newUserInfo.setUserCardUp(reqDTO.getParam().get("userCardUp"));
        newUserInfo.setUserCardBack(reqDTO.getParam().get("userCardBack"));
        newUserInfo.setBankCardUp(reqDTO.getParam().get("BankCardUp"));

        userInfoService.insertDomain(newUserInfo);
        return new BaseRespDTO().success().result();
    }
}
