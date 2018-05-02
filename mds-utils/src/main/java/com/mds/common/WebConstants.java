package com.mds.common;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/7
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class WebConstants {

    public static final String CURRENT_USER = "user";//当前session用户

    public static final int HTTPSTATE_SUCCESS = 200;//请求成功
    public static final int HTTPSTATE_ERROR = 500;//请求失败
    public static final String HTTPSTATE_SUCCESS_MSG = "请求成功";//请求成功的提示信息
    public static final String HTTPSTATE_ERROR_MSG = "请求失败";//请求失败的提示信息

    public static final String YES = "1";//是
    public static final String NO = "0";//否

    public static final int layuiRequestCode = 0;//layui数据表格发送请求成功的返回状态码 要与页面端设置的一致

    public static final class GP{
        public static final String DOING = "1";//进行中
        public static final String DOED = "0";//已结束

        public static final int DATALENGTH = 30;//查询数据长度
    }

    public static final int MENU_LEVEL_P = 1; //父级菜单等级
}
