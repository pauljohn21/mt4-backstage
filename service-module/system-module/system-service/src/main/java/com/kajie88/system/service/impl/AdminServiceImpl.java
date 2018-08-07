package com.kajie88.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kajie88.base.dao.AdminMapper;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import com.kajie88.base.po.Admin;
import com.kajie88.base.utils.CollectionUtils;
import com.kajie88.base.utils.StringUtil;
import com.kajie88.base.po.AdminExample;
import com.kajie88.system.domain.AdminDomain;
import com.kajie88.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper mapper;
    @Override
    public List<AdminDomain> getDomainList(AdminDomain domain) {
//        //1.第一步，声明返回
        List<AdminDomain> resultDomains = new ArrayList();
        //2.第二步，判断查询条件,不仅要根据domain中的特殊查询定义，且要把UserInfo的字段判断（如domain中有特殊定义字段的查询方式，则根据domain中的来）
        AdminExample example = new AdminExample();
        //2.2 把字段参数带入
        AdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmptyForTrim(domain.getId())) {
            criteria.andIdEqualTo(domain.getId());
        }
        //3.第三步，开始进行db查询
        //封装到Domain中的pageInfo对象中，且进行实际的sql查询
        List<Admin> users = mapper.selectByExample(example);
        //使用CollectionUtils进行拷贝到userInfoDomains中
        CollectionUtils.copyProperties(users, resultDomains, AdminDomain.class);
        return resultDomains;
    }

    @Override
    public AdminDomain getDomainByQuery(AdminDomain domain) {
        List<AdminDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        return domainList.get(0);
    }

    @Override
    public AdminDomain getDomainByQuery(AdminDomain domain, int index) {
        List<AdminDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        if(domainList.size()<=index){
            throw new CommonException(CommonError.INDEX_OUT_OF_RANG);
        }
        return index==-1?domainList.get(0):domainList.get(index);
    }

    @Override
    public String insertDomain(AdminDomain domain) {
        String newUserId = String.join("",UUID.randomUUID().toString().split("-"));
        domain.setCreateTime(new Date());
        domain.setId(newUserId);
        mapper.insertSelective(domain);
        return newUserId;
    }

    @Override
    public void updateDomainById(AdminDomain domain) {
        mapper.updateByPrimaryKeySelective(domain);
    }


}
