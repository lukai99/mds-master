package com.mds.entity;

import com.mds.utils.PageBean;

import java.util.Date;

public class Userrolerelation extends PageBean {
    private String id;

    private String userid;

    private String roleid;

    private String isdel;

    private Date createtime;

    public Userrolerelation(String id, String userid, String roleid, String isdel, Date createtime) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
        this.isdel = isdel;
        this.createtime = createtime;
    }

    public Userrolerelation() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
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