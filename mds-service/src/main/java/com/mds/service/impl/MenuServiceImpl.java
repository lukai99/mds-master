package com.mds.service.impl;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.MenuDao;
import com.mds.entity.Menu;
import com.mds.entity.RoleMenu;
import com.mds.service.MenuService;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-18
 * Time: 下午9:15
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(propagation= Propagation.REQUIRED)
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "添加菜单",description = "添加菜单")
    public ResultVo<Menu> addMenu(Menu menu) {
        ResultVo<Menu> resultVo = new ResultVo<Menu>();
        menu.setId(UUIDUtils.getUUID());
        menu.setCreateTime(new Date());
        resultVo.setData(menu);
        menuDao.saveMenu(menu);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "修改菜单",description = "修改菜单")
    public ResultVo<Menu> updateMenu(Menu menu) {
        ResultVo<Menu> resultVo = new ResultVo<Menu>();
        resultVo.setData(menu);
        menuDao.updateMenu(menu);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除菜单",description = "删除菜单（逻辑删除）")
    public ResultVo<Menu> deleteMenuByUpdate(String[] menuIds) {
        ResultVo<Menu> resultVo = new ResultVo<Menu>();
        String ids = "";
        for(String id:menuIds){
            ids += "'"+id +"',";
        }
        ids = ids.substring(0,ids.length()-1);
        resultVo.setData(menuDao.deleteMenuByUpdate(ids));
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除菜单",description = "删除菜单（物理删除）")
    public ResultVo<Menu> deleteMenuByDelete(String[] menuIds) {

        ResultVo<Menu> resultVo = new ResultVo<Menu>();
        String ids = "";
        for(String id:menuIds){
             ids += "'"+id +"',";
        }
        ids = ids.substring(0,ids.length()-1);
        resultVo.setData(menuDao.deleteMenu(ids));
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public List<Menu> getChildMenus(String parentId) {
        return menuDao.getChildMenus(parentId);
    }

    @Override
    public List<Menu> queryMenus(Menu menu) {
        return menuDao.queryMenus(menu);
    }

    @Override
    @SystemServiceLog(module = "mds",option = "菜单列表查询",description = "菜单管理列表页查询")
    public PageBean<Menu> queryMenus(Menu menu, PageBean pageBean) {
        PageBean<Menu> resultPageBean = new PageBean<Menu>();
        List<Menu> resultList = menuDao.queryMenus(menu,pageBean);
        int count = menuDao.queryMenusCount(menu);
        resultPageBean.setRows(resultList);
        resultPageBean.setTotal(count);
        resultPageBean.setResultCode(0);
        return resultPageBean;
    }

    @Override
    public Menu getMenuInfo(String id) {
        return menuDao.getMenuInfo(id);
    }

    @Override
    public Map<String, Object> getOnePageInfo(String id) {
        Map<String,Object> map = new HashMap<String,Object>();
        Menu menu = this.getMenuInfo(id);
        List<Menu> list = this.getChildMenus(id);
        map.put("menu",menu);
        map.put("childMenu",list);
        return map;
    }

    @Override
    public ResultVo<Menu> getInitMenusData(String userId,String roleId) {
        ResultVo<Menu> resultVo = new ResultVo<Menu>(ResultVo.SUCCESS,ResultVo.SUCCESS_MESSAGE);
//        List<Menu> list = getMenusListForLevel(1);  //获取一级菜单
        List<Menu> listm = getRoleMenusListForLevel(WebConstants.MENU_LEVEL_P,roleId);
        resultVo.setDataList(listm);
        for(Menu menu:listm){
            buildMenusData(menu,roleId);
        }
        return resultVo;
    }

    /**
     * 递归构建菜单数据机构
     * @param menu
     */
    public void buildMenusData(Menu menu,String roleId){
        List<Menu> childList = getChildRoleMenus(menu.getId(),roleId);  //获取子集菜单
        if(childList!=null&&childList.size()>0){
            menu.setChildList(childList);
            for(Menu childMenu:childList){
                buildMenusData(childMenu,roleId);
            }
        }
    }

    public List<Menu> getChildRoleMenus(String id,String roleId){
        return menuDao.getChildRoleMenus(id,roleId);
    }

    @Override
    public List<Menu> getMenusListForLevel(int level) {
        Menu queryMenu = new Menu();
        queryMenu.setLevel(level);
        queryMenu.setState(1+"");
        List<Menu> list = queryMenus(queryMenu);
        return list;
    }

    public List<Menu> getRoleMenusListForLevel(int level,String roleId){
        return menuDao.getRoleMenusListForLevel(level,roleId);
    }

    @Override
    @Transactional
    public ResultVo<Menu> testTransMenuPage() {
        Menu menu = new Menu();
        menu.setId(UUIDUtils.getUUID());
        menu.setName("test1");
        //menuDao.saveMenu(menu);
        addMenu(menu);
        menu.setId(UUIDUtils.getUUID());
        menu.setName("错误数据测试错误数据(事务)");
       // menuDao.saveMenu(menu);
        addMenu(menu);
        return null;
    }

    @Override
    public List<RoleMenu> getRoleMenuList(String roleId) {
        return menuDao.getRoleMenuList(roleId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public ResultVo addMenuTree(String ids, String roleId) {
        ResultVo vo = new ResultVo();
        String[] arrayIds = ids.split(",");
        int a = menuDao.deleteRoleMenus(roleId);
        for (String id : arrayIds){
            menuDao.addRoleMenu(id,roleId);
        }
        vo.setState(ResultVo.SUCCESS);
        vo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return vo;
    }

}
