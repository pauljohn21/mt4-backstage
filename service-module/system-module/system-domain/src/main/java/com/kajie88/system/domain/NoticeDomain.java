package com.kajie88.system.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.kajie88.base.dto.PageInfo;
import com.kajie88.base.enums.common.SqlSortType;
import com.kajie88.base.po.Notice;

public class NoticeDomain extends Notice{
    /****** 查询参数 ****/
    //pageInfo需要new初始化
    @JSONField(serialize = false)
    private transient PageInfo pageInfo = new PageInfo();
    private SqlSortType createTimeSortType= SqlSortType.ASC;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public SqlSortType getCreateTimeSortType() {
        return createTimeSortType;
    }

    public void setCreateTimeSortType(SqlSortType createTimeSortType) {
        this.createTimeSortType = createTimeSortType;
    }

}
