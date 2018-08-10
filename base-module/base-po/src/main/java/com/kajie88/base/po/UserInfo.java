package com.kajie88.base.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_info")
public class UserInfo {
    @Id
    private Integer id;

    private String name;

    private String account;

    private String pwd;

    @Column(name = "identity_card")
    private String identityCard;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 账户类型 1（标准） 2 高级 3机构
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 货币类型(USD,EUR.,GPB,AUD,CAD）
     */
    @Column(name = "money_type")
    private String moneyType;

    /**
     * 杠杆比例 默认100
     */
    private Integer leverage;

    /**
     * 预存款
     */
    @Column(name = "advance_depost")
    private Double advanceDepost;

    /**
     * 居住地
     */
    @Column(name = "residential_country")
    private String residentialCountry;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 城市
     */
    private String city;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 就业状态
     */
    @Column(name = "job_state")
    private String jobState;

    /**
     * 工作经验
     */
    @Column(name = "job_experience")
    private String jobExperience;

    /**
     * 教育水平
     */
    @Column(name = "education_level")
    private String educationLevel;

    /**
     * 年收入
     */
    @Column(name = "annual_income")
    private String annualIncome;

    /**
     * 总资产
     */
    @Column(name = "sum_money")
    private String sumMoney;

    /**
     * 资金来源
     */
    @Column(name = "money_resource")
    private String moneyResource;

    /**
     * 风险意识
     */
    @Column(name = "risk_awareness")
    private String riskAwareness;

    /**
     * 用户状态 0为认证 1已认证 -1禁用
     */
    @Column(name = "user_state")
    private Integer userState;

    /**
     * 用户组
     */
    @Column(name = "user_group")
    private String userGroup;

    private String token;

    /**
     * 开始时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 结束时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return identity_card
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * @param identityCard
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    /**
     * 获取手机
     *
     * @return phone - 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取账户类型 1（标准） 2 高级 3机构
     *
     * @return account_type - 账户类型 1（标准） 2 高级 3机构
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置账户类型 1（标准） 2 高级 3机构
     *
     * @param accountType 账户类型 1（标准） 2 高级 3机构
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取货币类型(USD,EUR.,GPB,AUD,CAD）
     *
     * @return money_type - 货币类型(USD,EUR.,GPB,AUD,CAD）
     */
    public String getMoneyType() {
        return moneyType;
    }

    /**
     * 设置货币类型(USD,EUR.,GPB,AUD,CAD）
     *
     * @param moneyType 货币类型(USD,EUR.,GPB,AUD,CAD）
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    /**
     * 获取杠杆比例 默认100
     *
     * @return leverage - 杠杆比例 默认100
     */
    public Integer getLeverage() {
        return leverage;
    }

    /**
     * 设置杠杆比例 默认100
     *
     * @param leverage 杠杆比例 默认100
     */
    public void setLeverage(Integer leverage) {
        this.leverage = leverage;
    }

    /**
     * 获取预存款
     *
     * @return advance_depost - 预存款
     */
    public Double getAdvanceDepost() {
        return advanceDepost;
    }

    /**
     * 设置预存款
     *
     * @param advanceDepost 预存款
     */
    public void setAdvanceDepost(Double advanceDepost) {
        this.advanceDepost = advanceDepost;
    }

    /**
     * 获取居住地
     *
     * @return residential_country - 居住地
     */
    public String getResidentialCountry() {
        return residentialCountry;
    }

    /**
     * 设置居住地
     *
     * @param residentialCountry 居住地
     */
    public void setResidentialCountry(String residentialCountry) {
        this.residentialCountry = residentialCountry;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取邮编
     *
     * @return postcode - 邮编
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置邮编
     *
     * @param postcode 邮编
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取就业状态
     *
     * @return job_state - 就业状态
     */
    public String getJobState() {
        return jobState;
    }

    /**
     * 设置就业状态
     *
     * @param jobState 就业状态
     */
    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    /**
     * 获取工作经验
     *
     * @return job_experience - 工作经验
     */
    public String getJobExperience() {
        return jobExperience;
    }

    /**
     * 设置工作经验
     *
     * @param jobExperience 工作经验
     */
    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    /**
     * 获取教育水平
     *
     * @return education_level - 教育水平
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * 设置教育水平
     *
     * @param educationLevel 教育水平
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * 获取年收入
     *
     * @return annual_income - 年收入
     */
    public String getAnnualIncome() {
        return annualIncome;
    }

    /**
     * 设置年收入
     *
     * @param annualIncome 年收入
     */
    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    /**
     * 获取总资产
     *
     * @return sum_money - 总资产
     */
    public String getSumMoney() {
        return sumMoney;
    }

    /**
     * 设置总资产
     *
     * @param sumMoney 总资产
     */
    public void setSumMoney(String sumMoney) {
        this.sumMoney = sumMoney;
    }

    /**
     * 获取资金来源
     *
     * @return money_resource - 资金来源
     */
    public String getMoneyResource() {
        return moneyResource;
    }

    /**
     * 设置资金来源
     *
     * @param moneyResource 资金来源
     */
    public void setMoneyResource(String moneyResource) {
        this.moneyResource = moneyResource;
    }

    /**
     * 获取风险意识
     *
     * @return risk_awareness - 风险意识
     */
    public String getRiskAwareness() {
        return riskAwareness;
    }

    /**
     * 设置风险意识
     *
     * @param riskAwareness 风险意识
     */
    public void setRiskAwareness(String riskAwareness) {
        this.riskAwareness = riskAwareness;
    }

    /**
     * 获取用户状态 0为认证 1已认证 -1禁用
     *
     * @return user_state - 用户状态 0为认证 1已认证 -1禁用
     */
    public Integer getUserState() {
        return userState;
    }

    /**
     * 设置用户状态 0为认证 1已认证 -1禁用
     *
     * @param userState 用户状态 0为认证 1已认证 -1禁用
     */
    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    /**
     * 获取用户组
     *
     * @return user_group - 用户组
     */
    public String getUserGroup() {
        return userGroup;
    }

    /**
     * 设置用户组
     *
     * @param userGroup 用户组
     */
    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取开始时间
     *
     * @return create_time - 开始时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置开始时间
     *
     * @param createTime 开始时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取结束时间
     *
     * @return update_time - 结束时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置结束时间
     *
     * @param updateTime 结束时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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