package com.mds.service;

import com.mds.common.ResultVo;
import com.mds.entity.Goodsinfo;
import com.mds.utils.PageBean;
import com.mds.vo.GoodsInfoVo;

/**
 * Created by ASUS on 2018/3/21.
 */
public interface GoodsInfoService {
    /**
     * 添加物品
     * @param goodsinfo
     * @return
     */
    public ResultVo<Goodsinfo> saveGoodsInfo(Goodsinfo goodsinfo);

    /**
     * 修改物品
     * @param goodsinfo
     * @return
     */
    public ResultVo<Goodsinfo> updateGoodsInfo(Goodsinfo goodsinfo);

    /**
     * 删除物品
     * 逻辑删除
     * @param id
     * @return
     */
    public ResultVo<Goodsinfo> deleteGoodsInfoForUpdate(String id);

    /**
     * 删除物品
     * 逻辑删除(批量)
     * @param ids
     * @return
     */
    public ResultVo<Goodsinfo> deleteGoodsInfoForUpdate(String[] ids);

    /**
     * 删除物品
     * 物理删除
     * @param id
     * @return
     */
    public ResultVo<Goodsinfo> deleteGoodsInfoForDelete(String id);
    /**
     * 删除物品
     * 物理删除(批量)
     * @param ids
     * @return
     */
    public ResultVo<Goodsinfo> deleteGoodsInfoForDelete(String[] ids);

    /**
     * 查询物品信息
     * 分页专用
     * @param goodsInfoVo
     * @param pageBean
     * @return
     */
    public PageBean<GoodsInfoVo> queryGoodsInfo(GoodsInfoVo goodsInfoVo, PageBean pageBean);

    /**
     * 查询物品信息
     * 根据id
     * @param id
     * @return
     */
    public ResultVo<Goodsinfo> queryGoodsInfo(String id);

    /**
     * 查询物品信息
     * 根据查询实体
     * @param goodsInfoVo
     * @return
     */
    public ResultVo<GoodsInfoVo> querySharesAccountInfo(GoodsInfoVo goodsInfoVo);
}
