package com.mds.entity;

import com.mds.utils.PageBean;

import java.util.Date;

public class Gdiecirelation extends PageBean {
    private String id;

    private String goodsdetailsinfoid;

    private String baseelementid;

    private String isdel;

    private Date createtime;

    public Gdiecirelation(String id, String goodsdetailsinfoid, String baseelementid, String isdel, Date createtime) {
        this.id = id;
        this.goodsdetailsinfoid = goodsdetailsinfoid;
        this.baseelementid = baseelementid;
        this.isdel = isdel;
        this.createtime = createtime;
    }

    public Gdiecirelation() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsdetailsinfoid() {
        return goodsdetailsinfoid;
    }

    public void setGoodsdetailsinfoid(String goodsdetailsinfoid) {
        this.goodsdetailsinfoid = goodsdetailsinfoid == null ? null : goodsdetailsinfoid.trim();
    }

    public String getBaseelementid() {
        return baseelementid;
    }

    public void setBaseelementid(String baseelementid) {
        this.baseelementid = baseelementid == null ? null : baseelementid.trim();
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}