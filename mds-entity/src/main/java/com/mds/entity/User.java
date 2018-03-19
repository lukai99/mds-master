package com.mds.entity;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-16
 * Time: 下午6:25
 * To change this template use File | Settings | File Templates.
 */
public class User extends BaseEntity{
    private String id;
    private String userName;    //用户名
    private String password;    //密码
    private String netName;     //昵称
    private String state;       //状态 1：启用 0：未启用



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNetName() {
        return netName;
    }

    public void setNetName(String netName) {
        this.netName = netName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
