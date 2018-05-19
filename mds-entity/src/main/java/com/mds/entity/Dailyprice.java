package com.mds.entity;

import com.mds.utils.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Dailyprice  extends PageBean {
    private String id;

    private String baseelementid;

    private Double dailyprice;

    private Double ba_dailyprice;

    private Double lao_dailyprice;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inputtime;

    private String isdel;

    private String remark;

    private Date createtime;

    private Date updatetime;

    public Dailyprice(String id, String baseelementid, Double dailyprice,Double ba_dailyprice,Double lao_dailyprice, Date inputtime, String isdel, String remark, Date createtime, Date updatetime) {
        this.id = id;
        this.baseelementid = baseelementid;
        this.dailyprice = dailyprice;
        this.ba_dailyprice = ba_dailyprice;
        this.lao_dailyprice = lao_dailyprice;
        this.inputtime = inputtime;
        this.isdel = isdel;
        this.remark = remark;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Dailyprice() {
        super();
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

    public Double getDailyprice() {
        return dailyprice;
    }

    public void setDailyprice(Double dailyprice) {
        this.dailyprice = dailyprice;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
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

    public Double getBa_dailyprice() {
        return ba_dailyprice;
    }

    public Double getLao_dailyprice() {
        return lao_dailyprice;
    }

    public void setBa_dailyprice(Double ba_dailyprice) {
        this.ba_dailyprice = ba_dailyprice;
    }

    public void setLao_dailyprice(Double lao_dailyprice) {
        this.lao_dailyprice = lao_dailyprice;
    }
}