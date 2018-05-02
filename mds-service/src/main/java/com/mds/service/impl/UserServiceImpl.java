package com.mds.service.impl;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.UserMapper;
import com.mds.entity.User;
import com.mds.service.UserService;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import com.mds.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-18
 * Time: 下午1:54
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByEntity(User user) {
        List<User> userList =  userMapper.getUserByEntity(user);
        return userList;
    }

    @Override
    public PageBean<UserVo> queryUserInfo(UserVo userVo, PageBean pageBean) {
        PageBean<UserVo> resultPageBean = new PageBean<UserVo>();
        userVo.setPage(pageBean.getStartRowNum());
        userVo.setLimit(pageBean.getEndRowNum());
        userVo.setIsdel(WebConstants.NO);
        List<UserVo> list = userMapper.selectBySelective(userVo);
        int rowCount = userMapper.selectCountBySelective(userVo);
        resultPageBean.setRows(list);
        resultPageBean.setTotal(rowCount);
        resultPageBean.setResultCode(WebConstants.layuiRequestCode);
        return resultPageBean;
    }

    @Override
    public ResultVo<User> queryUser(String id) {
        ResultVo<User> resultVo = new ResultVo<User>();
        User u = userMapper.selectByPrimaryKey(id);
        resultVo.setData(u);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "添加用户基本信息",description = "添加用户基本信息")
    public ResultVo<User> addUser(User user) {
        ResultVo<User> resultVo = new ResultVo<User>();
        user.setId(UUIDUtils.getUUID());
        user.setCreatetime(new Date());
        user.setIsdel(WebConstants.NO);
        userMapper.insert(user);
        resultVo.setData(user);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "更新用户基本信息",description = "更新用户基本信息")
    public ResultVo<User> updateUser(User user) {
        ResultVo<User> resultVo = new ResultVo<User>();
        user.setUpdatetime(new Date());
        int rowNum = userMapper.updateByPrimaryKeySelective(user);
        resultVo.setData(rowNum);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "逻辑删除用户基本信息",description = "逻辑删除用户基本信息")
    public ResultVo<User> deleteUser(User user) {
        ResultVo<User> resultVo = new ResultVo<User>();
        user.setIsdel(WebConstants.YES);
        user.setUpdatetime(new Date());
        int rowNum = userMapper.updateByPrimaryKey(user);
        resultVo.setData(rowNum);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "物理删除用户基本信息",description = "物理删除用户基本信息")
    public ResultVo<User> deleteUser(String id) {
        ResultVo<User> resultVo = new ResultVo<User>();
        int rowNum = userMapper.deleteByPrimaryKey(id);
        resultVo.setData(rowNum);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "批量删除用户基本信息",description = "批量删除用户基本信息")
    public ResultVo<User> deleteUserForUpdate(String[] ids) {
        ResultVo<User> resultVo = new ResultVo<User>();
        for(String id : ids){
            userMapper.deleteByPrimaryKey(id);
        }
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public User queryUserById(String id) {
        User u = userMapper.getUserById(id);
        return u;
    }
}
