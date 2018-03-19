package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.entity.Dictionary;
import com.mds.entity.Menu;
import com.mds.service.DictionaryService;
import com.mds.service.MenuService;
import com.mds.utils.PageBean;
import com.mds.common.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-12-14
 * Time: 下午9:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    /* 数据字典管理 */
    @RequestMapping("/toDictionaryManagerPage.do")
    public String toDictionaryManagerPage(HttpServletRequest request,Model model){
        return "other/dictionaryManager/dictionaryManager";
    }
    /* 获取字典项列表 */
    @RequestMapping("getDictionarysList.do")
    @ResponseBody
    public PageBean<Dictionary> getDictionarysList(Dictionary dictionary, PageBean pageBean, HttpServletRequest request, Model model){
        PageBean<Dictionary> resultPageBean = dictionaryService.queryDictionary(dictionary,pageBean);
        return resultPageBean;
    }
    /* 添加字典项页面 */
    @RequestMapping("/toOperatorDictionaryPage.do")
    public String addDictionaryPage(Dictionary dictionary,HttpServletRequest request,Model model){
        if(dictionary.getId() != null){
            ResultVo vo = dictionaryService.getDictionary(dictionary.getId());
            Dictionary dictionaryObj = (Dictionary)vo.getData();
            model.addAttribute("dictionary",dictionaryObj);
        }
        return "other/dictionaryManager/operatorDictionary";
    }
    /* 增改操作数据 */
    @RequestMapping("operatorDictionary.do")
    @SystemControllerLog(module = "mds",option = "增改字典项",description = "增改字典项")
    @ResponseBody
    public ResultVo operatorDictionary(Dictionary dictionary,PageBean pageBean,HttpServletRequest request,Model model){
        ResultVo vo =  null;
        //id为空的话 为添加菜单的操作 不为空的话为修改的操作
        if(dictionary.getId()!=null&&!"".equals(dictionary.getId())){
            vo = dictionaryService.updateDictionary(dictionary);
        }else{
            vo = dictionaryService.addDictionary(dictionary);
        }
        return vo;
    }
    /* 删除数据数据 */
    @RequestMapping("toDeleteDictionaryPage.do")
    @SystemControllerLog(module = "mds",option = "删除字典项",description = "删除字典项")
    @ResponseBody
    public ResultVo deleteDictionary(String[] dictionaryIds,PageBean pageBean,HttpServletRequest request,Model model){
        ResultVo vo =  null;
        vo = dictionaryService.deleteDictionaryByUpdate(dictionaryIds);
        return vo;
    }
}
