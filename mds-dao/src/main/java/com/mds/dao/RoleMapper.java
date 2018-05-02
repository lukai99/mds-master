package com.mds.dao;

import com.mds.common.ResultVo;
import com.mds.entity.Role;
import com.mds.vo.RoleVo;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int countRoleBySelective(RoleVo roleVo);

    List<RoleVo> queryRoleBySelective(RoleVo roleVo);

    List<RoleVo> queryAllRoles();

}