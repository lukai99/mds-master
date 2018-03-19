package com.mds.service;

import com.mds.entity.DataCheck;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-11-14
 * Time: 下午9:48
 * To change this template use File | Settings | File Templates.
 */
public interface ShareDataCheckService {

    /**
     * 获取全部选点数据
     * @return
     */
    public List<DataCheck> queryDataCheckList();

    /**
     * 获取股票的选点数据
     * @param shareCode
     * @return
     */
    public List<DataCheck> queryDataCheckList(String shareCode);

    /**
     * 获取单条选点数据 根据id
     * @param id
     * @return
     */
    public DataCheck getDataCheck(Integer id);

    /**
     * 添加选点数据
     * @param dataCheck
     * @return
     */
    public Integer addDataCheck(DataCheck dataCheck);

    /**
     * 修改选点数据
     * @param dataCheck
     * @return
     */
    public boolean updateDataCheck(DataCheck dataCheck);

    /**
     * 删除选点数据
     * @param id
     * @return
     */
    public boolean deleteDataCheck(Integer id);
}
