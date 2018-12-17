package com.kajie88.order.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kajie88.base.dao.MoneyInRecordMapper;
import com.kajie88.base.enums.common.SqlSortType;
import com.kajie88.base.enums.error.CommonError;
import com.kajie88.base.exception.CommonException;
import com.kajie88.base.po.MoneyInRecord;
import com.kajie88.base.po.MoneyInRecordExample;
import com.kajie88.base.utils.CollectionUtils;
import com.kajie88.order.domain.MoneyInRecordDomain;
import com.kajie88.order.domain.MoneyOutRecordDomain;
import com.kajie88.order.service.MoneyInRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MoneyInRecordServiceImpl implements MoneyInRecordService {
    @Autowired
    private MoneyInRecordMapper mapper;
    @Override
    public List<MoneyInRecordDomain> getDomainList(MoneyInRecordDomain domain) throws ParseException {
        Page<Object> pages = PageHelper.startPage(domain.getPageInfo().getCurrentPage(), domain.getPageInfo().getPageSize());
        //1.第一步，声明返回
        List<MoneyInRecordDomain> resultDomains = new ArrayList();
        //2.第二步，判断查询条件,不仅要根据domain中的特殊查询定义，且要把UserInfo的字段判断（如domain中有特殊定义字段的查询方式，则根据domain中的来）
        MoneyInRecordExample example = new MoneyInRecordExample();
        //2.2 把字段参数带入
        MoneyInRecordExample.Criteria criteria = example.createCriteria();
        if (domain.getId()!=null) {
            criteria.andIdEqualTo(domain.getId());
        }
        if(domain.getUserId()!=null){
            criteria.andUserIdEqualTo(domain.getUserId());
        }
        if(domain.getCreateTime()!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formatDate = sdf.format(new Date());
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date start = sdf2.parse(formatDate+" 00:00:00");
            Date end = sdf2.parse(formatDate+" 23:59:59");
            criteria.andCreateTimeBetween(start,end);
        }

        if (domain.getCreateTimeSortType() != null) {
            example.setOrderByClause("create_time " + domain.getCreateTimeSortType());
        }
//        if(domain.getDelFlag()==null){
//            criteria.andDelFlagEqualTo(0);
//        }else {
//            criteria.andDelFlagEqualTo(domain.getDelFlag());
//        }
        //3.第三步，开始进行db查询
        //封装到Domain中的pageInfo对象中，且进行实际的sql查询
        List<MoneyInRecord> users = mapper.selectByExample(example);
        domain.getPageInfo().setTotalCount(new Long(pages.getTotal()).intValue());
        //使用CollectionUtils进行拷贝到userInfoDomains中
        CollectionUtils.copyProperties(users, resultDomains, MoneyInRecordDomain.class);
        return resultDomains;
    }

    @Override
    public MoneyInRecordDomain getDomainByQuery(MoneyInRecordDomain domain) throws ParseException {
        List<MoneyInRecordDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        return domainList.get(0);
    }

    @Override
    public MoneyInRecordDomain getDomainByQuery(MoneyInRecordDomain domain, int index) throws ParseException {
        List<MoneyInRecordDomain> domainList = this.getDomainList(domain);
        if(domainList.isEmpty()){
            return null;
        }
        if(domainList.size()<=index){
            throw new CommonException(CommonError.INDEX_OUT_OF_RANG);
        }
        return index==-1?domainList.get(0):domainList.get(index);
    }

    @Override
    public int insertDomain(MoneyInRecordDomain domain) throws ParseException {
        String newUserId = String.join("",UUID.randomUUID().toString().split("-"));
        domain.setCreateTime(new Date());
        mapper.insertSelective(domain);
        MoneyInRecordDomain showIdDomain = new MoneyInRecordDomain();
        showIdDomain.setCreateTimeSortType(SqlSortType.DESC);
        this.getDomainByQuery(showIdDomain);
        return this.getDomainByQuery(showIdDomain).getId();
    }

    @Override
    public void updateDomainById(MoneyInRecordDomain domain) {
        mapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public void deleteDomain(int id) {
        MoneyInRecordDomain delInfo = new MoneyInRecordDomain();
        delInfo.setId(id);
        delInfo.setDelFlag(1);
        mapper.updateByPrimaryKeySelective(delInfo);
    }
}
