package com.kajie88.base.dao;

import com.kajie88.base.po.Admin;
import com.kajie88.base.po.AdminExample;
import com.test.MyMapper;
import java.util.List;

public interface AdminMapper extends MyMapper<Admin> {
    int countByExample(AdminExample example);

    List<Admin> selectByExample(AdminExample example);
}