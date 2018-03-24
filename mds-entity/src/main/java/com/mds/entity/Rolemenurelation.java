package com.mds.entity;

import com.mds.utils.PageBean;

import java.util.Date;

public class Rolemenurelation extends PageBean {
    private String id;

    private String roleid;

    private String menuid;

    private String isdel;

    private Date createtime;

    public Rolemenurelation(String id, String roleid, String menuid, String isdel, Date createtime) {
        this.id = id;
        this.roleid = roleid;
        this.menuid = menuid;
        this.isdel = isdel;
        this.createtime = createtime;
    }

    public Rolemenurelation() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
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