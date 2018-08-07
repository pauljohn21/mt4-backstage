package com.kajie88.base.dao;

import com.kajie88.base.po.PlatformFile;
import com.kajie88.base.po.PlatformFileExample;
import com.test.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatformFileMapper extends MyMapper<PlatformFile> {
    int countByExample(PlatformFileExample example);

    int deleteByExample(PlatformFileExample example);

    List<PlatformFile> selectByExample(PlatformFileExample example);

    int updateByExampleSelective(@Param("record") PlatformFile record, @Param("example") PlatformFileExample example);

    int updateByExample(@Param("record") PlatformFile record, @Param("example") PlatformFileExample example);
}