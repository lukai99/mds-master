package com.mds.vo;

import com.mds.entity.Goodsdetailsinfo;

/**
 * Created by ASUS on 2018/3/27.
 */
public class GoodsdetailsinfoVo extends Goodsdetailsinfo{
    private String goodsname;

    private String[] elname;

    private String[] elcontent;

    private String[] realnames;

    private String[] uploadnames;

    private String[] dirname;

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String[] getElname() {
        return elname;
    }

    public String[] getElcontent() {
        return elcontent;
    }

    public void setElname(String[] elname) {
        this.elname = elname;
    }

    public void setElcontent(String[] elcontent) {
        this.elcontent = elcontent;
    }

    public String[] getRealnames() {

        return realnames;
    }

    public String[] getUploadnames() {
        return uploadnames;
    }

    public String[] getDirname() {
        return dirname;
    }

    public void setRealnames(String[] realnames) {
        this.realnames = realnames;
    }

    public void setUploadnames(String[] uploadnames) {
        this.uploadnames = uploadnames;
    }

    public void setDirname(String[] dirname) {
        this.dirname = dirname;
    }

}
