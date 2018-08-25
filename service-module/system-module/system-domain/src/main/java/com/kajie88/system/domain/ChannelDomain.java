package com.kajie88.system.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.kajie88.base.dto.PageInfo;
import com.kajie88.base.enums.common.SqlSortType;
import com.kajie88.base.po.Channel;
import com.kajie88.base.po.Notice;

import java.util.ArrayList;
import java.util.List;

public class ChannelDomain extends Channel {
    private List<BankInfoDomain> bankInfoList = new ArrayList<>();
    /****** 查询参数 ****/
    //pageInfo需要new初始化
    @JSONField(serialize = false)
    private SqlSortType createTimeSortType= SqlSortType.ASC;

    public SqlSortType getCreateTimeSortType() {
        return createTimeSortType;
    }

    public void setCreateTimeSortType(SqlSortType createTimeSortType) {
        this.createTimeSortType = createTimeSortType;
    }

    public List<BankInfoDomain> getBankInfoList() {
        return bankInfoList;
    }

    public void setBankInfoList(List<BankInfoDomain> bankInfoList) {
        this.bankInfoList = bankInfoList;
    }
}
