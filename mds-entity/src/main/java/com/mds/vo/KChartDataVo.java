package com.mds.vo;

import com.mds.common.WebConstants;
import com.mds.entity.SharesHistoryData;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/2/19
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
public class KChartDataVo {

    private String sharesName;//股票名称
    private String sharesCode;//股票编号
    private int code;//请求的状态码 成功：200 失败：500
    private String msg;//提示信息
    private List<SharesHistoryData> dataList;//股票数据

    public KChartDataVo() {
        this.code = WebConstants.HTTPSTATE_SUCCESS;
        this.msg = WebConstants.HTTPSTATE_SUCCESS_MSG;
    }

    public KChartDataVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getSharesName() {
        return sharesName;
    }

    public void setSharesName(String sharesName) {
        this.sharesName = sharesName;
    }

    public String getSharesCode() {
        return sharesCode;
    }

    public void setSharesCode(String sharesCode) {
        this.sharesCode = sharesCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SharesHistoryData> getDataList() {
        return dataList;
    }

    public void setDataList(List<SharesHistoryData> dataList) {
        this.dataList = dataList;
    }
}
