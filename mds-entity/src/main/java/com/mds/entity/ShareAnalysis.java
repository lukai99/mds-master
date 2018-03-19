package com.mds.entity;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-11-5
 * Time: 下午4:11
 * To change this template use File | Settings | File Templates.
 */
public class ShareAnalysis extends BaseEntity{
    private Integer id;//数据id
    private Integer shareId;  //股票数据id
    private Double high;    //高点
    private Double low;     //低点
    private Double expectTzl;//预期调整率
    private Double expectTzJg;//预期调整价格
    private Double tzl;     //实际调整率
    private Double tzJg;    //实际跳转价格

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
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

    public Double getExpectTzl() {
        return expectTzl;
    }

    public void setExpectTzl(Double expectTzl) {
        this.expectTzl = expectTzl;
    }

    public Double getExpectTzJg() {
        return expectTzJg;
    }

    public void setExpectTzJg(Double expectTzJg) {
        this.expectTzJg = expectTzJg;
    }

    public Double getTzl() {
        return tzl;
    }

    public void setTzl(Double tzl) {
        this.tzl = tzl;
    }

    public Double getTzJg() {
        return tzJg;
    }

    public void setTzJg(Double tzJg) {
        this.tzJg = tzJg;
    }
}
