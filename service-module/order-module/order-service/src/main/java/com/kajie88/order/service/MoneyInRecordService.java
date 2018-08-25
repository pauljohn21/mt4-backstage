package com.kajie88.order.service;

import com.kajie88.order.domain.MoneyInRecordDomain;

import java.text.ParseException;
import java.util.List;

public interface MoneyInRecordService {
    /**
     * 根据条件查询集合
     * @param domain 查询条件
     * @return domain集合
     */
    List<MoneyInRecordDomain> getDomainList(MoneyInRecordDomain domain) throws ParseException;

    /**
     * 查询domian 类 多个结果支取第一个
     * @param domain 查询条件
     * @return 单个对象
     */
    MoneyInRecordDomain getDomainByQuery(MoneyInRecordDomain domain) throws ParseException;
    /**
     * 查询domian 类重载方法 可指定提取下标 -1为题提取最后一个
     * @param domain 查询条件
     * @return 单个对象
     */
    MoneyInRecordDomain getDomainByQuery(MoneyInRecordDomain domain,int index) throws ParseException;

    /**
     * 添加一条信息
     * @param domain 更新信息
     * @return 新记录的id
     */
    int insertDomain(MoneyInRecordDomain domain) throws ParseException;

    /**
     * 根据id更新一条信息
     * @param domain 更新信息
     */
    void updateDomainById(MoneyInRecordDomain domain);

    /**
     * 删除一条信息
     * @param id
     */
    void deleteDomain(int id);
}
