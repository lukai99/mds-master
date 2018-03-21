package com.mds.service.impl;

import com.mds.dao.UserMapper;
import com.mds.entity.User;
import com.mds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
