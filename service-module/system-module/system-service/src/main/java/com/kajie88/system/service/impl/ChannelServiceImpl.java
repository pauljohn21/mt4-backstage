package com.kajie88.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kajie88.base.dao.ChannelMapper;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import com.kajie88.base.po.Channel;
import com.kajie88.base.po.ChannelExample;
import com.kajie88.base.utils.CollectionUtils;
import com.kajie88.system.domain.ChannelDomain;
import com.kajie88.system.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelMapper mapper;
    @Override
    public List<ChannelDomain> getDomainList(ChannelDomain domain) {
//        Page<Object> pages = PageHelper.startPage(domain.getPageInfo().getCurrentPage(), domain.getPageInfo().getPageSize());
        //1.第一步，声明返回
        List<ChannelDomain> resultDomains = new ArrayList();
        //2.第二步，判断查询条件,不仅要根据domain中的特殊查询定义，且要把UserInfo的字段判断（如domain中有特殊定义字段的查询方式，则根据domain中的来）
        ChannelExample example = new ChannelExample();
        //2.2 把字段参数带入
        ChannelExample.Criteria criteria = example.createCriteria();
        if (domain.getId()!=null) {
            criteria.andIdEqualTo(domain.getId());
        }
        if(domain.getStatus()!=null){
            criteria.andStatusEqualTo(domain.getStatus());
        }
//        if(!StringUtil.isEmptyForTrim(domain.getTitle())){
//            criteria.andNameLike("%"+domain.getTitle()+"%");
//        }
        if (domain.getCreateTimeSortType() != null) {
            example.setOrderByClause("rank desc,id " + domain.getCreateTimeSortType());
        }
        if(domain.getDelFlag()==null){
            criteria.andDelFlagEqualTo(0);
        }else {
            criteria.andDelFlagEqualTo(domain.getDelFlag());
        }
        //3.第三步，开始进行db查询
        //封装到Domain中的pageInfo对象中，且进行实际的sql查询
        List<Channel> resultList = mapper.selectByExample(example);
        //domain.getPageInfo().setTotalCount(new Long(pages.getTotal()).intValue());
        //使用CollectionUtils进行拷贝到userInfoDomains中
        CollectionUtils.copyProperties(resultList, resultDomains, ChannelDomain.class);
        return resultDomains;
    }

    @Override
    public ChannelDomain getDomainByQuery(ChannelDomain domain) {
        List<ChannelDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        return domainList.get(0);
    }

    @Override
    public ChannelDomain getDomainByQuery(ChannelDomain domain, int index) {
        List<ChannelDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        if(domainList.size()<=index){
            throw new CommonException(CommonError.INDEX_OUT_OF_RANG);
        }
        return index==-1?domainList.get(0):domainList.get(index);
    }

    @Override
    public void insertDomain(ChannelDomain domain) {
        mapper.insertSelective(domain);
    }

    @Override
    public void updateDomain(ChannelDomain domain) {
        mapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public void delDomain(int id) {
        mapper.deleteByPrimaryKey(id);
    }
}
