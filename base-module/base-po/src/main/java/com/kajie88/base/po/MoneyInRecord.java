package com.kajie88.base.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_moneyin_record")
public class MoneyInRecord {
    @Id
    private Integer id;

    /**
     * 订单编号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 通道名称
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户账号
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 存入金额
     */
    private Double money;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * p排序
     */
    private Integer rank;

    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单编号
     *
     * @return order_num - 订单编号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单编号
     *
     * @param orderNum 订单编号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取通道名称
     *
     * @return channel_id - 通道名称
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 设置通道名称
     *
     * @param channelId 通道名称
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户账号
     *
     * @return user_account - 用户账号
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置用户账号
     *
     * @param userAccount 用户账号
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获取存入金额
     *
     * @return money - 存入金额
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置存入金额
     *
     * @param money 存入金额
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取p排序
     *
     * @return rank - p排序
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置p排序
     *
     * @param rank p排序
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * @return del_flag
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}