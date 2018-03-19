package com.mds.dao;

import com.mds.entity.Expect;
import com.mds.entity.Shares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-19
 * Time: 下午12:52
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ExpectDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Expect> queryExpectList(){
        StringBuilder sql = new StringBuilder("");
        sql.append("select * from gp_expect where 1 = 1 ");
        sql.append("order by createTime desc");
        List<Expect> list = jdbcTemplate.query(sql.toString(), new Object[]{}, new BeanPropertyRowMapper(Expect.class));
        return list;
    }

    public List<Expect> queryExpectList(Expect expect){
        StringBuilder sql = new StringBuilder("");
        sql.append("select * from gp_expect where 1 = 1 ");
        if(!StringUtils.isEmpty(expect.getSharesCode())){
             sql.append(" and sharesCode = "+expect.getSharesCode()+" ");
        }
        sql.append("order by createTime desc");
        List<Expect> list = jdbcTemplate.query(sql.toString(), new Object[]{}, new BeanPropertyRowMapper(Expect.class));
        return list;
    }

    public Expect getExpect(Integer id){
        StringBuilder sql = new StringBuilder("");
        sql.append(" select * form gp_expect where id = ?");
        Expect expect = (Expect)jdbcTemplate.queryForObject(sql.toString(), new Object[]{id}, new BeanPropertyRowMapper(Expect.class));
        return expect;
    }

    public Expect getExpect(String code){
        StringBuilder sql = new StringBuilder("");
        sql.append(" select * form gp_expect where code = ?");
        Expect expect = (Expect)jdbcTemplate.queryForObject(sql.toString(), new Object[]{code}, new BeanPropertyRowMapper(Expect.class));
        return expect;
    }

    public Integer saveExpect(Expect expect){
        final StringBuilder sql = new StringBuilder("");
        sql.append("insert into gp_expect(enough,trend,highprice,lowprice,expectprice,stopprice,actualprice,sharescode,formulacode,remark)" +
                " values("+expect.getEnough()+","+expect.getTrend()+","+expect.getHighPrice()+","+expect.getLowPrice()+","
                + expect.getExpectPrice()+","+expect.getStopPrice()+","+expect.getActualPrice()+",'"+expect.getSharesCode()+"',"+expect.getFormulaCode()+",'"
                + expect.getRemark()+"')");

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
}
