package com.kajie88.base.po;

import javax.persistence.*;

@Table(name = "t_bank_info")
public class BankInfo {
    @Id
    private Integer id;

    /**
     * 银行名称
     */
    private String name;

    /**
     * 所属通道
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 银行的启用状态
     */
    private Integer status;

    /**
     * 支付类型
     */
    @Column(name = "pay_type")
    private String payType;

    @Column(name = "rpn_pay_name")
    private String rpnPayName;

    @Column(name = "rpn_pay_no")
    private String rpnPayNo;

    @Column(name = "rpn_pay_key")
    private String rpnPayKey;

    @Column(name = "rpn_pay_version")
    private String rpnPayVersion;

    @Column(name = "rpn_pay_bank_id")
    private String rpnPayBankId;

    @Column(name = "rpn_pay_to_bank")
    private String rpnPayToBank;

    private Integer rank;

    @Column(name = "del_flag")
    private Integer delFlag;

    @Column(name = "pay_img_fir")
    private String payImgFir;

    @Column(name = "pay_img_sec")
    private String payImgSec;

    @Column(name = "pay_img_thir")
    private String payImgThir;

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
     * 获取银行名称
     *
     * @return name - 银行名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置银行名称
     *
     * @param name 银行名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取所属通道
     *
     * @return channel_id - 所属通道
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 设置所属通道
     *
     * @param channelId 所属通道
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取银行的启用状态
     *
     * @return status - 银行的启用状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置银行的启用状态
     *
     * @param status 银行的启用状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取支付类型
     *
     * @return pay_type - 支付类型
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付类型
     *
     * @param payType 支付类型
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * @return rpn_pay_name
     */
    public String getRpnPayName() {
        return rpnPayName;
    }

    /**
     * @param rpnPayName
     */
    public void setRpnPayName(String rpnPayName) {
        this.rpnPayName = rpnPayName;
    }

    /**
     * @return rpn_pay_no
     */
    public String getRpnPayNo() {
        return rpnPayNo;
    }

    /**
     * @param rpnPayNo
     */
    public void setRpnPayNo(String rpnPayNo) {
        this.rpnPayNo = rpnPayNo;
    }

    /**
     * @return rpn_pay_key
     */
    public String getRpnPayKey() {
        return rpnPayKey;
    }

    /**
     * @param rpnPayKey
     */
    public void setRpnPayKey(String rpnPayKey) {
        this.rpnPayKey = rpnPayKey;
    }

    /**
     * @return rpn_pay_version
     */
    public String getRpnPayVersion() {
        return rpnPayVersion;
    }

    /**
     * @param rpnPayVersion
     */
    public void setRpnPayVersion(String rpnPayVersion) {
        this.rpnPayVersion = rpnPayVersion;
    }

    /**
     * @return rpn_pay_bank_id
     */
    public String getRpnPayBankId() {
        return rpnPayBankId;
    }

    /**
     * @param rpnPayBankId
     */
    public void setRpnPayBankId(String rpnPayBankId) {
        this.rpnPayBankId = rpnPayBankId;
    }

    /**
     * @return rpn_pay_to_bank
     */
    public String getRpnPayToBank() {
        return rpnPayToBank;
    }

    /**
     * @param rpnPayToBank
     */
    public void setRpnPayToBank(String rpnPayToBank) {
        this.rpnPayToBank = rpnPayToBank;
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

    /**
     * @return pay_img_fir
     */
    public String getPayImgFir() {
        return payImgFir;
    }

    /**
     * @param payImgFir
     */
    public void setPayImgFir(String payImgFir) {
        this.payImgFir = payImgFir;
    }

    /**
     * @return pay_img_sec
     */
    public String getPayImgSec() {
        return payImgSec;
    }

    /**
     * @param payImgSec
     */
    public void setPayImgSec(String payImgSec) {
        this.payImgSec = payImgSec;
    }

    /**
     * @return pay_img_thir
     */
    public String getPayImgThir() {
        return payImgThir;
    }

    /**
     * @param payImgThir
     */
    public void setPayImgThir(String payImgThir) {
        this.payImgThir = payImgThir;
    }
}