package com.mds.dao;

import com.mds.entity.DataCheck;
import com.mds.entity.Shares;
import com.mds.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-11-14
 * Time: 下午9:35
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ShareDataCheckDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询数据列表
     * @return
     */
    public List<DataCheck> queryDataCheckList(){
        String sql = "select * from gp_datacheck order by id";
        List<DataCheck> list = jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper(DataCheck.class));
        return list;
    }

    /**
     * 获取单条数据 根据id
     * @param id
     * @return
     */
    public DataCheck getDataCheck(Integer id){
        String sql = "select * from gp_datacheck where id = ?";
        List<DataCheck> list = jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper(DataCheck.class));
        return list!=null?list.get(0):null;
    }

    /**
     * 获取数据根据股票编号
     * @param shareCode
     * @return
     */
    public List<DataCheck> queryDataCheckByShareCode(String shareCode){
        String sql = "select * from gp_datacheck where sharecode = ? order by id";
        List<DataCheck> list = jdbcTemplate.query(sql,new Object[]{shareCode},new BeanPropertyRowMapper(DataCheck.class));
        return list;
    }

    /**
     * 获取数据根据实体信息
     * @param dataCheck
     * @return
     */
    public List<DataCheck> queryDataCheckByEntity(DataCheck dataCheck){
        String sql = "select * from gp_datacheck where 1=1 ";
//        if(dataCheck){
//            sql += "" ;
//        }
        sql += " order by id ";
        List<DataCheck> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper(DataCheck.class));
        return list;
    }

    /**
     * 添加选点数据
     * @param dataCheck
     * @return
     */
    public Integer addDataCheck(DataCheck dataCheck){
        final StringBuilder  sql = new StringBuilder(" insert into gp_datacheck(shareCode,high,highDate,low,lowDate,tz,tzl,tzDate,createTime,remark) ");
        sql.append(" value('"+dataCheck.getShareCode()+"','"+dataCheck.getHigh()+"','"+dataCheck.getHighDate()+"','"+dataCheck.getLow()+"','"+dataCheck.getLowDate()+"','"+dataCheck.getTz()+"','"+dataCheck.getTzl()+"','"+dataCheck.getTzDate()+"','"+ DateUtil.formatDate2Str(dataCheck.getCreateTime())+"','"+dataCheck.getRemark()+"') ");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                return preparedStatement;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * 修改选点数据
     * @param dataCheck
     * @return
     */
    public boolean updateDataCheck(DataCheck dataCheck){
        StringBuilder sql = new StringBuilder("");
        return true;
    }

    /**
     * 删除选点数据
     * @param id
     * @return
     */
    public boolean deleteDataCheck(Integer id){
        return true;
    }

}
