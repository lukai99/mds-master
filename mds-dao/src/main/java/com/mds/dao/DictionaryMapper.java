package com.mds.dao;

import com.mds.entity.Dictionary;
import com.mds.utils.PageBean;

import java.util.List;

public interface DictionaryMapper {

    int deleteByPrimaryKey(String id);

    /**
     * 添加数据字典 全字段
     * @param record
     * @return
     */
    int insert(Dictionary record);

    /**
     * 添加数据字典 不为空的字段
     * @param record
     * @return
     */
    int insertSelective(Dictionary record);

    /**
     * 修改数据字典 不为空的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Dictionary record);

    /**
     * 修改数据字典 全字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(Dictionary record);

    /**
     * 根据主键获取
     * @param id
     * @return
     */
    Dictionary selectByPrimaryKey(String id);

    /**
     * 获取字典项 根据实体参数
     * @param dictionary
     * @return
     */
    List<Dictionary> selectBySelective(Dictionary dictionary);

    /**
     * 获取数据字典总数
     * 根据查询实体的参数
     * @param dictionary
     * @return
     */
    int selectCountBySelective(Dictionary dictionary);
}