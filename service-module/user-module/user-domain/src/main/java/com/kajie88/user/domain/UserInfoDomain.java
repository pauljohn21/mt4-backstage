package com.kajie88.user.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.kajie88.base.dto.PageInfo;
import com.kajie88.base.po.UserInfo;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class UserInfoDomain extends UserInfo {
    /****** 查询参数 ****/
    //pageInfo需要new初始化
    @JSONField(serialize = false)
    private transient PageInfo pageInfo = new PageInfo();

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
