package com.mds.entity;

import com.mds.utils.PageBean;

import java.util.Date;

public class Dictionary extends PageBean<Dictionary>{

    private String id;//数据id

    private String code;//编号

    private String name;//名称

    private String value;//值

    private String parentid;//父级数据id

    private String isdel;//是否删除状态 未删除：0 已删除：1

    private String state;//状态 禁用：0 启用： 1

    private Integer ordernum;//状态 禁用：0 启用： 1

    private String remark;//备注

    private Date createtime;//创建时间

    private Date updatetime;//修改时间

    //冗余字段

    public Dictionary(String id, String code, String name, String value, String parentid, String isdel, String state, Integer ordernum, String remark, Date createtime, Date updatetime) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.value = value;
        this.parentid = parentid;
        this.isdel = isdel;
        this.state = state;
        this.ordernum = ordernum;
        this.remark = remark;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Dictionary() {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

}