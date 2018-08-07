package com.kajie88.base.dao;

import com.kajie88.base.po.PlatformDictionary;
import com.kajie88.base.po.PlatformDictionaryExample;
import com.test.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatformDictionaryMapper extends MyMapper<PlatformDictionary> {
    int countByExample(PlatformDictionaryExample example);

    int deleteByExample(PlatformDictionaryExample example);

    List<PlatformDictionary> selectByExample(PlatformDictionaryExample example);

    int updateByExampleSelective(@Param("record") PlatformDictionary record, @Param("example") PlatformDictionaryExample example);

    int updateByExample(@Param("record") PlatformDictionary record, @Param("example") PlatformDictionaryExample example);
}