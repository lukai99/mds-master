package com.mds.dao;

import com.mds.entity.Shares;
import com.mds.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-15
 * Time: 下午5:02
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SharesDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Shares> querySharesList(){
        String sql = "select * from gp_shares order by id";
        List<Shares> list = jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper(Shares.class));
        return list;
    }
    public List<Shares> querySharesListForPage(Shares shares, int pageNum, int pageSize){
        String sql = " select t.* from gp_shares t where 1 = 1 ";
        String dtSql = "  ";
        if(shares.getId() != null&&"".equals(shares.getId())){
            dtSql = " t.id = "+ shares.getId();
        }
        if(shares.getCode() != null&&"".equals(shares.getCode())){
            dtSql = " t.code = "+ shares.getId();
        }
        if(shares.getName() != null&&"".equals(shares.getName())){
            dtSql = " t.name = "+ shares.getId();
        }
        sql = sql + dtSql + " limit "+pageNum+","+pageSize;
        List<Shares> list = jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper(Shares.class));
        return list;
    }
    public int querySharesCountForPage(Shares shares, int pageNum, int pageSize){
        String sql = " select t.* from gp_shares t where 1 = 1 ";
        String dtSql = "  ";
        if(shares.getId() != null&&"".equals(shares.getId())){
            dtSql = " t.id = "+ shares.getId();
        }
        if(shares.getCode() != null&&"".equals(shares.getCode())){
            dtSql = " t.code = "+ shares.getId();
        }
        if(shares.getName() != null&&"".equals(shares.getName())){
            dtSql = " t.name = "+ shares.getId();
        }
        sql = sql + dtSql;
        Integer count = (Integer)jdbcTemplate.queryForObject(sql,new Object[]{},new BeanPropertyRowMapper(Integer.class));
        return count.intValue();
    }
    public Shares getShares(Integer id){
        String sql = "select * from gp_shares where id = ?";
        List<Shares> list = jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper(Shares.class));
        return list!=null?list.get(0):null;
    }
    public Shares getShares(String code){
        String sql = "select * from gp_shares where code = ?";
        List<Shares> list = jdbcTemplate.query(sql,new Object[]{code},new BeanPropertyRowMapper(Shares.class));
        return list!=null?list.get(0):null;
    }
    public Shares getRandShares(){
        String sql = "select * from gp_shares order by rand() LIMIT 1";
        List<Shares> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper(Shares.class));
        return list!=null?list.get(0):null;
    }
}
