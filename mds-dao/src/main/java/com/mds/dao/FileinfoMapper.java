package com.mds.dao;

import com.mds.entity.Fileinfo;
import com.mds.vo.GoodsInfoVo;

import java.util.List;

public interface FileinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Fileinfo record);

    int insertSelective(Fileinfo record);

    Fileinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Fileinfo record);

    int updateByPrimaryKey(Fileinfo record);

    /**
     * 获取文件列表 根据实体参数
     * @param fileinfo
     * @return
     */
    List<Fileinfo> selectBySelective(Fileinfo fileinfo);

    /**
     * 根据物品明细id删除文件信息
     * @param record
     * @return
     */
    int updateByDetailId(Fileinfo record);
}