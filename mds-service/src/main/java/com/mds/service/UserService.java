package com.mds.service;

import com.mds.entity.User;

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
}
