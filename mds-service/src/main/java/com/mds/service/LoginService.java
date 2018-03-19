package com.mds.service;

import com.mds.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-18
 * Time: 下午2:36
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface LoginService {

    /**
     * 用户登录
     * @param user
     * @return true 登录成功 false 登录失败
     */
    public Boolean userLogin(User user);

}
