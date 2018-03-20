package com.mds.entity;

import java.util.Date;

public class User {
    private String id;

    private String username;

    private String password;

    private String netname;

    private String remark;

    private String state;

    private Date createtime;

    private Date updatetime;

    public User(String id, String username, String password, String netname, String remark, String state, Date createtime, Date updatetime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.netname = netname;
        this.remark = remark;
        this.state = state;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNetname() {
        return netname;
    }

    public void setNetname(String netname) {
        this.netname = netname == null ? null : netname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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