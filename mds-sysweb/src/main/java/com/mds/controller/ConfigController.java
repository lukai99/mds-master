package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.common.ResultVo;
import com.mds.entity.Config;
import com.mds.service.ConfigService;
import com.mds.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/3/28
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("sys")
public class ConfigController {

    @Autowired
    public ConfigService configService;

    @RequestMapping("toSysconfigPage.do")
    public String toSysconfigPage(HttpServletRequest request, Model model){
        List<Map<String,String>> list = new ArrayList<Map<String,String>>(100);
        for(int i=0;i<100;i++){
            Map<String,String> map =new HashMap<String,String>();
            map.put("val",i+"");
            list.add(map);
        }
        model.addAttribute("discountList",list);
        ResultVo<Config> resultVo = configService.queryConfigInfo(new Config());
        model.addAttribute("config",resultVo.getData());
        return "sysconfig/operatorSysconfig";
    }

    @RequestMapping("saveSysconfig.do")
    @SystemControllerLog(module = "mds",option = "增改系统配置",description = "增改系统配置")
    @ResponseBody
    public ResultVo saveSysconfig(Config config, HttpServletRequest request, Model model){
        ResultVo vo =  null;
        //id为空的话 为添加操作 不为空的话为修改的操作
        if(config.getId()!=null&&!"".equals(config.getId())){
            vo = configService.updateConfig(config);
        }else{
            vo = configService.addConfig(config);
        }
        return vo;
    }

}
