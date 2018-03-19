package com.mds.entity;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-15
 * Time: 上午10:53
 * To change this template use File | Settings | File Templates.
 */
public class Operation {
    private Integer id;
    private String code; //操作编号',
    private Double buyPrice;//买入价格',
    private Double sellPrice;//卖出价格',
    private Double profitPrice;//效益价格',
    private String remark;//备注',

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getProfitPrice() {
        return profitPrice;
    }

    public void setProfitPrice(Double profitPrice) {
        this.profitPrice = profitPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
