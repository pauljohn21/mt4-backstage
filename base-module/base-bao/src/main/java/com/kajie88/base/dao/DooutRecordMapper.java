package com.kajie88.base.dao;

import com.kajie88.base.po.DooutRecord;
import com.kajie88.base.po.DooutRecordExample;
import com.test.MyMapper;
import java.util.List;

public interface DooutRecordMapper extends MyMapper<DooutRecord> {
    int countByExample(DooutRecordExample example);

    List<DooutRecord> selectByExample(DooutRecordExample example);
}