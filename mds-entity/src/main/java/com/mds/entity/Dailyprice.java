package com.mds.entity;

import java.util.Date;

public class Dailyprice {
    private String id;

    private String code;

    private Double dailyprice;

    private Date inputtime;

    private String isdel;

    private String remark;

    private Date createtime;

    private Date updatetime;

    public Dailyprice(String id, String code, Double dailyprice, Date inputtime, String isdel, String remark, Date createtime, Date updatetime) {
        this.id = id;
        this.code = code;
        this.dailyprice = dailyprice;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
}