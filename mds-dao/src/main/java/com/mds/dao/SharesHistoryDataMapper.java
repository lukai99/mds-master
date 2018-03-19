package com.mds.dao;

import com.mds.entity.SharesHistoryData;
import com.mds.utils.PageBean;

import java.util.List;

public interface SharesHistoryDataMapper {
    /**
     * 删除股票历史数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 添加股票历史数据
     * @param record
     * @return
     */
    int insert(SharesHistoryData record);

    /**
     * 添加股票历史数据 不为空的字段
     * @param record
     * @return
     */
    int insertSelective(SharesHistoryData record);

    /**
     * 修改股票历史数据 不为空的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SharesHistoryData record);

    /**
     * 修改股票历史数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(SharesHistoryData record);

    /**
     * 获取股票历史数据 根据数据主键
     * @param id
     * @return
     */
    SharesHistoryData selectByPrimaryKey(String id);

    /**
     * 获取股票历史数据
     * 分页查询
     * @param sharesHistoryData
     * @return
     */
    List<SharesHistoryData> selectBySelective(SharesHistoryData sharesHistoryData);

    /**
     * 获取股票历史数据总数
     * @param sharesHistoryData
     * @return
     */
    int selectCountBySelective(SharesHistoryData sharesHistoryData);

    /**
     * 获取股票历史数据
     * 无分页查询
     * @param sharesHistoryData
     * @return
     */
    List<SharesHistoryData> selectForNoPageBySelective(SharesHistoryData sharesHistoryData);

    /**
     * 获取随机股票数据
     * @param sharesHistoryData
     * @return
     */
    SharesHistoryData getRandStartData(SharesHistoryData sharesHistoryData);

    /**
     * 获得数据的位置
     * @param dataId
     * @return
     */
    int getDataStartIndex(String dataId);

}