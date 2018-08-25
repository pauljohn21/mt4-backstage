package com.kajie88.base.dao;

import com.kajie88.base.po.PlatformFile;
import com.kajie88.base.po.PlatformFileExample;
import com.test.MyMapper;
import java.util.List;

public interface PlatformFileMapper extends MyMapper<PlatformFile> {
    int countByExample(PlatformFileExample example);

    List<PlatformFile> selectByExample(PlatformFileExample example);
}