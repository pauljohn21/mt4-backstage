package com.kajie88.bootexplore.controller;

import com.kajie88.base.dto.req.BasePageInfoReqDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.base.enums.common.SqlSortType;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import com.kajie88.base.utils.OrderUtil;
import com.kajie88.base.utils.StringUtil;
import com.kajie88.order.domain.MoneyInRecordDomain;
import com.kajie88.order.domain.MoneyOutRecordDomain;
import com.kajie88.order.service.MoneyInRecordService;
import com.kajie88.order.service.MoneyOutRecordService;
import com.kajie88.system.domain.ChannelDomain;
import com.kajie88.system.service.ChannelService;
import com.kajie88.user.domain.UserInfoDomain;
import com.kajie88.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    public MoneyOutRecordService moneyOutRecordService;
    @Autowired
    public MoneyInRecordService moneyInRecordService;
    @Autowired
    public UserInfoService userInfoService;
    @Autowired
    public ChannelService channelService;

    @RequestMapping("getMoneyInList")
    public Map<String,Object> getMoneyInList(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO) throws ParseException {
        MoneyInRecordDomain queryDomain = new MoneyInRecordDomain();
        queryDomain.setPageInfo(reqDTO.getPage());
        //模糊搜索暂不实现
        //userInfoDomain.setName(reqDTO.getParam().get("likeName"));
        queryDomain.setCreateTimeSortType(SqlSortType.DESC);
        List<MoneyInRecordDomain> resultList = moneyInRecordService.getDomainList(queryDomain);
        return new BaseRespDTO().page(queryDomain.getPageInfo()).success("moneyInList",resultList).result();
    }

    @RequestMapping("getMoneyOutList")
    public Map<String,Object> getMoneyOutList(@RequestBody BasePageInfoReqDTO<Map<String,String>> reqDTO){
        MoneyOutRecordDomain queryDomain = new MoneyOutRecordDomain();
        queryDomain.setPageInfo(reqDTO.getPage());
//      userInfoDomain.setName(reqDTO.getParam().get("likeName"));
        queryDomain.setCreateTimeSortType(SqlSortType.DESC);
        List<MoneyOutRecordDomain> resultList = moneyOutRecordService.getDomainList(queryDomain);
        return new BaseRespDTO().page(queryDomain.getPageInfo()).success("moneyOutList",resultList).result();
    }

    @RequestMapping("getMoneyInById")
    public Map<String,Object> getMoneyInById(@RequestBody BasePageInfoReqDTO<Map<String,Object>> reqDTO) throws ParseException {
        MoneyInRecordDomain queryDomain = new MoneyInRecordDomain();
        queryDomain.setId(Integer.valueOf((String)reqDTO.getParam().get("id")));
        queryDomain = moneyInRecordService.getDomainByQuery(queryDomain);
        return new BaseRespDTO().success("moneyInInfo",queryDomain).result();
    }
    @RequestMapping("getMoneyOutById")
    public Map<String,Object> getMoneyOutById(@RequestBody BasePageInfoReqDTO<Map<String,Object>> reqDTO){
        MoneyOutRecordDomain queryDomain = new MoneyOutRecordDomain();
        queryDomain.setId(Integer.valueOf((String)reqDTO.getParam().get("id")));
        queryDomain = moneyOutRecordService.getDomainByQuery(queryDomain);
        return new BaseRespDTO().success("moneyOutInfo",queryDomain).result();
    }
    @RequestMapping("updateMoneyInRank")
    public Map<String,Object> updateMoneyInRank(@RequestBody BasePageInfoReqDTO<Map<String,Object>> reqDTO){
        MoneyInRecordDomain queryDomain = new MoneyInRecordDomain();
        queryDomain.setId(Integer.valueOf((String)reqDTO.getParam().get("id")));
        queryDomain.setRank(Integer.valueOf((String)reqDTO.getParam().get("rank")));
        moneyInRecordService.updateDomainById(queryDomain);
        return new BaseRespDTO().success().result();
    }

    @RequestMapping("updateMoneyOutRank")
    public Map<String,Object> updateMoneyOutRank(@RequestBody BasePageInfoReqDTO<Map<String,Object>> reqDTO){
        MoneyOutRecordDomain queryDomain = new MoneyOutRecordDomain();
        queryDomain.setId(Integer.valueOf((String)reqDTO.getParam().get("id")));
        queryDomain.setRank(Integer.valueOf((String)reqDTO.getParam().get("rank")));
        moneyOutRecordService.updateDomainById(queryDomain);
        return new BaseRespDTO().success().result();
    }

    @RequestMapping("addMoneyIn")
    public Map<String,Object> addMoneyIn(@RequestBody BasePageInfoReqDTO<Map<String,Object>> reqDTO) throws ParseException {
        String name = (String)reqDTO.getParam().get("name");
        String channelId = (String)reqDTO.getParam().get("channelId");
        String mt4Account = (String)reqDTO.getParam().get("mt4Account");
        if (StringUtil.isEmptyForTrim((String)reqDTO.getParam().get("inMoney"))){
            throw new CommonException(CommonError.SYSTEM_ERROR,"入金不能为空");
        }
        Double inMoney = Double.valueOf((String)reqDTO.getParam().get("inMoney"));
        if(StringUtil.isEmptyForTrim(mt4Account)){
            throw new CommonException(CommonError.SYSTEM_ERROR,"MT4账号不能为空");
        }
        if(inMoney==null||inMoney<0){
            throw new CommonException(CommonError.SYSTEM_ERROR,"入金必须大于零");
        }
        //验证 mt4账号 是否 存在
        UserInfoDomain queryUserDomain = new UserInfoDomain();
        queryUserDomain.setAccount(mt4Account);
        UserInfoDomain domainByQuery = userInfoService.getDomainByQuery(queryUserDomain);
        if(domainByQuery==null){
            throw new CommonException(CommonError.SYSTEM_ERROR,"MT4账号不存在");
        }
        if(!domainByQuery.getName().equals(name)){
            throw new CommonException(CommonError.SYSTEM_ERROR,"账号和用户名不相符请检查");
        }

        //获取当前通道的数据
        ChannelDomain queryDomain = new ChannelDomain();
        queryDomain.setId(Integer.valueOf(channelId));
        ChannelDomain resultChannel = channelService.getDomainByQuery(queryDomain);

        if(inMoney>resultChannel.getPayMax()){
            throw new CommonException(CommonError.SYSTEM_ERROR,"此通道限制，单次入金不能大于"+resultChannel.getPayMax()+"元。");
        }
        if(inMoney<resultChannel.getPayMin()){
            throw new CommonException(CommonError.SYSTEM_ERROR,"此通道限制，单次入金不能小于"+resultChannel.getPayMin()+"元。");
        }
        //获取当前通道今日下单的 数据
        MoneyInRecordDomain searchRecordDomain = new MoneyInRecordDomain();
        searchRecordDomain.setCreateTime(new Date());
        List<MoneyInRecordDomain> moneyInRecordServiceDomainList = moneyInRecordService.getDomainList(searchRecordDomain);
        double sumToday = 0d;
        for (MoneyInRecordDomain recordDomain : moneyInRecordServiceDomainList) {
            sumToday += recordDomain.getMoney();
        }
        if(sumToday+inMoney>=resultChannel.getPayLimit()){
            throw new CommonException(CommonError.SYSTEM_ERROR,"此通道已达今日入金上限请明天再试。");
        }

        MoneyInRecordDomain queryMoneyDomain = new MoneyInRecordDomain();
        queryMoneyDomain.setUserAccount(mt4Account);
        queryMoneyDomain.setOrderNum(OrderUtil.getOrderIdByUUId());
        queryMoneyDomain.setUserId(domainByQuery.getId());
        queryMoneyDomain.setChannelId(Integer.valueOf(channelId));
        queryMoneyDomain.setUserName(name);
        queryMoneyDomain.setMoney(inMoney);
        queryMoneyDomain.setId(moneyInRecordService.insertDomain(queryMoneyDomain));;
        return new BaseRespDTO().success("orderInfo",queryMoneyDomain).result();
    }


    @RequestMapping("addMoneyOut")
    public Map<String,Object> addMoneyOut(@RequestBody BasePageInfoReqDTO<Map<String,Object>> reqDTO){
        String name = (String)reqDTO.getParam().get("userName");
        String mt4Account = (String)reqDTO.getParam().get("userAccount");
        Double outMoney = Double.valueOf((String)reqDTO.getParam().get("money"));
        String phone = (String)reqDTO.getParam().get("userPhone");
        String email = (String)reqDTO.getParam().get("userEmail");
        String bankName = (String)reqDTO.getParam().get("bankName");
        String bankAddress = (String)reqDTO.getParam().get("bankAddress");
        String bankAccount = (String)reqDTO.getParam().get("bankAccount");

        if(StringUtil.isEmptyForTrim(mt4Account)){
            throw new CommonException(CommonError.SYSTEM_ERROR,"MT4账号不能为空");
        }
        if(outMoney==null||outMoney<0){
            throw new CommonException(CommonError.SYSTEM_ERROR,"出金必须大于零");
        }
        if(StringUtil.isEmptyForTrim(phone)){
            throw new CommonException(CommonError.SYSTEM_ERROR,"手机号不能为空");
        }
        if(StringUtil.isEmptyForTrim(email)){
            throw new CommonException(CommonError.SYSTEM_ERROR,"email不能为空");
        }
        if(StringUtil.isEmptyForTrim(bankName)){
            throw new CommonException(CommonError.SYSTEM_ERROR,"开户行名称不能为空");
        }
        if(StringUtil.isEmptyForTrim(bankAddress)){
            throw new CommonException(CommonError.SYSTEM_ERROR,"开户行地址不能为空");
        }
        if(StringUtil.isEmptyForTrim(bankAccount)){
            throw new CommonException(CommonError.SYSTEM_ERROR,"银行卡号不能为空");
        }
        //验证 mt4账号 是否 存在
        UserInfoDomain queryUserDomain = new UserInfoDomain();
        queryUserDomain.setAccount(mt4Account);
        UserInfoDomain domainByQuery = userInfoService.getDomainByQuery(queryUserDomain);
        if(domainByQuery==null){
            throw new CommonException(CommonError.SYSTEM_ERROR,"MT4账号不存在");
        }
        if(!domainByQuery.getName().equals(name)){
            throw new CommonException(CommonError.SYSTEM_ERROR,"账号和用户名不相符请检查");
        }
        MoneyOutRecordDomain queryMoneyDomain = new MoneyOutRecordDomain();
        queryMoneyDomain.setOrderNo(OrderUtil.getOrderIdByUUId());
        queryMoneyDomain.setMoney(outMoney);
        queryMoneyDomain.setUserId(domainByQuery.getId());
        queryMoneyDomain.setUserName(name);
        queryMoneyDomain.setPhone(phone);
        queryMoneyDomain.setMt4Account(mt4Account);
        queryMoneyDomain.setEmail(email);
        queryMoneyDomain.setBankName(bankName);
        queryMoneyDomain.setBankAddress(bankAddress);
        queryMoneyDomain.setBankCardNumber(bankAccount);

        moneyOutRecordService.insertDomain(queryMoneyDomain);
        return new BaseRespDTO().success().result();
    }
}
