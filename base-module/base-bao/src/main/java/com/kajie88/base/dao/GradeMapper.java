package com.kajie88.base.dao;

import com.kajie88.base.po.Grade;
import com.kajie88.base.po.GradeExample;
import com.test.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper extends MyMapper<Grade> {
    int countByExample(GradeExample example);

    int deleteByExample(GradeExample example);

    List<Grade> selectByExample(GradeExample example);

    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);
}