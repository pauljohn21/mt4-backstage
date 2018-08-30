package com.kajie88.bootexplore.controller;

import com.kajie88.base.dto.req.BaseReqDTO;
import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.base.enums.common.SqlSortType;
import com.kajie88.base.po.BankInfo;
import com.kajie88.base.utils.StringUtil;
import com.kajie88.system.domain.BankInfoDomain;
import com.kajie88.system.domain.ChannelDomain;
import com.kajie88.system.service.BankInfoService;
import com.kajie88.system.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;
    @Autowired
    private BankInfoService bankInfoService;
    @RequestMapping("getChannelList")
    public Map<String,Object> getNoticeList(@RequestBody BaseReqDTO<Map<String,String>> reqDTO){
        ChannelDomain channelDomain = new ChannelDomain();
        channelDomain.setCreateTimeSortType(SqlSortType.DESC);
        List<ChannelDomain> channelList = channelService.getDomainList(channelDomain);
        channelList.forEach(channelInfo->{
            BankInfoDomain queryDomain = new BankInfoDomain();
            queryDomain.setChannelId(channelInfo.getId());
            List<BankInfoDomain> domainList = bankInfoService.getDomainList(queryDomain);
            for (BankInfoDomain bankInfoDomain : domainList) {
                bankInfoDomain.setPayImgFir(null);
                bankInfoDomain.setPayImgSec(null);
                bankInfoDomain.setPayImgThir(null);
            }
            channelInfo.setBankInfoList(domainList);
        });
        return new BaseRespDTO().success("channelList",channelList).result();
    }
    @RequestMapping("getChannelDomain")
    public Map<String,Object> getChannelDomain(@RequestBody BaseReqDTO<Map<String,String>> reqDTO){
        ChannelDomain channelDomain = new ChannelDomain();
        channelDomain.setId(Integer.valueOf(reqDTO.getParam().get("id")));
        ChannelDomain resultDomain = channelService.getDomainByQuery(channelDomain);
        BankInfoDomain queryDomain = new BankInfoDomain();
        queryDomain.setChannelId(resultDomain.getId());
        queryDomain.setStatus(1);
        resultDomain.setBankInfoList(bankInfoService.getDomainList(queryDomain));
        return new BaseRespDTO().success("channelDomain",resultDomain).result();
    }
    @RequestMapping("disposeChannel")
    public Map<String,Object> disposeChannel(@RequestBody BaseReqDTO<Map<String,String>> reqDTO){
        String id = reqDTO.getParam().get("id");
        String name = reqDTO.getParam().get("name");
        String status = reqDTO.getParam().get("status");
        String rank = reqDTO.getParam().get("rank");
        String payMin = reqDTO.getParam().get("payMin");
        String payMax = reqDTO.getParam().get("payMax");
        String payLimit = reqDTO.getParam().get("payLimit");

        ChannelDomain channelDomain = new ChannelDomain();

        channelDomain.setName(name);
        channelDomain.setStatus(status);
        channelDomain.setRank(Integer.valueOf(rank));
        channelDomain.setPayMin(Double.valueOf(payMin));
        channelDomain.setPayMax(Double.valueOf(payMax));
        channelDomain.setPayLimit(Double.valueOf(payLimit));
        if(StringUtil.isEmptyForTrim(id)){
            channelService.insertDomain(channelDomain);
        }else {
            channelDomain.setId(Integer.valueOf(id));
            channelService.updateDomain(channelDomain);
        }
        return new BaseRespDTO().success().result();
    }
    @RequestMapping("delChannel")
    public Map<String,Object> delChannel(@RequestBody BaseReqDTO<Map<String,String>> reqDTO){
        String id = reqDTO.getParam().get("id");
        channelService.delDomain(Integer.valueOf(id));
        return new BaseRespDTO().success().result();
    }
    @RequestMapping("getBankDomain")
    public Map<String,Object> getBankDomain(@RequestBody BaseReqDTO<Map<String,String>> reqDTO){
        BankInfoDomain queryDomain = new BankInfoDomain();
        queryDomain.setId(Integer.valueOf(reqDTO.getParam().get("id")));
        BankInfoDomain resultDomain = bankInfoService.getDomainByQuery(queryDomain);
        return new BaseRespDTO().success("bankInfoDomain",resultDomain).result();
    }
    @RequestMapping("disposeBankInfo")
    public Map<String,Object> disposeBankInfo(@RequestBody BaseReqDTO<BankInfoDomain> reqDTO){
        if(reqDTO.getParam().getId()==null){
            bankInfoService.insertDomain(reqDTO.getParam());
        }else {
            bankInfoService.updateDomain(reqDTO.getParam());
        }
        return new BaseRespDTO().success().result();
    }
    @RequestMapping("delBankInfo")
    public Map<String,Object> delBankInfo(@RequestBody BaseReqDTO<Map<String,String>> reqDTO){
        String id = reqDTO.getParam().get("id");
        bankInfoService.delDomain(Integer.valueOf(id));
        return new BaseRespDTO().success().result();
    }
}
