package com.mds.dao;

import com.mds.entity.Rolemenurelation;

public interface RolemenurelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Rolemenurelation record);

    int insertSelective(Rolemenurelation record);

    Rolemenurelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Rolemenurelation record);

    int updateByPrimaryKey(Rolemenurelation record);
}