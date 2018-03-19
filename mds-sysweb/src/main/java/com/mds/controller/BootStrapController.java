package com.mds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-24
 * Time: 上午7:04
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("bootStrap")
public class BootStrapController {

    @RequestMapping("toBootStrapMainPage.htm")
    public String  toBootStrapMainPage(){
        return "bootstrap/bootStrapMain";
    }

    @RequestMapping("grid.htm")
    public String grid(){
        return "bootstrap/gridStudy";
    }
    //排版
    @RequestMapping("composing.htm")
    public String composing(){
        return "bootstrap/composingStudy";
    }
    //代码
    @RequestMapping("code.htm")
    public String code(){
        return "bootstrap/codeStudy";
    }
    //表格
    @RequestMapping("table.htm")
    public String table(){
        return "bootstrap/tableStudy";
    }
    //导航栏
    @RequestMapping("navBar.htm")
    public String navBar(){
        return "bootstrap/navBarStudy";
    }
}
