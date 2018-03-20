package com.mds.dao;

import com.mds.entity.Dailyprice;

public interface DailypriceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dailyprice record);

    int insertSelective(Dailyprice record);

    Dailyprice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dailyprice record);

    int updateByPrimaryKey(Dailyprice record);
}