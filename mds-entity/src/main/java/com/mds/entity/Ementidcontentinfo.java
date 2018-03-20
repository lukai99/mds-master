package com.mds.entity;

import java.util.Date;

public class Ementidcontentinfo {
    private String id;

    private String baseelementid;

    private String content;

    private String isdel;

    private String remark;

    private Date createtime;

    private Date updatetime;

    public Ementidcontentinfo(String id, String baseelementid, String content, String isdel, String remark, Date createtime, Date updatetime) {
        this.id = id;
        this.baseelementid = baseelementid;
        this.content = content;
        this.isdel = isdel;
        this.remark = remark;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Ementidcontentinfo() {
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
}