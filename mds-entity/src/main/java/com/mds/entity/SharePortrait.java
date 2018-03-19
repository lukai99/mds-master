package com.mds.entity;

import java.util.Date;

/**
 * 股票画像
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-10-16
 * Time: 下午10:31
 * To change this template use File | Settings | File Templates.
 */
public class SharePortrait {

    private Integer id;//数据编号
    private String sharesCode;//股票编号
    private Double price;//价格
    private Date time;//日期
    private Date createTime;//创建日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSharesCode() {
        return sharesCode;
    }

    public void setSharesCode(String sharesCode) {
        this.sharesCode = sharesCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
