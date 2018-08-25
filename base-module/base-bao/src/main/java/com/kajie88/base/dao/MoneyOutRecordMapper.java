package com.kajie88.base.dao;

import com.kajie88.base.po.MoneyOutRecord;
import com.kajie88.base.po.MoneyOutRecordExample;
import com.test.MyMapper;
import java.util.List;

public interface MoneyOutRecordMapper extends MyMapper<MoneyOutRecord> {
    int countByExample(MoneyOutRecordExample example);

    List<MoneyOutRecord> selectByExample(MoneyOutRecordExample example);
}