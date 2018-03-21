package com.mds.controller;


import com.mds.annotation.SystemControllerLog;
import com.mds.common.WebConstants;
import com.mds.entity.Menu;
import com.mds.entity.User;
import com.mds.service.LoginService;
import com.mds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-12
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 跳转登录界面
     * @return
     */
    @RequestMapping("/toLoginPage.htm")
    public String toLoginPage(){
        return "login";
    }
    /**
     * 登录系统
     * @param request
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/userLogin.htm")
    @SystemControllerLog(module = "mds",option="登录系统",description ="用户登录操作")
    public String userLogin(HttpServletRequest request,Model model,User user){
        System.out.println("username:" + user.getUsername() + ",password:" + user.getPassword());
        if(loginService.userLogin(user)) {
            HttpSession session = request.getSession();
            session.setAttribute(WebConstants.CURRENT_USER,user);
            return "redirect:/main/mainPage.htm";
        }else{
            model.addAttribute("message","用户名或密码错误");
            return "login";
        }
    }
    @RequestMapping("/mainPage.htm")
    public String mainPage(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        model.addAttribute("user",user);
        return "main";
    }
    @RequestMapping("/mainPage_bak.htm")
    public String mainBakPage(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        model.addAttribute("user",user);
        return "main_bak";
    }
    @RequestMapping("test.do")
    @ResponseBody
    public Menu test(HttpServletRequest request, HttpServletResponse response){
        Menu menu =  new Menu();
        menu.setLevel(1);
        menu.setName("test");
        System.out.print("123");
        return menu;
    }
}
