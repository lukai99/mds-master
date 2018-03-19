package com.mds.service;

import com.mds.entity.Menu;
import com.mds.utils.PageBean;
import com.mds.common.ResultVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-18
 * Time: 下午2:36
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface MenuService {

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    public ResultVo<Menu> addMenu(Menu menu);

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    public ResultVo<Menu> updateMenu(Menu menu);

    /**
     * 批量删除菜单（逻辑删除）
     * @param menuIds
     * @return
     */
    public ResultVo<Menu> deleteMenuByUpdate(String[] menuIds);

    /**
     * 批量删除菜单（物理删除）
     * @param menuIds
     * @return
     */
    public ResultVo<Menu> deleteMenuByDelete(String[] menuIds);

    /**
     * 获取全部子菜单 根据父级菜单id
     * @param parentId
     * @return
     */
    public List<Menu> getChildMenus(String parentId);

    /**
     * 获取菜单 根据查询条件
     * @param menu
     * @return
     */
    public List<Menu> queryMenus(Menu menu);
    /**
     * 获取菜单 根据查询条件 分页模式
     * @param menu
     * @return
     */
    public PageBean<Menu> queryMenus(Menu menu, PageBean pageBean);

    /**
     * 获取菜单 根据菜单id
     * @param id
     * @return
     */
    public Menu getMenuInfo(String id);

    /**
     * 构建一级菜单页面
     * @param id
     * @return
     */
    public Map<String,Object> getOnePageInfo(String id);

    /**
     * 获取初始化菜单所用菜单列表数据
     * @param userId
     * @return
     */
    public ResultVo<Menu> getInitMenusData(String userId);

    /**
     * 获取菜单根据级别
     * @param level
     * @return
     */
    public List<Menu> getMenusListForLevel(int level);

    /**
     * 测试事务
     * @return
     */
    public ResultVo<Menu> testTransMenuPage();
}
