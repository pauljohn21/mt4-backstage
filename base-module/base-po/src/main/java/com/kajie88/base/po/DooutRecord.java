package com.kajie88.base.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_doout_record")
public class DooutRecord {
    @Id
    private Integer id;

    @Column(name = "order_id")
    private String orderId;

    private String name;

    @Column(name = "bank_card_no")
    private String bankCardNo;

    private Double money;

    @Column(name = "bank_type")
    private String bankType;

    private String email;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "order_state")
    private String orderState;

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
     * @return order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
     * @return bank_card_no
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * @param bankCardNo
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    /**
     * @return money
     */
    public Double getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * @return bank_type
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * @param bankType
     */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return order_state
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * @param orderState
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState;
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