package com.mds.entity;

import com.mds.utils.PageBean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/14
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class SharesHistoryData extends PageBean<SharesHistoryData>{

    private String id;//数据id

    private String sharesId;//股票数据id

    private String frequency;//数据周期 1：年，2：季， 3：月，4：周，5：日，6：一百二十分钟,7：六十分钟，8：三十分钟，9：十五分钟，10:五分钟，11:一分钟

    private Double startPrice;//开盘价

    private Double highPrice;//最高价

    private Double lowPrice;//最低价

    private Double endPrice;//收盘价

    private String upVal;//涨幅

    private String amplitude;//振幅

    private String countNum;//总手

    private String countMoney;//金额

    private String changedHands;//换手

    private Integer volamount;//成交次数

    private Date dataTime;//数据时间

    private Date createTime;//创建时间

    /*冗余字段*/
    private String sharesName;//股票名称

    private String sharesCode;//股票编号

    private int kChartStartIndex;//数据开始下标

    public SharesHistoryData(String id, String sharesId, String frequency, Double startPrice, Double highPrice, Double lowPrice, Double endPrice, String upVal, String amplitude, String countNum, String countMoney, String changedHands, Integer volamount, Date dataTime, Date createTime) {
        this.id = id;
        this.sharesId = sharesId;
        this.frequency = frequency;
        this.startPrice = startPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.endPrice = endPrice;
        this.upVal = upVal;
        this.amplitude = amplitude;
        this.countNum = countNum;
        this.countMoney = countMoney;
        this.changedHands = changedHands;
        this.volamount = volamount;
        this.dataTime = dataTime;
        this.createTime = createTime;
    }

    public SharesHistoryData() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSharesId() {
        return sharesId;
    }

    public void setSharesId(String sharesId) {
        this.sharesId = sharesId == null ? null : sharesId.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Double endPrice) {
        this.endPrice = endPrice;
    }

    public String getUpVal() {
        return upVal;
    }

    public void setUpVal(String upVal) {
        this.upVal = upVal == null ? null : upVal.trim();
    }

    public String getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(String amplitude) {
        this.amplitude = amplitude == null ? null : amplitude.trim();
    }

    public String getCountNum() {
        return countNum;
    }

    public void setCountNum(String countNum) {
        this.countNum = countNum == null ? null : countNum.trim();
    }

    public String getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(String countMoney) {
        this.countMoney = countMoney == null ? null : countMoney.trim();
    }

    public String getChangedHands() {
        return changedHands;
    }

    public void setChangedHands(String changedHands) {
        this.changedHands = changedHands == null ? null : changedHands.trim();
    }

    public Integer getVolamount() {
        return volamount;
    }

    public void setVolamount(Integer volamount) {
        this.volamount = volamount;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSharesName() {
        return sharesName;
    }

    public void setSharesName(String sharesName) {
        this.sharesName = sharesName;
    }

    public String getSharesCode() {
        return sharesCode;
    }

    public void setSharesCode(String sharesCode) {
        this.sharesCode = sharesCode;
    }

    public int getkChartStartIndex() {
        return kChartStartIndex;
    }

    public void setkChartStartIndex(int kChartStartIndex) {
        this.kChartStartIndex = kChartStartIndex;
    }
}
