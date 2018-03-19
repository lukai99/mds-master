package com.mds.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-17
 * Time: 下午4:59
 * To change this template use File | Settings | File Templates.
 */
public class BaseEntity {
    private Date createTime;   //创建时间
    private Date updateTime;   //修改时间
    private String remark;     //备注

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
