package com.mds.dao;

import com.mds.entity.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/7
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SystemLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveSystemLog(SystemLog systemLog){
        StringBuilder sql = new StringBuilder("");
        sql.append("insert into systemlog(id,userid,type,module,`option`,description,methodname,parameter,createtime,remark,userip) values(?,?,?,?,?,?,?,?,?,?,?)");
        return jdbcTemplate.update(sql.toString(),systemLog.getId(),systemLog.getUserId(),systemLog.getType(),systemLog.getModule(),systemLog.getOption(),systemLog.getDescription(),systemLog.getMethodName(),systemLog.getParameter(),systemLog.getCreateTime(),systemLog.getRemark(),systemLog.getUserIp());
    }
}
