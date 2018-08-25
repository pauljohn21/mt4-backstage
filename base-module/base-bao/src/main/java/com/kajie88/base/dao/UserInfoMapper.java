package com.kajie88.base.dao;

import com.kajie88.base.po.UserInfo;
import com.kajie88.base.po.UserInfoExample;
import com.test.MyMapper;
import java.util.List;

public interface UserInfoMapper extends MyMapper<UserInfo> {
    int countByExample(UserInfoExample example);

    List<UserInfo> selectByExampleWithBLOBs(UserInfoExample example);

    List<UserInfo> selectByExample(UserInfoExample example);
}