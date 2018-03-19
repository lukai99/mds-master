package com.mds.entity;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-11-14
 * Time: 下午9:36
 * To change this template use File | Settings | File Templates.
 */
public class DataCheck extends BaseEntity{

    private Integer id;//数据编号
    private String shareCode;//股票代码
    private Double high; //高点
    private String highDate;//高点日期
    private Double low; //低点
    private String lowDate;//低点日期
    private Double tz;  //调整点
    private Double tzl;//调整率
    private String tzDate;//调整点日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getTz() {
        return tz;
    }

    public void setTz(Double tz) {
        this.tz = tz;
    }

    public String getHighDate() {
        return highDate;
    }

    public void setHighDate(String highDate) {
        this.highDate = highDate;
    }

    public String getLowDate() {
        return lowDate;
    }

    public void setLowDate(String lowDate) {
        this.lowDate = lowDate;
    }

    public String getTzDate() {
        return tzDate;
    }

    public void setTzDate(String tzDate) {
        this.tzDate = tzDate;
    }

    public Double getTzl() {
        return tzl;
    }

    public void setTzl(Double tzl) {
        this.tzl = tzl;
    }
}
