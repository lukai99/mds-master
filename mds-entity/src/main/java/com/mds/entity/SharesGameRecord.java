package com.mds.entity;

import com.mds.utils.PageBean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/2/22
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class SharesGameRecord extends PageBean<SharesGameRecord> {

    private String id;//数据主键

    private String gamecode;//游戏编号

    private String sharesid;//股票数据id

    private String frequency;//周期

    private Double initmoney;//初始资金

    private Double currentmoney;//当前资金

    private String userid;//用户数据id

    private String startrecordid;//开始股票数据id k线图第一根k线的记录

    private Long offsetnum;//偏移量

    private String gamestate;//游戏状态

    private Date createtime;//创建时间

    public SharesGameRecord(String id, String gamecode, String sharesid, String frequency, Double initmoney, Double currentmoney, String userid, String startrecordid, Long offsetnum, String gamestate, Date createtime) {
        this.id = id;
        this.gamecode = gamecode;
        this.sharesid = sharesid;
        this.frequency = frequency;
        this.initmoney = initmoney;
        this.currentmoney = currentmoney;
        this.userid = userid;
        this.startrecordid = startrecordid;
        this.offsetnum = offsetnum;
        this.gamestate = gamestate;
        this.createtime = createtime;
    }

    public SharesGameRecord() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGamecode() {
        return gamecode;
    }

    public void setGamecode(String gamecode) {
        this.gamecode = gamecode == null ? null : gamecode.trim();
    }

    public String getSharesid() {
        return sharesid;
    }

    public void setSharesid(String sharesid) {
        this.sharesid = sharesid == null ? null : sharesid.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public Double getInitmoney() {
        return initmoney;
    }

    public void setInitmoney(Double initmoney) {
        this.initmoney = initmoney;
    }

    public Double getCurrentmoney() {
        return currentmoney;
    }

    public void setCurrentmoney(Double currentmoney) {
        this.currentmoney = currentmoney ;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getStartrecordid() {
        return startrecordid;
    }

    public void setStartrecordid(String startrecordid) {
        this.startrecordid = startrecordid == null ? null : startrecordid.trim();
    }

    public Long getOffsetnum() {
        return offsetnum;
    }

    public void setOffsetnum(Long offsetnum) {
        this.offsetnum = offsetnum;
    }

    public String getGamestate() {
        return gamestate;
    }

    public void setGamestate(String gamestate) {
        this.gamestate = gamestate == null ? null : gamestate.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
