package com.mds.dao;

import com.mds.entity.Dictionary;
import com.mds.entity.Goodsinfo;
import com.mds.vo.GoodsInfoVo;

import java.util.List;

public interface GoodsinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goodsinfo record);

    int insertSelective(Goodsinfo record);

    Goodsinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goodsinfo record);

    int updateByPrimaryKey(Goodsinfo record);

    /**
     * 获取物品列表 根据实体参数
     * @param goodsInfoVo
     * @return
     */
    List<GoodsInfoVo> selectBySelective(GoodsInfoVo goodsInfoVo);

    /**
     * 获取物品列表总数
     * 根据查询实体的参数
     * @param goodsInfoVo
     * @return
     */
    int selectCountBySelective(GoodsInfoVo goodsInfoVo);

    /**
     * 获取物品信息下拉框
     * @param goodsinfo
     * @return
     */
    List<Goodsinfo> getGoodsList();
}