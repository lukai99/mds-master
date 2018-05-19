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
    private String createDate;
    private String start_createDate;
    private String end_createDate;

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

    public String getCreateDate() {
        return createDate;
    }

    public String getStart_createDate() {
        return start_createDate;
    }

    public String getEnd_createDate() {
        return end_createDate;
    }

    public void setStart_createDate(String start_createDate) {
        this.start_createDate = start_createDate;
    }

    public void setEnd_createDate(String end_createDate) {
        this.end_createDate = end_createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
        if(!StringUtils.isEmpty(createDate)){
            String [] date = DateUtil.parseLayuiDate(createDate);
            this.start_createDate = date[0];
            this.end_createDate = date[1];
        }
    }
}
