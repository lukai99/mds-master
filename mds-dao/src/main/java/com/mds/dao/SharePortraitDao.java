package com.mds.dao;

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
 * Date: 17-10-16
 * Time: 下午10:36
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SharePortraitDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存股票画像
     * @param sharePortrait
     * @return 数据主键
     */
    public Integer saveSharePortrait(SharePortrait sharePortrait){
        final String sql = " INSERT INTO gp_shereportrait ('sharesCode', 'price', 'time', 'createtime')" +
                     " VALUES ( '"+sharePortrait.getSharesCode()+"', '"+sharePortrait.getPrice()+"', '"+sharePortrait.getTime()+"', '"+sharePortrait.getCreateTime()+"')";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                return preparedStatement;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * 获取股票画像数据 根据实体
     * @param sharePortrait
     * @return
     */
    public List<SharePortrait> querySharePortraitList(SharePortrait sharePortrait){
        String sql = "select * from gp_shereportrait where 1 = 1";
        if(sharePortrait.getCreateTime()!=null){
            sql += " and createTime = '"+sharePortrait.getCreateTime()+"' ";
        }
        if(sharePortrait.getPrice()!=null){
            sql += " and price = '"+sharePortrait.getPrice()+"' ";
        }
        if(sharePortrait.getSharesCode()!=null){
            sql += " and sharesCode = '"+sharePortrait.getSharesCode()+"' ";
        }
        List<SharePortrait> dataList = jdbcTemplate.query(sql,new BeanPropertyRowMapper(SharePortrait.class));
        return dataList;
    }

    /**
     * 获取股票画像数据 单条 根据数据编号
     * @param id
     * @return
     */
    public SharePortrait getSharePortrait(Integer id){
        String sql = "select * from gp_shereportrait where id = ?";
        SharePortrait sharePortrait = jdbcTemplate.queryForObject(sql,new Object[]{id},SharePortrait.class);
        return sharePortrait;
    }
}
