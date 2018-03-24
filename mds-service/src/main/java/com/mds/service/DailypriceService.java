package com.mds.service;

import com.mds.common.ResultVo;
import com.mds.entity.Dailyprice;
import com.mds.utils.PageBean;
import com.mds.vo.DailypriceVo;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/3/21
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public interface DailypriceService {

    /**
     * 添加查询每日价格
     * @param dailyprice
     * @return
     */
    public ResultVo<Dailyprice> saveDailyprice(Dailyprice dailyprice);

    /**
     * 修改查询每日价格
     * @param dailyprice
     * @return
     */
    public ResultVo<Dailyprice> updateDailyprice(Dailyprice dailyprice);

    /**
     * 删除查询每日价格
     * 逻辑删除
     * @param id
     * @return
     */
    public ResultVo<Dailyprice> deleteDailypriceForUpdate(String id);

    /**
     * 删除查询每日价格
     * 批量删除
     * 逻辑删除
     * @param ids
     * @return
     */
    public ResultVo<Dailyprice> deleteDailypriceForUpdate(String [] ids);

    /**
     * 删除查询每日价格
     * 物理删除
     * @param id
     * @return
     */
    public ResultVo<Dailyprice> deleteDailypriceForDelete(String id);

    /**
     * 删除查询每日价格
     * 批量删除
     * 物理删除
     * @param ids
     * @return
     */
    public ResultVo<Dailyprice> deleteDailypriceForDelete(String[] ids);

    /**
     * 查询每日价格信息
     * 分页专用
     * @param dailypriceVo
     * @param pageBean
     * @return
     */
    public PageBean<DailypriceVo> queryDailyprice(DailypriceVo dailypriceVo, PageBean pageBean);

    /**
     * 查询每日价格信息
     * 根据id
     * @param id
     * @return
     */
    public ResultVo<Dailyprice> queryDailyprice(String id);

    /**
     * 查询每日价格信息
     * 根据查询实体
     * @param dailypriceVo
     * @return
     */
    public ResultVo<DailypriceVo> queryDailyprice(DailypriceVo dailypriceVo);
}
