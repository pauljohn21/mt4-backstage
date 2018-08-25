package com.kajie88.base.dao;

import com.kajie88.base.po.Channel;
import com.kajie88.base.po.ChannelExample;
import com.test.MyMapper;
import java.util.List;

public interface ChannelMapper extends MyMapper<Channel> {
    int countByExample(ChannelExample example);

    List<Channel> selectByExample(ChannelExample example);
}