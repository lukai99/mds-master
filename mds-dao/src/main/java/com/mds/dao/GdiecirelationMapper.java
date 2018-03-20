package com.mds.dao;

import com.mds.entity.Gdiecirelation;

public interface GdiecirelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Gdiecirelation record);

    int insertSelective(Gdiecirelation record);

    Gdiecirelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Gdiecirelation record);

    int updateByPrimaryKey(Gdiecirelation record);
}