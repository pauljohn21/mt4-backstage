package com.kajie88.base.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_moneyout_record")
public class MoneyOutRecord {
    @Id
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 出金金额
     */
    private Double money;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 电话
     */
    private String phone;

    /**
     * mt4账号
     */
    @Column(name = "mt4_account")
    private String mt4Account;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 银行卡号
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 开户行所在地
     */
    @Column(name = "bank_address")
    private String bankAddress;

    /**
     * 卡号
     */
    @Column(name = "bank_card_number")
    private String bankCardNumber;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取出金金额
     *
     * @return money - 出金金额
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置出金金额
     *
     * @param money 出金金额
     */
    public void setMoney(Double money) {
        this.money = money;
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
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取mt4账号
     *
     * @return mt4_account - mt4账号
     */
    public String getMt4Account() {
        return mt4Account;
    }

    /**
     * 设置mt4账号
     *
     * @param mt4Account mt4账号
     */
    public void setMt4Account(String mt4Account) {
        this.mt4Account = mt4Account;
    }

    /**
     * 获取电子邮件
     *
     * @return email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取银行卡号
     *
     * @return bank_name - 银行卡号
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置银行卡号
     *
     * @param bankName 银行卡号
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取开户行所在地
     *
     * @return bank_address - 开户行所在地
     */
    public String getBankAddress() {
        return bankAddress;
    }

    /**
     * 设置开户行所在地
     *
     * @param bankAddress 开户行所在地
     */
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    /**
     * 获取卡号
     *
     * @return bank_card_number - 卡号
     */
    public String getBankCardNumber() {
        return bankCardNumber;
    }

    /**
     * 设置卡号
     *
     * @param bankCardNumber 卡号
     */
    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
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
     * @return rank
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * @param rank
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