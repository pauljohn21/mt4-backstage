package com.kajie88.order.service;

import com.kajie88.order.domain.MoneyOutRecordDomain;

import java.util.List;

public interface MoneyOutRecordService {
    /**
     * 根据条件查询集合
     * @param domain 查询条件
     * @return domain集合
     */
    List<MoneyOutRecordDomain> getDomainList(MoneyOutRecordDomain domain);

    /**
     * 查询domian 类 多个结果支取第一个
     * @param domain 查询条件
     * @return 单个对象
     */
    MoneyOutRecordDomain getDomainByQuery(MoneyOutRecordDomain domain);
    /**
     * 查询domian 类重载方法 可指定提取下标 -1为题提取最后一个
     * @param domain 查询条件
     * @return 单个对象
     */
    MoneyOutRecordDomain getDomainByQuery(MoneyOutRecordDomain domain,int index);

    /**
     * 添加一条信息
     * @param domain 更新信息
     * @return 新记录的id
     */
    String insertDomain(MoneyOutRecordDomain domain);

    /**
     * 根据id更新一条信息
     * @param domain 更新信息
     */
    void updateDomainById(MoneyOutRecordDomain domain);

    /**
     * 删除一条信息
     * @param id
     */
    void deleteDomain(int id);
}
