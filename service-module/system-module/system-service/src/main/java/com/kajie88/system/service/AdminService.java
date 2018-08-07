package com.kajie88.system.service;

import com.kajie88.system.domain.AdminDomain;

import java.util.List;

public interface AdminService {
    /**
     * 根据条件查询集合
     * @param domain 查询条件
     * @return domain集合
     */
    List<AdminDomain> getDomainList(AdminDomain domain);

    /**
     * 查询domian 类 多个结果支取第一个
     * @param domain 查询条件
     * @return 单个对象
     */
    AdminDomain getDomainByQuery(AdminDomain domain);
    /**
     * 查询domian 类重载方法 可指定提取下标 -1为题提取最后一个
     * @param domain 查询条件
     * @return 单个对象
     */
    AdminDomain getDomainByQuery(AdminDomain domain,int index);

    /**
     * 添加一条信息
     * @param domain 更新信息
     * @return 新记录的id
     */
    String insertDomain(AdminDomain domain);

    /**
     * 根据id更新一条信息
     * @param domain 更新信息
     */
    void updateDomainById(AdminDomain domain);

}
