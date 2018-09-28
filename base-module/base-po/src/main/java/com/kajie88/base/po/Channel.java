package com.kajie88.base.po;

import javax.persistence.*;

@Table(name = "t_channel")
public class Channel {
    @Id
    private Integer id;

    /**
     * 通道名称
     */
    private String name;

    /**
     * funToPay,aoyou,caiHuiTong
     */
    @Column(name = "payType")
    private String paytype;

    /**
     * 排序
     */
    private Integer rank;

    /**
     * 最低支付
     */
    @Column(name = "pay_min")
    private Double payMin;

    /**
     * 最高支付
     */
    @Column(name = "pay_max")
    private Double payMax;

    /**
     * 每日支付限额
     */
    @Column(name = "pay_limit")
    private Double payLimit;

    /**
     * 是否启用
     */
    private String status;

    /**
     * 删除标识
     */
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
     * 获取通道名称
     *
     * @return name - 通道名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置通道名称
     *
     * @param name 通道名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取funToPay,aoyou,caiHuiTong
     *
     * @return payType - funToPay,aoyou,caiHuiTong
     */
    public String getPaytype() {
        return paytype;
    }

    /**
     * 设置funToPay,aoyou,caiHuiTong
     *
     * @param paytype funToPay,aoyou,caiHuiTong
     */
    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    /**
     * 获取排序
     *
     * @return rank - 排序
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置排序
     *
     * @param rank 排序
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 获取最低支付
     *
     * @return pay_min - 最低支付
     */
    public Double getPayMin() {
        return payMin;
    }

    /**
     * 设置最低支付
     *
     * @param payMin 最低支付
     */
    public void setPayMin(Double payMin) {
        this.payMin = payMin;
    }

    /**
     * 获取最高支付
     *
     * @return pay_max - 最高支付
     */
    public Double getPayMax() {
        return payMax;
    }

    /**
     * 设置最高支付
     *
     * @param payMax 最高支付
     */
    public void setPayMax(Double payMax) {
        this.payMax = payMax;
    }

    /**
     * 获取每日支付限额
     *
     * @return pay_limit - 每日支付限额
     */
    public Double getPayLimit() {
        return payLimit;
    }

    /**
     * 设置每日支付限额
     *
     * @param payLimit 每日支付限额
     */
    public void setPayLimit(Double payLimit) {
        this.payLimit = payLimit;
    }

    /**
     * 获取是否启用
     *
     * @return status - 是否启用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置是否启用
     *
     * @param status 是否启用
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取删除标识
     *
     * @return del_flag - 删除标识
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标识
     *
     * @param delFlag 删除标识
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}