package com.mds.entity;

import java.util.Date;

public class Fileinfo {
    private String id;

    private String detailinfo;

    private String realname;

    private String uploadname;

    private String dir;

    private String isdel;

    private Date createtime;

    private Date updatetime;

    public Fileinfo(String id, String detailinfo, String realname, String uploadname, String dir, String isdel, Date createtime, Date updatetime) {
        this.id = id;
        this.detailinfo = detailinfo;
        this.realname = realname;
        this.uploadname = uploadname;
        this.dir = dir;
        this.isdel = isdel;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Fileinfo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDetailinfo() {
        return detailinfo;
    }

    public void setDetailinfo(String detailinfo) {
        this.detailinfo = detailinfo == null ? null : detailinfo.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getUploadname() {
        return uploadname;
    }

    public void setUploadname(String uploadname) {
        this.uploadname = uploadname == null ? null : uploadname.trim();
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir == null ? null : dir.trim();
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}