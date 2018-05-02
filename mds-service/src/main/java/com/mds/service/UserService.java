package com.mds.service;

import com.mds.common.ResultVo;
import com.mds.entity.User;
import com.mds.utils.PageBean;
import com.mds.vo.UserVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-18
 * Time: 下午1:38
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public List<User> getUserByEntity(User user);

    /**
     * 带分页的查询
     * @param userVo
     * @param pageBean
     * @return
     */
    public PageBean<UserVo> queryUserInfo(UserVo userVo, PageBean pageBean);

    public ResultVo<User> queryUser(String id);

    public ResultVo<User> addUser(User user);

    public ResultVo<User> updateUser(User user);

    public ResultVo<User> deleteUser(User user);

    public ResultVo<User> deleteUser(String id);

    public ResultVo<User>  deleteUserForUpdate(String[] ids);

    public User queryUserById(String id);
}
