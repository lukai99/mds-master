package com.mds.common;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-21
 * Time: 下午9:29
 * To change this template use File | Settings | File Templates.
 */
public class ResultVo<T> {

    public static String SUCCESS = "200";
    public static String FAILED = "500";
    public static String SUCCESS_MESSAGE = "操作成功";
    public static String FAILED_MESSAGE = "操作失败";

    private String state;    //状态
    private String message;  //信息
    private List<T> dataList;//集合数据
    private Object data;//单条数据

    public ResultVo(){
        this.state = ResultVo.FAILED;
        this.message = ResultVo.FAILED_MESSAGE;
    }

    public ResultVo(String state,String message) {
        this.state = state;
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
