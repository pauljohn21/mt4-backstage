package com.kajie88.user.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.kajie88.base.dao.UserInfoMapper;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import com.kajie88.base.po.UserInfo;
import com.kajie88.base.po.UserInfoExample;
import com.kajie88.base.utils.CollectionUtils;
import com.kajie88.base.utils.StringUtil;
import com.kajie88.user.domain.UserInfoDomain;
import com.kajie88.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper mapper;

    @Override
    public List<UserInfoDomain> getDomainList(UserInfoDomain domain) {
        Page<Object> pages = PageHelper.startPage(domain.getPageInfo().getCurrentPage(), domain.getPageInfo().getPageSize());
//        //1.第一步，声明返回
        List<UserInfoDomain> resultDomains = new ArrayList();
        //2.第二步，判断查询条件,不仅要根据domain中的特殊查询定义，且要把UserInfo的字段判断（如domain中有特殊定义字段的查询方式，则根据domain中的来）
        UserInfoExample example = new UserInfoExample();
        //2.2 把字段参数带入
        UserInfoExample.Criteria criteria = example.createCriteria();
        if (domain.getId()!=null) {
            criteria.andIdEqualTo(domain.getId());
        }
        if(!StringUtil.isEmptyForTrim(domain.getName())){
            criteria.andNameLike("%"+domain.getName()+"%");
        }
        if (domain.getCreateTimeSortType() != null) {
            example.setOrderByClause("create_time " + domain.getCreateTimeSortType());
        }
        if(domain.getDelFlag()==null){
            criteria.andDelFlagEqualTo(0);
        }else {
            criteria.andDelFlagEqualTo(domain.getDelFlag());
        }
        //3.第三步，开始进行db查询
        //封装到Domain中的pageInfo对象中，且进行实际的sql查询
        List<UserInfo> users = mapper.selectByExample(example);
        domain.getPageInfo().setTotalCount(new Long(pages.getTotal()).intValue());
        //使用CollectionUtils进行拷贝到userInfoDomains中
        CollectionUtils.copyProperties(users, resultDomains, UserInfoDomain.class);
        return resultDomains;
    }

    @Override
    public UserInfoDomain getDomainByQuery(UserInfoDomain domain) {
        List<UserInfoDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        return domainList.get(0);
    }

    @Override
    public UserInfoDomain getDomainByQuery(UserInfoDomain domain, int index) {
        List<UserInfoDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        if(domainList.size()<=index){
            throw new CommonException(CommonError.INDEX_OUT_OF_RANG);
        }
        return index==-1?domainList.get(0):domainList.get(index);
    }

    @Override
    public String insertDomain(UserInfoDomain domain) {
        String newUserId = String.join("",UUID.randomUUID().toString().split("-"));
        domain.setCreateTime(new Date());
        mapper.insertSelective(domain);
        return newUserId;
    }

    @Override
    public void updateDomainById(UserInfoDomain domain) {
        mapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public void deleteDomian(int id) {
        UserInfoDomain delInfo = new UserInfoDomain();
        delInfo.setId(id);
        delInfo.setDelFlag(1);
        mapper.updateByPrimaryKeySelective(delInfo);
    }
}
