package com.mds.dao;

import com.mds.entity.Goodsdetailsinfo;
import com.mds.vo.GoodsInfoVo;
import com.mds.vo.GoodsdetailsinfoVo;

import java.util.List;

public interface GoodsdetailsinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goodsdetailsinfo record);

    int insertSelective(Goodsdetailsinfo record);

    Goodsdetailsinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goodsdetailsinfo record);

    int updateByPrimaryKey(Goodsdetailsinfo record);

    /**
     * 获取物品信息详情列表 根据实体参数
     * @param goodsDetailVo
     * @return
     */
    List<GoodsdetailsinfoVo> selectBySelective(GoodsdetailsinfoVo goodsDetailVo);

    /**
     * 获取物品信息详情总数
     * 根据查询实体的参数
     * @param goodsDetailVo
     * @return
     */
    int selectCountBySelective(GoodsdetailsinfoVo goodsDetailVo);

    List<GoodsdetailsinfoVo> listGoodsDetail(GoodsdetailsinfoVo goodsdetailsinfoVo);

    int countGoodsDetail(GoodsdetailsinfoVo goodsdetailsinfoVo);
}