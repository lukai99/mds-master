package com.mds.entity;

import com.mds.utils.PageBean;

import java.util.Date;

public class Ementidcontentinfo extends PageBean {
    private String id;

    private String baseelementid;

    private String goodsdetailid;

    private String content;

    private Double dailyprice;

    private Double zkrate;

    private Double realprice;

    private Double reprice;

    private String isdel;

    private String remark;

    private Date createtime;

    private Date updatetime;

    private Integer sort;

    public Ementidcontentinfo() {
        super();
    }

    public Ementidcontentinfo(String id, String baseelementid, String goodsdetailid, String content, Double dailyprice, Double zkrate, Double realprice, Double reprice, String isdel, String remark, Date createtime, Date updatetime, Integer sort) {
        this.id = id;
        this.baseelementid = baseelementid;
        this.goodsdetailid = goodsdetailid;
        this.content = content;
        this.dailyprice = dailyprice;
        this.zkrate = zkrate;
        this.realprice = realprice;
        this.reprice = reprice;
        this.isdel = isdel;
        this.remark = remark;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBaseelementid() {
        return baseelementid;
    }

    public void setBaseelementid(String baseelementid) {
        this.baseelementid = baseelementid == null ? null : baseelementid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getGoodsdetailid() {
        return goodsdetailid;
    }

    public void setGoodsdetailid(String goodsdetailid) {
        this.goodsdetailid = goodsdetailid;
    }

    public Double getDailyprice() {
        return dailyprice;
    }

    public Double getZkrate() {
        return zkrate;
    }

    public Double getRealprice() {
        return realprice;
    }

    public Double getReprice() {
        return reprice;
    }

    public void setDailyprice(Double dailyprice) {
        this.dailyprice = dailyprice;
    }

    public void setZkrate(Double zkrate) {
        this.zkrate = zkrate;
    }

    public void setRealprice(Double realprice) {
        this.realprice = realprice;
    }

    public void setReprice(Double reprice) {
        this.reprice = reprice;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}