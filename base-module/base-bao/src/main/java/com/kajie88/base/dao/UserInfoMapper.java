package com.kajie88.base.dao;

import com.kajie88.base.po.UserInfo;
import com.kajie88.base.po.UserInfoExample;
import com.test.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper extends MyMapper<UserInfo> {
    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    List<UserInfo> selectByExample(UserInfoExample example);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);
}