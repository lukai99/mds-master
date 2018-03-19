package com.mds.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/6
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 * 自定义注解，对service层进行日志记录
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String module()  default "";
    String option()  default "";
    String description()  default "";
}
