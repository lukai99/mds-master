package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.entity.Menu;
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
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /* 初始化主页菜单 */
    @RequestMapping("getInitMenusData.do")
    @ResponseBody
    public ResultVo<Menu> getInitMenusData(HttpServletRequest request,Model model){
        String userId = "1";
        ResultVo<Menu> resultVo =  menuService.getInitMenusData(userId);
        return resultVo;
    }
    /* 菜单管理 */
    @RequestMapping("/menuManagerList.do")
    public String mainPage(HttpServletRequest request,Model model){
        return "other/menuManager/menuManager";
    }
    /* 获取菜单列表 */
    @RequestMapping("getMenusList.do")
    @SystemControllerLog(module = "mds",option = "查询菜单列表",description = "分页查询菜单列表")
    @ResponseBody
    public PageBean<Menu> getMenusList(Menu menu,PageBean pageBean,HttpServletRequest request,Model model){
        PageBean<Menu> resultPageBean = menuService.queryMenus(menu,pageBean);
        return resultPageBean;
    }
    /* 添加菜单 */
    @RequestMapping("/operatorMenuPage.do")
    public String addMenuPage(Menu menu,HttpServletRequest request,Model model){
        if(menu.getId() != null){
            menu = menuService.getMenuInfo(menu.getId());
            model.addAttribute("menu",menu);
        }
        return "other/menuManager/operatorMenu";
    }
    /* 增改操作数据 */
    @RequestMapping("operatorMenus.do")
    @SystemControllerLog(module = "mds",option = "增改菜单",description = "增改菜单")
    @ResponseBody
    public ResultVo operatorMenus(Menu menu,PageBean pageBean,HttpServletRequest request,Model model){
        ResultVo vo =  null;
        //id为空的话 为添加菜单的操作 不为空的话为修改的操作
        if(menu.getId()!=null&&!"".equals(menu.getId())){
            vo = menuService.updateMenu(menu);
        }else{
            vo = menuService.addMenu(menu);
        }
        return vo;
    }
    /* 删除数据数据 */
    @RequestMapping("deleteMenuPage.do")
    @SystemControllerLog(module = "mds",option = "删除菜单",description = "删除菜单")
    @ResponseBody
    public ResultVo deleteMenus(String[] menuIds,PageBean pageBean,HttpServletRequest request,Model model){
        ResultVo vo =  null;
        vo = menuService.deleteMenuByUpdate(menuIds);
        return vo;
    }

    /* 事物测试 */
    @RequestMapping("testTransMenuPage.do")
    @ResponseBody
    public ResultVo testTransMenuPage(PageBean pageBean,HttpServletRequest request,Model model){
        ResultVo vo =  null;
        vo = menuService.testTransMenuPage();
        return vo;
    }
}
