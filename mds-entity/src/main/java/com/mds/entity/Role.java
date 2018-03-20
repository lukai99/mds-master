package com.mds.entity;

import java.util.Date;

public class Role {
    private String id;

    private String rolename;

    private String rolecode;

    private String state;

    private String isdel;

    private String remark;

    private Date createtime;

    private Date updatetime;

    public Role(String id, String rolename, String rolecode, String state, String isdel, String remark, Date createtime, Date updatetime) {
        this.id = id;
        this.rolename = rolename;
        this.rolecode = rolecode;
        this.state = state;
        this.isdel = isdel;
        this.remark = remark;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Role() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
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