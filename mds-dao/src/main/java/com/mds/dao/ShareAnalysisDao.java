package com.mds.dao;

import com.mds.entity.ShareAnalysis;
import com.mds.entity.SharePortrait;
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
 * Date: 17-11-5
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ShareAnalysisDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存股票分析数据
     * @param shareAnalysis
     * @return
     */
    public Integer saveShareAnalysis(ShareAnalysis shareAnalysis){
        final String sql = " INSERT INTO gp_shareanalysis ('sharesCode', 'price', 'time', 'createtime')";/* +
                " VALUES ( '"+shareAnalysis.getSharesCode()+"', '"+shareAnalysis.getPrice()+"', '"+shareAnalysis.getTime()+"', '"+shareAnalysis.getCreateTime()+"')";*/
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                return preparedStatement;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * 获取股票画像数据 根据实体
     * @param shareAnalysis
     * @return
     */
    public List<ShareAnalysis> queryShareAnalysisList(ShareAnalysis shareAnalysis){
        String sql = "select * from gp_shareanalysis where 1 = 1";
        /*if(shareAnalysis.getCreateTime()!=null){
            sql += " and createTime = '"+shareAnalysis.getCreateTime()+"' ";
        }
        if(shareAnalysis.getPrice()!=null){
            sql += " and price = '"+shareAnalysis.getPrice()+"' ";
        }
        if(shareAnalysis.getSharesCode()!=null){
            sql += " and sharesCode = '"+shareAnalysis.getSharesCode()+"' ";
        }*/
        List<ShareAnalysis> dataList = jdbcTemplate.query(sql,new BeanPropertyRowMapper(ShareAnalysis.class));
        return dataList;
    }

    /**
     * 获取股票分析数据 单条 根据数据编号
     * @param id
     * @return
     */
    public SharePortrait getShareAnalysis(Integer id){
        String sql = "select * from gp_shareanalysis where id = ?";
        SharePortrait sharePortrait = jdbcTemplate.queryForObject(sql,new Object[]{id},SharePortrait.class);
        return sharePortrait;
    }
}
