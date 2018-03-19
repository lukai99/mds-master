package com.mds.service.impl;

import com.mds.annotation.SystemServiceLog;
import com.mds.entity.User;
import com.mds.service.LoginService;
import com.mds.service.UserService;
import com.mds.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-18
 * Time: 下午9:15
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;
    @Override
    @SystemServiceLog(module = "mds",option = "用户登录验证",description = "用户登录进行的登录验证服务")
    public Boolean userLogin(User user) {
        List<User> userList = userService.getUserByEntity(user);
        if(userList!=null&&!userList.isEmpty()){
            try {
                ObjectUtils.copyProperty(user,userList.get(0)); //补全user对象不全的信息
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
