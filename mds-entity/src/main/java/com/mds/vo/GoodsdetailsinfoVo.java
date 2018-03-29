package com.mds.vo;

import com.mds.entity.Goodsdetailsinfo;

/**
 * Created by ASUS on 2018/3/27.
 */
public class GoodsdetailsinfoVo extends Goodsdetailsinfo{
    private String goodsname;

    private String[] elname;

    private String[] elcontent;

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
}
