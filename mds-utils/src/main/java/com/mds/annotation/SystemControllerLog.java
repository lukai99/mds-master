package com.mds.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/6
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 * 自定义注解，对controller层进行日志记录
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
    String module()  default "";
    String option()  default "";
    String description()  default "";
}
