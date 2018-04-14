package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.common.ResultVo;
import com.mds.entity.Goodsdetailsinfo;
import com.mds.entity.Goodsinfo;
import com.mds.service.GoodsDetailService;
import com.mds.service.GoodsInfoService;
import com.mds.utils.PageBean;
import com.mds.utils.PropertiesUtil;
import com.mds.vo.GoodsInfoVo;
import com.mds.vo.GoodsdetailsinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ASUS on 2018/3/22.
 */
@Controller
@RequestMapping("/goodsDetail")
public class GoodsInfoQueryController {

    @Autowired
    GoodsDetailService detailService;
    @Autowired
    GoodsInfoService goodsInfoService;

    /* 物品查询页面 */
    @RequestMapping("/toGoodsInfoQueryPage.do")
    public String toGoodsInfoQueryPage(HttpServletRequest request,Model model){
        String path = PropertiesUtil.getUploadPath();
        model.addAttribute("path",path);
        return "goodsDetail/goodsDetailQuery";
    }

    /* 获取物品信息列表 */
    @RequestMapping("getGoodsInfoListForQuery.do")
    @ResponseBody
    public PageBean<GoodsdetailsinfoVo> getGoodsDetailList(GoodsdetailsinfoVo detailsinfoVo, PageBean pageBean, HttpServletRequest request, Model model){
        PageBean<GoodsdetailsinfoVo> resultPageBean = detailService.queryGoodsDetail(detailsinfoVo,pageBean);
        return resultPageBean;
    }

    /* 添加物品信息页面 */
    @RequestMapping("/toGoodsInfoDetailsShowPage.do")
    public String toGoodsInfoDetailsShowPage(Goodsdetailsinfo detailsinfo, HttpServletRequest request, Model model){
        List<Goodsinfo> goodslist = goodsInfoService.getGoodsList();
        model.addAttribute("goodslist",goodslist);
        if(detailsinfo.getId() != null){
            ResultVo vo = detailService.queryGoodsDetailForPrice(detailsinfo.getId());
            GoodsdetailsinfoVo detailsinfoObj = (GoodsdetailsinfoVo)vo.getData();
            model.addAttribute("detailsinfoObj",detailsinfoObj);
        }
        return "goodsDetail/goodsDetailForShow";
    }
}
