package com.kajie88.user.service;

import com.kajie88.user.domain.UserInfoDomain;

import java.util.List;

public interface UserInfoService {
    /**
     * 根据条件查询集合
     * @param domain 查询条件
     * @return domain集合
     */
    List<UserInfoDomain> getDomainList(UserInfoDomain domain);

    /**
     * 查询domian 类 多个结果支取第一个
     * @param domain 查询条件
     * @return 单个对象
     */
    UserInfoDomain getDomainByQuery(UserInfoDomain domain);
    /**
     * 查询domian 类重载方法 可指定提取下标 -1为题提取最后一个
     * @param domain 查询条件
     * @return 单个对象
     */
    UserInfoDomain getDomainByQuery(UserInfoDomain domain,int index);

    /**
     * 添加一条信息
     * @param domain 更新信息
     * @return 新记录的id
     */
    String insertDomain(UserInfoDomain domain);

    /**
     * 根据id更新一条信息
     * @param domain 更新信息
     */
    void updateDomainById(UserInfoDomain domain);

    /**
     * 删除一条信息
     * @param id
     */
    void deleteDomian(int id);
}
