package com.mds.dao;

import com.mds.entity.Goodsdetailsinfo;

public interface GoodsdetailsinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goodsdetailsinfo record);

    int insertSelective(Goodsdetailsinfo record);

    Goodsdetailsinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goodsdetailsinfo record);

    int updateByPrimaryKey(Goodsdetailsinfo record);
}