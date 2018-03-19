package com.mds.utils;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-12-27
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
public class UUIDUtils {
    /* 获取随机uuid */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}
