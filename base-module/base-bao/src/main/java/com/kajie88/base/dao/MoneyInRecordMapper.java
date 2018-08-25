package com.kajie88.base.dao;

import com.kajie88.base.po.MoneyInRecord;
import com.kajie88.base.po.MoneyInRecordExample;
import com.test.MyMapper;
import java.util.List;

public interface MoneyInRecordMapper extends MyMapper<MoneyInRecord> {
    int countByExample(MoneyInRecordExample example);

    List<MoneyInRecord> selectByExample(MoneyInRecordExample example);
}