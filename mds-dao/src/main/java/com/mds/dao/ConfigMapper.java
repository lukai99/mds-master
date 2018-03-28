package com.mds.dao;

import com.mds.entity.Config;

import java.util.List;

public interface ConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);

    /**
     * 查询系统配置
     * 根据查询实体
     * @param config
     * @return
     */
    List<Config> selectBySelective(Config config);
}