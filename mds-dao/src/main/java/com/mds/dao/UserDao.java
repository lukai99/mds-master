package com.mds.dao;

import com.mds.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-18
 * Time: 下午1:55
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {

    public List<User> getUserByEntity(User user);

}
