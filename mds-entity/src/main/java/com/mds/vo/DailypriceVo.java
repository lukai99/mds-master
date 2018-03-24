package com.mds.vo;

import com.mds.entity.Dailyprice;
import com.mds.utils.DateUtil;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/3/21
 * Time: 22:16
 * To change this template use File | Settings | File Templates.
 */
public class DailypriceVo extends Dailyprice{

    private String name;//基础元素名称
    private String queryDate;//查询时间范围
    private String startDate;//开始时间
    private String endDate;//结束时间

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(String queryDate) {
        this.queryDate = queryDate;
        if(!StringUtils.isEmpty(queryDate)){
            String [] date = DateUtil.parseLayuiDate(queryDate);
            this.startDate = date[0];
            this.endDate = date[1];
        }
    }
}
