package com.mds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-21
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/userManager")
public class UserController {

    @RequestMapping("toUserManagerPage.htm")
    public String toUserManagerPage(Model model){

        return "/userManager/userList";
    }
}
