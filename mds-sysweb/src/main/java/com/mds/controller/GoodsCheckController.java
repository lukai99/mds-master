package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.common.ResultVo;
import com.mds.entity.Ementidcontentinfo;
import com.mds.entity.Goodsdetailsinfo;
import com.mds.entity.Goodsinfo;
import com.mds.service.BaseElementService;
import com.mds.service.GoodsCheckService;
import com.mds.service.GoodsDetailService;
import com.mds.utils.PageBean;
import com.mds.vo.BaseElementVo;
import com.mds.vo.EmentidcontentinfoVo;
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
@RequestMapping("/goodsCheck")
public class GoodsCheckController {
    @Autowired
    GoodsDetailService detailService;
    @Autowired
    GoodsCheckService checkService;
    @Autowired
    private BaseElementService baseElementService;

    /* 物品信息管理 */
    @RequestMapping("/toGoodsCheckPage.do")
    public String toGoodsCheckPage(HttpServletRequest request, Model model){
        return "goodsCheck/goodsCheckManager";
    }

    @RequestMapping("/getGoodsCheckList.do")
    @ResponseBody
    public PageBean<GoodsdetailsinfoVo> getGoodsCheckList(GoodsdetailsinfoVo detailsinfoVo, PageBean pageBean,HttpServletRequest request, Model model){
        detailsinfoVo.setIscheck(1);
        PageBean<GoodsdetailsinfoVo> resultPageBean = detailService.queryGoodsDetail(detailsinfoVo,pageBean);
        return resultPageBean;
    }

    /* 添加物品检测信息页面 */
    @RequestMapping("/toOperatorGoodsCheckPage.do")
    public String addGoodsInfoPage(Goodsdetailsinfo detailsinfo, HttpServletRequest request, Model model){
        //物品信息详情下拉选项
        List<GoodsdetailsinfoVo> detaillist = detailService.getUnCheckList();
        model.addAttribute("detaillist",detaillist);
        //基本元素下拉选项
        ResultVo<BaseElementVo> baseElementVoResultVo = baseElementService.queryBaseElementInfo(new BaseElementVo());
        List<BaseElementVo> list = baseElementVoResultVo.getDataList();
        model.addAttribute("baseElementVoList",list);
        return "goodsCheck/operatorGoodsCheckInfo";
    }

    /* 修改物品检测信息页面 */
    @RequestMapping("/toUpdateGoodsCheckPage.do")
    public String updateGoodsInfoPage(Goodsdetailsinfo detailsinfo, HttpServletRequest request, Model model){
        //基本元素下拉选项
        ResultVo<BaseElementVo> baseElementVoResultVo = baseElementService.queryBaseElementInfo(new BaseElementVo());
        List<BaseElementVo> list = baseElementVoResultVo.getDataList();
        model.addAttribute("baseElementVoList",list);
        if(detailsinfo.getId() != null){
            ResultVo vo = detailService.queryGoodsDetail(detailsinfo.getId());
            Goodsdetailsinfo detailsinfoObj = (Goodsdetailsinfo)vo.getData();
            model.addAttribute("detailsinfoObj",detailsinfoObj);
            List<EmentidcontentinfoVo> checklist = checkService.getCheckInfoByDetailid(detailsinfo.getId());
            model.addAttribute("checklist",checklist);
        }
        return "goodsCheck/updateGoodsCheckInfo";
    }

    @RequestMapping("/operatorGoodsCheck.do")
    @SystemControllerLog(module = "mds",option = "增改物品检测详情",description = "增改物品检测详情")
    @ResponseBody
    public ResultVo operatorGoodsCheck(GoodsdetailsinfoVo detailsinfo){
        ResultVo vo =  checkService.saveGoodsCheck(detailsinfo);
        return vo;
    }

    /**
     * 检测详情查看
     * @param detailsinfo
     * @return
     */
    @RequestMapping("toLookGoodsCheckPage.do")
    public String toLookGoodsCheckPage(Goodsdetailsinfo detailsinfo,Model model){
        List<EmentidcontentinfoVo> checklist = checkService.getCheckInfoByDetailid(detailsinfo.getId());
        model.addAttribute("checklist",checklist);
        return "goodsCheck/lookGoodsCheckInfo";
    }
}
