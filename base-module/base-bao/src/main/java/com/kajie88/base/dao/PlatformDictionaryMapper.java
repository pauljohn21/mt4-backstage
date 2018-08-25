package com.kajie88.base.dao;

import com.kajie88.base.po.PlatformDictionary;
import com.kajie88.base.po.PlatformDictionaryExample;
import com.test.MyMapper;
import java.util.List;

public interface PlatformDictionaryMapper extends MyMapper<PlatformDictionary> {
    int countByExample(PlatformDictionaryExample example);

    List<PlatformDictionary> selectByExample(PlatformDictionaryExample example);
}