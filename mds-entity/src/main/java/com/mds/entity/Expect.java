package com.mds.entity;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-15
 * Time: 上午10:53
 * To change this template use File | Settings | File Templates.
 */
public class Expect extends BaseEntity {

    private Integer id;    // 预期编号 数据id
    private Integer enough; //势能 0-9 5为均势 0最大空势 9最大多势
    private Integer trend; //涨跌趋势 1 多 0 空',
    private Double highPrice; //高点价格',
    private Double lowPrice; //低点价格',
    private Double expectPrice; //预期价格',
    private Double stopPrice; //止损价格',
    private Double actualPrice; //实际价格',
    private String sharesCode; //股票编号',
    private Integer formulaCode; //公式编号',

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnough() {
        return enough;
    }

    public void setEnough(Integer enough) {
        this.enough = enough;
    }

    public Integer getTrend() {
        return trend;
    }

    public void setTrend(Integer trend) {
        this.trend = trend;
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

    public Double getExpectPrice() {
        return expectPrice;
    }

    public void setExpectPrice(Double expectPrice) {
        this.expectPrice = expectPrice;
    }

    public Double getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(Double stopPrice) {
        this.stopPrice = stopPrice;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getSharesCode() {
        return sharesCode;
    }

    public void setSharesCode(String sharesCode) {
        this.sharesCode = sharesCode;
    }

    public Integer getFormulaCode() {
        return formulaCode;
    }

    public void setFormulaCode(Integer formulaCode) {
        this.formulaCode = formulaCode;
    }
}
