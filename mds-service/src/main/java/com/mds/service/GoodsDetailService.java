package com.mds.service;


import com.mds.common.ResultVo;
import com.mds.entity.Goodsdetailsinfo;
import com.mds.utils.PageBean;
import com.mds.vo.GoodsdetailsinfoVo;

import java.util.List;

public interface GoodsDetailService {

    /**
     * 添加物品详情
     * @param detailsinfo
     * @return
     */
    public ResultVo<Goodsdetailsinfo> saveGoodsDetail(GoodsdetailsinfoVo detailsinfo);

    /**
     * 修改物品详情
     * @param detailsinfo
     * @return
     */
    public ResultVo<Goodsdetailsinfo> updateGoodsDetail(GoodsdetailsinfoVo detailsinfo);

    /**
     * 删除物品详情
     * 逻辑删除
     * @param id
     * @return
     */
    public ResultVo<Goodsdetailsinfo> deleteGoodsDetailForUpdate(String id);

    /**
     * 删除物品详情
     * 逻辑删除(批量)
     * @param ids
     * @return
     */
    public ResultVo<Goodsdetailsinfo> deleteGoodsDetailForUpdate(String[] ids);

    /**
     * 删除物品详情
     * 物理删除
     * @param id
     * @return
     */
    public ResultVo<Goodsdetailsinfo> deleteGoodsDetailForDelete(String id);
    /**
     * 删除物品详情
     * 物理删除(批量)
     * @param ids
     * @return
     */
    public ResultVo<Goodsdetailsinfo> deleteGoodsDetailForDelete(String[] ids);

    /**
     * 查询物品信息详情
     * 分页专用
     * @param goodsdetailVo
     * @param pageBean
     * @return
     */
    public PageBean<GoodsdetailsinfoVo> queryGoodsDetail(GoodsdetailsinfoVo goodsdetailVo, PageBean pageBean);

    /**
     * 查询物品信息详情
     * 根据id
     * @param id
     * @return
     */
    public ResultVo<GoodsdetailsinfoVo> queryGoodsDetail(String id);

    /**
     * 查询物品信息
     * 根据查询实体
     * @param goodsdetailVo
     * @return
     */
    public ResultVo<GoodsdetailsinfoVo> queryGoodsDetail(GoodsdetailsinfoVo goodsdetailVo);

    /**
     * 获得还未检测的物品信息详情
     * @return
     */
    public List<GoodsdetailsinfoVo> getUnCheckList();

}