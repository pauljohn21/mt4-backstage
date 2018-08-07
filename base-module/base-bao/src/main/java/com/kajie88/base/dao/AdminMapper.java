package com.kajie88.base.dao;

import com.kajie88.base.po.Admin;
import com.kajie88.base.po.AdminExample;
import com.test.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends MyMapper<Admin> {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    List<Admin> selectByExample(AdminExample example);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);
}