package com.kajie88.base.dao;

import com.kajie88.base.po.Notice;
import com.kajie88.base.po.NoticeExample;
import com.test.MyMapper;
import java.util.List;

public interface NoticeMapper extends MyMapper<Notice> {
    int countByExample(NoticeExample example);

    List<Notice> selectByExampleWithBLOBs(NoticeExample example);

    List<Notice> selectByExample(NoticeExample example);
}