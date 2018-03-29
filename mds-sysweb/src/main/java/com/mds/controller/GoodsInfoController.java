package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.common.ResultVo;
import com.mds.entity.Goodsinfo;
import com.mds.service.GoodsInfoService;
import com.mds.utils.PageBean;
import com.mds.vo.GoodsInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 2018/3/22.
 */
@Controller
@RequestMapping("/goodsinfo")
public class GoodsInfoController {
    @Autowired
    GoodsInfoService goodsInfoService;

    /* 物品信息管理 */
    @RequestMapping("/toGoodsInfoManagerPage.do")
    public String toGoodsInfoManagerPage(HttpServletRequest request,Model model){
        return "goodsInfo/goodsInfoManager";
    }

    /* 获取物品信息列表 */
    @RequestMapping("getGoodsInfoList.do")
    @ResponseBody
    public PageBean<GoodsInfoVo> getGoodsInfoList(GoodsInfoVo goodsInfoVo, PageBean pageBean, HttpServletRequest request, Model model){
        PageBean<GoodsInfoVo> resultPageBean = goodsInfoService.queryGoodsInfo(goodsInfoVo,pageBean);
        return resultPageBean;
    }

    /* 添加物品信息页面 */
    @RequestMapping("/toOperatorGoodsInfoPage.do")
    public String addGoodsInfoPage(Goodsinfo goodsinfo, HttpServletRequest request, Model model){
        if(goodsinfo.getId() != null){
            ResultVo vo = goodsInfoService.queryGoodsInfo(goodsinfo.getId());
            Goodsinfo goodsinfoObj = (Goodsinfo)vo.getData();
            model.addAttribute("goodsinfo",goodsinfoObj);
        }
        return "goodsInfo/operatorGoodsInfo";
    }

    /* 增改操作数据 */
    @RequestMapping("operatorGoodsInfo.do")
    @SystemControllerLog(module = "mds",option = "增改物品",description = "增改物品")
    @ResponseBody
    public ResultVo operatorGoodsInfo(Goodsinfo goodsinfo, PageBean pageBean, HttpServletRequest request, Model model){
        ResultVo vo =  null;
        //id为空的话 为添加菜单的操作 不为空的话为修改的操作
        if(goodsinfo.getId()!=null&&!"".equals(goodsinfo.getId())){
            vo = goodsInfoService.updateGoodsInfo(goodsinfo);
        }else{
            vo = goodsInfoService.saveGoodsInfo(goodsinfo);
        }
        return vo;
    }

    /* 删除数据数据 */
    @RequestMapping("toDeleteGoodsInfoPage.do")
    @SystemControllerLog(module = "mds",option = "删除物品信息",description = "删除物品信息")
    @ResponseBody
    public ResultVo deleteGoodsInfo(String[] ids,PageBean pageBean,HttpServletRequest request,Model model){
        ResultVo vo =  null;
        vo = goodsInfoService.deleteGoodsInfoForUpdate(ids);
        return vo;
    }
}
