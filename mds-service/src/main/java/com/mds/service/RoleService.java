package com.mds.service;

import com.mds.common.ResultVo;
import com.mds.entity.Menu;
import com.mds.entity.Role;
import com.mds.entity.RoleMenu;
import com.mds.utils.PageBean;
import com.mds.vo.RoleVo;

import java.util.List;

public interface RoleService {
    /**
     * 添加物品
     * @param goodsinfo
     * @return
     */
    public ResultVo<Role> saveRole(Role goodsinfo);

    /**
     * 修改物品
     * @param goodsinfo
     * @return
     */
    public ResultVo<Role> updateRole(Role goodsinfo);


    /**
     * 批量删除物品
     * @param ids
     * @return
     */
    public ResultVo<Role> deleteRoles(String[] ids);

    /**
     * 删除物品
     * 物理删除
     * @param id
     * @return
     */
    public ResultVo<Role> deleteRole(String id);

    /**
     * 删除物品
     * 逻辑删除
     * @param role
     * @return
     */
    public ResultVo<Role> deleteRole(Role role);

    /**
     * 查询物品信息
     * 分页专用
     * @param goodsInfoVo
     * @param pageBean
     * @return
     */
    public PageBean<RoleVo> queryRoles(RoleVo goodsInfoVo, PageBean pageBean);


    /**
     * 查询物品信息
     * 根据查询实体
     * @param roleVo
     * @return
     */
    public ResultVo<RoleVo> querySharesRole(RoleVo roleVo);

    /**
     * 查询出所有可用角色
     * @return
     */
    public  ResultVo<RoleVo> queryAllRoles();

    ResultVo<Role> queryRole(String id);

    public String getZnods(List<RoleMenu> list, List<Menu> mlist);
}
