package com.mds.controller;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.entity.User;
import com.mds.service.RoleService;
import com.mds.service.UserService;
import com.mds.utils.PageBean;
import com.mds.vo.RoleVo;
import com.mds.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-21
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/userManager/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("toUserManagerPage.do")
    public String toUserManagerPage(){
        return "userManager/userList";
    }

    @RequestMapping("toUserManagerList.do")
    @ResponseBody
    public PageBean<UserVo> toUserManagerList(UserVo userVo,PageBean pageBean){
        PageBean<UserVo> pageBeanResult = userService.queryUserInfo(userVo,pageBean);
        return pageBeanResult;
    }

    @RequestMapping("toAddUser.do")
    public String toAddUser(User user,Model model){
        if(user.getId() != null){
            ResultVo resultVo = userService.queryUser(user.getId());
            User ul = (User) resultVo.getData();
            model.addAttribute("ul",ul);
        }
        List<RoleVo> roleVoList = roleService.queryAllRoles().getDataList();
        model.addAttribute("roleVoList",roleVoList);
        return "userManager/toAddUser";
    }

    @RequestMapping("addUser.do")
    @SystemServiceLog(module = "mds",option = "增加用户",description = "增加用户")
    @ResponseBody
    public ResultVo addUser(User user){
        ResultVo vo = null;
        if(user.getId() != null && !"".equals(user.getId())){
            vo = userService.updateUser(user);
        }else{
            vo = userService.addUser(user);
        }
        return vo;
    }

    @RequestMapping("toDeleteUser.do")
    @SystemServiceLog(module = "mds",option = "删除用户",description = "删除用户")
    @ResponseBody
    public ResultVo deleteUser(String[] ids){
        ResultVo vo =  null;
        vo = userService.deleteUserForUpdate(ids);
        return vo;
    }
}
