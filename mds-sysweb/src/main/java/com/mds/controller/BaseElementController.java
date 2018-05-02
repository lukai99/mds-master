package com.mds.controller;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.entity.Baseelement;
import com.mds.service.BaseElementService;
import com.mds.utils.PageBean;
import com.mds.vo.BaseElementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/baseelement/")
public class BaseElementController {

    @Autowired
    private BaseElementService baseElementService;

    @RequestMapping("toBaseElementManagerPage.do")
    public String baseElementManagerPage(HttpServletRequest request,Model model){
        return "baseelement/baseElementManager";
    }

    @RequestMapping("toBaseElementList.do")
    @ResponseBody
    public PageBean<BaseElementVo> toBaseElementList(BaseElementVo baseElementVo, HttpServletRequest request, PageBean pageBean){
        PageBean<BaseElementVo> pageBeanResult = baseElementService.queryBaseElementInfo(baseElementVo,pageBean);
        return pageBeanResult;
    }

    @RequestMapping("toAddBaseElement.do")
    public String toAddBaseElement(Baseelement baseelement,HttpServletRequest request,Model model){
        try{
            if(baseelement.getId()!=null){
                ResultVo vo = baseElementService.queryBaseElementInfo(baseelement.getId());
                Baseelement bl = (Baseelement) vo.getData();
                model.addAttribute("bl",bl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "baseelement/toAddBaseElement";
    }

    @RequestMapping("addBaseElement.do")
    @SystemServiceLog(module = "mds",option = "增改物品",description = "增改物品")
    @ResponseBody
    public ResultVo addBaseElement(Baseelement baseelement){
        ResultVo vo = null;
        if(baseelement.getId() != null && !"".equals(baseelement.getId())){
            vo = baseElementService.updateBaseElement(baseelement);
        }else{
            vo = baseElementService.addBaseElement(baseelement);
        }
        return vo;
    }

    @RequestMapping("toDeleteBaseElement.do")
    @SystemServiceLog(module = "mds",option = "删除物品",description = "删除物品")
    @ResponseBody
    public ResultVo toDeleteBaseElement(String[] ids){
        ResultVo vo = baseElementService.deleteForBaseElement(ids);
        return vo;
    }
}
