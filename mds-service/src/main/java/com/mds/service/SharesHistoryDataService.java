package com.mds.service;

import com.mds.entity.SharesHistoryData;
import com.mds.utils.PageBean;
import com.mds.common.ResultVo;
import com.mds.vo.KChartDataVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/14
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public interface SharesHistoryDataService {

    /**
     * 导入历史数据通过excel方式
     * @return
     */
    public ResultVo impSharesHistoryData(MultipartFile file);

    /**
     * 解析execl文件中的数据
     * @param fileInputStream
     * @return
     */
    public List<SharesHistoryData> analysisExeclData(InputStream fileInputStream);

    /**
     * 获取股票历史数据 根据查询条件 分页模式
     * @param sharesHistoryData
     * @return
     */
    public PageBean<SharesHistoryData> querySharesHistoryData(SharesHistoryData sharesHistoryData);

    /**
     * 获取股票数据 用于K线数据展示
     * @param sharesHistoryData
     * @return
     */
    public KChartDataVo queryKChartData(SharesHistoryData sharesHistoryData);

    /**
     * 获取模拟游戏的股票数据
     * @param gameCode
     * @param next
     * @return
     */
    public KChartDataVo queryGameKChartData(String gameCode, String next);
}
