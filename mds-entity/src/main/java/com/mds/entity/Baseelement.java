package com.mds.entity;

import java.util.Date;

public class Baseelement {
    private String id;

    private String code;

    private String name;

    private String state;

    private String isdel;

    private String remark;

    private Date createtime;

    private Date updatetime;

    public Baseelement(String id, String code, String name, String state, String isdel, String remark, Date createtime, Date updatetime) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.state = state;
        this.isdel = isdel;
        this.remark = remark;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Baseelement() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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