package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.common.ResultVo;
import com.mds.entity.Baseelement;
import com.mds.entity.Dailyprice;
import com.mds.entity.Dictionary;
import com.mds.service.BaseElementService;
import com.mds.service.DailypriceService;
import com.mds.utils.PageBean;
import com.mds.vo.BaseElementVo;
import com.mds.vo.DailypriceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/3/21
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequestMapping("dailyPrice")
public class DailypriceController {

    @Autowired
    private DailypriceService dailypriceService;
    @Autowired
    private BaseElementService baseElementService;

    /**
     * 跳转每日价格管理页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toDailyPriceManagerPage.do")
    public String toDailyPriceManagerPage(HttpServletRequest request, Model model){
        model.addAttribute("","");
        return "dailypriceManager/dailypriceManager";
    }

    /**
     * 每日价格列表查询
     * 分页模式
     * @param dailyPriceVo
     * @param pageBean
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("getDailyPriceList.do")
    @ResponseBody
    public PageBean<DailypriceVo> getDictionarysList(DailypriceVo dailyPriceVo, PageBean pageBean, HttpServletRequest request, Model model){
        PageBean<DailypriceVo> resultPageBean = dailypriceService.queryDailyprice(dailyPriceVo,pageBean);
        return resultPageBean;
    }

    /**
     * 跳转新增每日价格页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toOperatorDailyPricerPage.do")
    public String toOperatorDailyPricerPage(Dailyprice dailyprice,HttpServletRequest request, Model model){
        if(dailyprice.getId() != null){
            ResultVo vo = dailypriceService.queryDailyprice(dailyprice.getId());
            Dailyprice dailypriceObj = (Dailyprice)vo.getData();
            model.addAttribute("dailyPrice",dailypriceObj);
        }
        //基本元素下拉选项
        ResultVo<BaseElementVo> baseElementVoResultVo = baseElementService.queryBaseElementInfo(new BaseElementVo());
        List<BaseElementVo> list = baseElementVoResultVo.getDataList();
        model.addAttribute("baseElementVoList",list);
        return "dailypriceManager/operatorDailyprice";
    }
    //operatorDailyPrice.do
    /* 增改操作数据 */
    @RequestMapping("operatorDailyPrice.do")
    @SystemControllerLog(module = "mds",option = "增改每日价格",description = "增改每日价格")
    @ResponseBody
    public ResultVo operatorDictionary(Dailyprice dailyprice, PageBean pageBean, HttpServletRequest request, Model model){
        ResultVo vo =  null;
        //id为空的话 为添加菜单的操作 不为空的话为修改的操作
        if(dailyprice.getId()!=null&&!"".equals(dailyprice.getId())){
            vo = dailypriceService.updateDailyprice(dailyprice);
        }else{
            vo = dailypriceService.saveDailyprice(dailyprice);
        }
        return vo;
    }
    /* 删除数据数据 */
    @RequestMapping("deleteDailyPrice.do")
    @SystemControllerLog(module = "mds",option = "删除每日价格",description = "删除每日价格")
    @ResponseBody
    public ResultVo deleteDictionary(String[] dictionaryIds,HttpServletRequest request,Model model){
        ResultVo vo =  null;
        vo = dailypriceService.deleteDailypriceForUpdate(dictionaryIds);
        return vo;
    }


}
