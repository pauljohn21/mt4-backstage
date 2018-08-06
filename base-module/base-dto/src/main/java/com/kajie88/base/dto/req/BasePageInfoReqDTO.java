package com.kajie88.base.dto.req;


import com.kajie88.base.dto.PageInfo;


public class BasePageInfoReqDTO<T> extends BaseReqDTO<T> {

    private PageInfo page = new PageInfo();

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }
}
