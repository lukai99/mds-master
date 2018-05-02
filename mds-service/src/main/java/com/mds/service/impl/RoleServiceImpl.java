package com.mds.service.impl;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.RoleMapper;
import com.mds.entity.Menu;
import com.mds.entity.Role;
import com.mds.entity.RoleMenu;
import com.mds.service.MenuService;
import com.mds.service.RoleService;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import com.mds.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuService menuService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "添加角色",description = "添加角色")
    public ResultVo<Role> saveRole(Role roleinfo) {
        roleinfo.setId(UUIDUtils.getUUID());
        roleinfo.setCreatetime(new Date());
        roleinfo.setIsdel(WebConstants.NO);
        ResultVo<Role> resultVo = new ResultVo<Role>();
        roleMapper.insertSelective(roleinfo);
        resultVo.setData(roleinfo);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        resultVo.setState(ResultVo.SUCCESS);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "修改角色",description = "修改角色")
    public ResultVo<Role> updateRole(Role roleinfo) {
        ResultVo<Role> resultVo = new ResultVo<Role>();
        roleinfo.setUpdatetime(new Date());
        int roleNum = roleMapper.updateByPrimaryKeySelective(roleinfo);
        resultVo.setData(roleNum);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        resultVo.setState(ResultVo.SUCCESS);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "物理删除ALL",description = "物理删除ALL")
    public ResultVo<Role> deleteRoles(String[] ids) {
        ResultVo<Role> resultVo = new ResultVo<Role>();
        for (String id : ids){
            roleMapper.deleteByPrimaryKey(id);
        }
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        resultVo.setState(ResultVo.SUCCESS);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "物理删除",description = "物理删除")
    public ResultVo<Role> deleteRole(String id) {
        ResultVo<Role> resultVo = new ResultVo<Role>();
        int roleNum = roleMapper.deleteByPrimaryKey(id);
        resultVo.setData(roleNum);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        resultVo.setState(ResultVo.SUCCESS);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "逻辑删除",description = "逻辑删除")
    public ResultVo<Role> deleteRole(Role role) {
        return null;
    }

    @Override
    public PageBean<RoleVo> queryRoles(RoleVo roleInfoVo, PageBean pageBean) {
        PageBean<RoleVo> page = new PageBean<RoleVo>();
        roleInfoVo.setPage(pageBean.getStartRowNum());
        roleInfoVo.setLimit(pageBean.getEndRowNum());
        roleInfoVo.setIsdel(WebConstants.NO);
        List<RoleVo> list = roleMapper.queryRoleBySelective(roleInfoVo);
        int rowCount = roleMapper.countRoleBySelective(roleInfoVo);
        page.setRows(list);
        page.setTotal(rowCount);
        page.setResultCode(WebConstants.layuiRequestCode);
        return page;
    }

    @Override
    public ResultVo<RoleVo> querySharesRole(RoleVo roleVo) {
        return null;
    }

    @Override
    public ResultVo<RoleVo> queryAllRoles() {
        ResultVo<RoleVo> resultVo = new ResultVo<RoleVo>();
        List<RoleVo> list = roleMapper.queryAllRoles();
        resultVo.setDataList(list);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<Role> queryRole(String id) {
        ResultVo<Role> resultVo = new ResultVo<Role>();
        Role role = roleMapper.selectByPrimaryKey(id);
        resultVo.setData(role);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public String getZnods(List<RoleMenu> list,List<Menu> mlist) {
        StringBuffer str = new StringBuffer();
        List<Menu> cpList = getCheck(list,mlist);
        str.append("[");
        for (int i=0;i<cpList.size();i++){
            str.append("{ id:"+(i+1)+",pId:0,name:\""+cpList.get(i).getName()+"\",value:\""+cpList.get(i).getId()+"\",open:true,checked:"+(cpList.get(i).getIsCheck().equals("1") ? "true" : "false")+"}");
            List<Menu> chList = menuService.getChildMenus(cpList.get(i).getId());
            if(chList != null){
                str.append(",");
                List<Menu> cchList = getCheck(list,chList);
                for(int j=0;j<chList.size();j++){
                    str.append("{ id:"+(i+1)+""+(j+1)+",pId:"+(i+1)+",name:\""+chList.get(j).getName()+"\",value:\""+chList.get(j).getId()+"\",checked:"+(chList.get(j).getIsCheck().equals("1") ? "true" : "false")+"}");
                    if(j<chList.size()-1){
                        str.append(",");
                    }
                }
            }
            if(i<cpList.size()-1){
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }

    public List<Menu> getCheck(List<RoleMenu> list,List<Menu> mlist){
        for(int i=0;i<mlist.size();i++){
            mlist.get(i).setIsCheck("0");
            for(int j=0;j<list.size();j++){
                if(mlist.get(i).getId().equals(list.get(j).getMenuid())){
                    mlist.get(i).setIsCheck("1");
                }
            }
        }
        return mlist;
    }
}
