package com.kajie88.base.dao;

import com.kajie88.base.po.BankInfo;
import com.kajie88.base.po.BankInfoExample;
import com.test.MyMapper;
import java.util.List;

public interface BankInfoMapper extends MyMapper<BankInfo> {
    int countByExample(BankInfoExample example);

    List<BankInfo> selectByExampleWithBLOBs(BankInfoExample example);

    List<BankInfo> selectByExample(BankInfoExample example);
}