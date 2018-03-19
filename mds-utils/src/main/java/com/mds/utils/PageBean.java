package com.mds.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-12-10
 * Time: 下午7:48
 * To change this template use File | Settings | File Templates.
 */
public class PageBean<T> {
    public int page = 1;//页码
    public int limit = 10;//一页多少条
    /** 行实体类 */
    private List<T> rows = new ArrayList<T>();
    private List<T> data = new ArrayList<T>();
    /** 总条数 */
    private int total;
    /** 总条数 */
    private int count;


    private int resultCode;//結果状态码

    private String msg;

    public PageBean() {
        super();
    }

    /**
     * 获得开始行号
     * @return
     */
    public int getStartRowNum(){
         return (page-1) * limit;
    }

    /**
     * 获得结束行号
     * @return
     */
    public int getEndRowNum(){
        return limit;
    }

    public List<T> getRows() {
        return rows;
    }

    public List<T> getData() {
        return data;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
        this.data = rows;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.count = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
