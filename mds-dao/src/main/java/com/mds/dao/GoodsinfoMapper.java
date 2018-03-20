package com.mds.dao;

import com.mds.entity.Goodsinfo;

public interface GoodsinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goodsinfo record);

    int insertSelective(Goodsinfo record);

    Goodsinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goodsinfo record);

    int updateByPrimaryKey(Goodsinfo record);
}