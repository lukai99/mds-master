package com.mds.entity;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-17
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
public class UserGroup extends BaseEntity{
    private Long id;
    private String groupCode;   //组编号
    private String groupName;   //组名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
