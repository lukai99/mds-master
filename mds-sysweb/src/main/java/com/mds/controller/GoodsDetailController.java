package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.common.ResultVo;
import com.mds.entity.Goodsdetailsinfo;
import com.mds.entity.Goodsinfo;
import com.mds.service.GoodsDetailService;
import com.mds.service.GoodsInfoService;
import com.mds.utils.PageBean;
import com.mds.vo.GoodsdetailsinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ASUS on 2018/3/27.
 */
@Controller
@RequestMapping("/goodsDetail")
public class GoodsDetailController {

    @Autowired
    GoodsDetailService detailService;
    @Autowired
    GoodsInfoService goodsInfoService;

    /* 物品信息管理 */
    @RequestMapping("/toGoodsDetailPage.do")
    public String toGoodsInfoManagerPage(HttpServletRequest request, Model model){
        return "goodsDetail/goodsDetailManager";
    }
    /* 获取物品信息列表 */
    @RequestMapping("getGoodsDetailList.do")
    @ResponseBody
    public PageBean<GoodsdetailsinfoVo> getGoodsDetailList(GoodsdetailsinfoVo detailsinfoVo, PageBean pageBean, HttpServletRequest request, Model model){
        PageBean<GoodsdetailsinfoVo> resultPageBean = detailService.queryGoodsDetail(detailsinfoVo,pageBean);
        return resultPageBean;
    }

    /* 添加物品信息页面 */
    @RequestMapping("/toOperatorGoodsDetailPage.do")
    public String addGoodsInfoPage(Goodsdetailsinfo detailsinfo, HttpServletRequest request, Model model){
        List<Goodsinfo> goodslist = goodsInfoService.getGoodsList();
        model.addAttribute("goodslist",goodslist);
        if(detailsinfo.getId() != null){
            ResultVo vo = detailService.queryGoodsDetail(detailsinfo.getId());
            Goodsdetailsinfo detailsinfoObj = (Goodsdetailsinfo)vo.getData();
            model.addAttribute("detailsinfoObj",detailsinfoObj);
        }
        return "goodsDetail/operatorGoodsDetailsInfo";
    }

    /* 增改操作数据 */
    @RequestMapping("operatorGoodsDetail.do")
    @SystemControllerLog(module = "mds",option = "增改物品信息详情",description = "增改物品信息详情")
    @ResponseBody
    public ResultVo operatorGoodsDetail(Goodsdetailsinfo detailsinfo, PageBean pageBean, HttpServletRequest request, Model model){
        ResultVo vo =  null;
        //id为空的话 为添加菜单的操作 不为空的话为修改的操作
        if(detailsinfo.getId()!=null&&!"".equals(detailsinfo.getId())){
            vo = detailService.updateGoodsDetail(detailsinfo);
        }else{
            vo = detailService.saveGoodsDetail(detailsinfo);
        }
        return vo;
    }

    /* 删除数据数据 */
    @RequestMapping("toDeleteGoodsDetailPage.do")
    @SystemControllerLog(module = "mds",option = "删除物品信息详情",description = "删除物品信息详情")
    @ResponseBody
    public ResultVo deleteGoodsInfo(String[] ids,PageBean pageBean,HttpServletRequest request,Model model){
        ResultVo vo =  null;
        vo = detailService.deleteGoodsDetailForUpdate(ids);
        return vo;
    }
}
