package com.mds.entity;

import com.mds.utils.PageBean;

import java.util.Date;

public class Goodsdetailsinfo extends PageBean {
    private String id;

    private String syscode;

    private Integer goodsinfoid;

    private Double grossweight;

    private String trait;

    private String cartype;

    private String brand;

    private String sougl;

    private String place;

    private String carriershape;

    private Double netweight;

    private String honeycombshape;

    private String isdel;

    private String remark;

    private Date createtime;

    private Date updatetime;

    public Goodsdetailsinfo(String id, String syscode, Integer goodsinfoid, Double grossweight, String trait, String cartype, String brand, String sougl, String place, String carriershape, Double netweight, String honeycombshape, String isdel, String remark, Date createtime, Date updatetime) {
        this.id = id;
        this.syscode = syscode;
        this.goodsinfoid = goodsinfoid;
        this.grossweight = grossweight;
        this.trait = trait;
        this.cartype = cartype;
        this.brand = brand;
        this.sougl = sougl;
        this.place = place;
        this.carriershape = carriershape;
        this.netweight = netweight;
        this.honeycombshape = honeycombshape;
        this.isdel = isdel;
        this.remark = remark;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Goodsdetailsinfo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSyscode() {
        return syscode;
    }

    public void setSyscode(String syscode) {
        this.syscode = syscode == null ? null : syscode.trim();
    }

    public Integer getGoodsinfoid() {
        return goodsinfoid;
    }

    public void setGoodsinfoid(Integer goodsinfoid) {
        this.goodsinfoid = goodsinfoid;
    }

    public Double getGrossweight() {
        return grossweight;
    }

    public void setGrossweight(Double grossweight) {
        this.grossweight = grossweight;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait == null ? null : trait.trim();
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getSougl() {
        return sougl;
    }

    public void setSougl(String sougl) {
        this.sougl = sougl == null ? null : sougl.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getCarriershape() {
        return carriershape;
    }

    public void setCarriershape(String carriershape) {
        this.carriershape = carriershape == null ? null : carriershape.trim();
    }

    public Double getNetweight() {
        return netweight;
    }

    public void setNetweight(Double netweight) {
        this.netweight = netweight;
    }

    public String getHoneycombshape() {
        return honeycombshape;
    }

    public void setHoneycombshape(String honeycombshape) {
        this.honeycombshape = honeycombshape == null ? null : honeycombshape.trim();
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
}