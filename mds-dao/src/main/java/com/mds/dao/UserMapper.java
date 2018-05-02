package com.mds.dao;


import com.mds.entity.User;
import com.mds.vo.UserVo;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getUserByEntity(User user);

    List<UserVo> selectBySelective(UserVo userVo);

    int selectCountBySelective(UserVo userVo);

    User getUserById(String id);
}