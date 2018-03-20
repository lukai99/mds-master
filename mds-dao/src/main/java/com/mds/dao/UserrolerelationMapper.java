package com.mds.dao;

import com.mds.entity.Userrolerelation;

public interface UserrolerelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Userrolerelation record);

    int insertSelective(Userrolerelation record);

    Userrolerelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Userrolerelation record);

    int updateByPrimaryKey(Userrolerelation record);
}