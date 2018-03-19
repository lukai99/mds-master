package com.mds.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-17
 * Time: 下午6:05
 * To change this template use File | Settings | File Templates.
 */
public class MD5Utils {

    /**利用MD5进行加密
 　　* @param str  待加密的字符串
 　　* @return  加密后的字符串
 　　* @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
 　　* @throws UnsupportedEncodingException
 　　*/
    public static String getMD5Str(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }
}
