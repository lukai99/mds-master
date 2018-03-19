package com.mds.controller;

import com.mds.entity.Menu;
import com.mds.entity.User;
import com.mds.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-8-10
 * Time: 下午6:03
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/main")
public class mainController {
    @Autowired
    private MenuService menuService;

    /**
     * 系统主页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/mainPage.htm")
    public String mainPage(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        model.addAttribute("user",user);
        return "systemMain";
    }
    @RequestMapping("getOneMenus.do")
    @ResponseBody
    public List<Menu> getOneMenus(Menu menu){
        List<Menu> list =  menuService.queryMenus(menu);
        return list;
    }
    @RequestMapping("getOnePageInfo.do")
    @ResponseBody
    public Map<String,Object> getOnePageInfo(String id){
        Map<String,Object> map =  menuService.getOnePageInfo(id);
        return map;
    }

    @RequestMapping("getChildMenus.do")
    @ResponseBody
    public List<Menu> getChildMenus(String parentId){
        List<Menu> list =  menuService.getChildMenus(parentId);
        return list;
    }
}
