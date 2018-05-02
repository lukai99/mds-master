package com.mds.controller;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.entity.Menu;
import com.mds.entity.Role;
import com.mds.entity.RoleMenu;
import com.mds.service.MenuService;
import com.mds.service.RoleService;
import com.mds.utils.PageBean;
import com.mds.vo.RoleVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/roleManage/")
public class RoleManageController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("toRoleManagePage.do")
    public String toRoleManagePage(){ return "roleManager/roleList"; }

    @RequestMapping("toRoleManageList.do")
    @ResponseBody
    public PageBean<RoleVo> toRoleManage(RoleVo roleVo,PageBean pageBean){
        PageBean<RoleVo> pageBeanResult = roleService.queryRoles(roleVo,pageBean);
        return pageBeanResult;
    }

    @RequestMapping("toAddRole.do")
    public String toAddRole(Role role, Model model){
        if(role.getId() != null){
            ResultVo<Role> resultVo = roleService.queryRole(role.getId());
            Role rl = (Role) resultVo.getData();
            model.addAttribute("rl",rl);
        }
        return "roleManager/toAddRole";
    }

    @RequestMapping("addRole.do")
    @SystemServiceLog(module = "mds",option = "增加角色",description = "增加角色")
    @ResponseBody
    public ResultVo addRole(Role role){
        ResultVo resultVo = null;
        if(role.getId() != null && !"".equals(role.getId())){
            resultVo = roleService.updateRole(role);
        }else {
            resultVo = roleService.saveRole(role);
        }
        return resultVo;
    }

    @RequestMapping("toDeleteRole.do")
    @SystemServiceLog(module = "mds",option = "删除用户",description = "删除用户")
    @ResponseBody
    public ResultVo deleteRole(String[] ids){
        ResultVo vo =  null;
        vo = roleService.deleteRoles(ids);
        return vo;
    }

    @RequestMapping("toAddMenu.do")
    public String toAddMenu(Role role,Model model){
        model.addAttribute("roleId",role.getId());
        return "roleManager/toAddMenu";
    }

    @RequestMapping("getTree.do")
    public void getTree(HttpServletRequest request, HttpServletResponse response,String roleId){
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            List<RoleMenu> roleMenuList = menuService.getRoleMenuList(roleId);
            List<Menu> pMenus = menuService.getMenusListForLevel(WebConstants.MENU_LEVEL_P);
            String zNodes = roleService.getZnods(roleMenuList,pMenus);
            PrintWriter out = response.getWriter();
            out.write(zNodes);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("addRoleMenu.do")
    @ResponseBody
    public ResultVo addRoleMenu(String ids,String roleId,HttpServletResponse response,HttpServletRequest request){
            ResultVo vo = null;
            vo = menuService.addMenuTree(ids,roleId);
            return vo;
    }
}
