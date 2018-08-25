package com.kajie88.system.service.impl;

import com.kajie88.base.dao.BankInfoMapper;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import com.kajie88.base.po.BankInfo;
import com.kajie88.base.po.BankInfoExample;
import com.kajie88.base.utils.CollectionUtils;
import com.kajie88.system.domain.BankInfoDomain;
import com.kajie88.system.domain.ChannelDomain;
import com.kajie88.system.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BankInfoServiceImpl implements BankInfoService {
    @Autowired
    private BankInfoMapper mapper;
    @Override
    public List<BankInfoDomain> getDomainList(BankInfoDomain domain) {
        //        Page<Object> pages = PageHelper.startPage(domain.getPageInfo().getCurrentPage(), domain.getPageInfo().getPageSize());
        //1.第一步，声明返回
        List<BankInfoDomain> resultDomains = new ArrayList();
        //2.第二步，判断查询条件,不仅要根据domain中的特殊查询定义，且要把UserInfo的字段判断（如domain中有特殊定义字段的查询方式，则根据domain中的来）
        BankInfoExample example = new BankInfoExample();
        //2.2 把字段参数带入
        BankInfoExample.Criteria criteria = example.createCriteria();
        if (domain.getId()!=null) {
            criteria.andIdEqualTo(domain.getId());
        }
        if(domain.getChannelId()!=null){
            criteria.andChannelIdEqualTo(domain.getChannelId());
        }
//        if(!StringUtil.isEmptyForTrim(domain.getTitle())){
//            criteria.andNameLike("%"+domain.getTitle()+"%");
//        }
//        if (domain.getCreateTimeSortType() != null) {
            example.setOrderByClause("rank desc,id desc");
//        }
        if(domain.getDelFlag()==null){
            criteria.andDelFlagEqualTo(0);
        }else {
            criteria.andDelFlagEqualTo(domain.getDelFlag());
        }
        //3.第三步，开始进行db查询
        //封装到Domain中的pageInfo对象中，且进行实际的sql查询
        List<BankInfo> resultList = mapper.selectByExample(example);
        //domain.getPageInfo().setTotalCount(new Long(pages.getTotal()).intValue());
        //使用CollectionUtils进行拷贝到userInfoDomains中
        CollectionUtils.copyProperties(resultList, resultDomains, BankInfoDomain.class);
        return resultDomains;
    }

    @Override
    public BankInfoDomain getDomainByQuery(BankInfoDomain domain) {
        List<BankInfoDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        return domainList.get(0);
    }

    @Override
    public BankInfoDomain getDomainByQuery(BankInfoDomain domain, int index) {
        List<BankInfoDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        if(domainList.size()<=index){
            throw new CommonException(CommonError.INDEX_OUT_OF_RANG);
        }
        return index==-1?domainList.get(0):domainList.get(index);
    }

    @Override
    public void insertDomain(BankInfoDomain domain) {
        mapper.insertSelective(domain);
    }

    @Override
    public void updateDomain(BankInfoDomain domain) {
        mapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public void delDomain(int id) {
        mapper.deleteByPrimaryKey(id);
    }
}
