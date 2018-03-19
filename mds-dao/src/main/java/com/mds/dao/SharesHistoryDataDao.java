package com.mds.dao;

import com.mds.entity.Menu;
import com.mds.entity.SharesHistoryData;
import com.mds.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/14
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SharesHistoryDataDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 添加股票历史数据
     * @param sharesHistoryData
     * @return
     */
    public int saveSharesHistoryData(SharesHistoryData sharesHistoryData){
        StringBuilder sql = new StringBuilder("");
        sql.append("insert into gp_shareshistorydata(id,sharesid,frequency,startprice,highprice,lowprice,endprice,upval,amplitude," +
                "countnum,countmoney,changedhands,volamount,datatime,createtime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        return jdbcTemplate.update(sql.toString(),sharesHistoryData.getId(),sharesHistoryData.getSharesId(),sharesHistoryData.getFrequency(),
                sharesHistoryData.getStartPrice(),sharesHistoryData.getHighPrice(),sharesHistoryData.getLowPrice(),sharesHistoryData.getEndPrice(),
                sharesHistoryData.getUpVal(),sharesHistoryData.getAmplitude(),sharesHistoryData.getCountNum(),sharesHistoryData.getCountMoney(),
                sharesHistoryData.getChangedHands(),sharesHistoryData.getVolamount(),sharesHistoryData.getDataTime(),sharesHistoryData.getCreateTime());
    }

    public List<SharesHistoryData> querySharesHistoryData(SharesHistoryData sharesHistoryData, PageBean pageBean){
        StringBuilder sql = new StringBuilder("select t.* from gp_shareshistorydata t where 1=1");
        /*if(!StringUtils.isEmpty(sharesHistoryData.getName())){
            sql.append(" and t.name like '%"+menu.getName()+"%' ");
        }
        if(!StringUtils.isEmpty(sharesHistoryData.getRel())){
            sql.append(" and t.rel = '"+menu.getRel()+"' ");
        }
        if(!StringUtils.isEmpty(sharesHistoryData.getLevel())){
            sql.append(" and t.level = '"+menu.getLevel()+"' ");
        }
        if(!StringUtils.isEmpty(sharesHistoryData.getState())){
            sql.append(" and t.state = '"+menu.getState()+"' ");
        }*/
        sql.append(" order by createTime desc ");
        sql.append(" limit "+pageBean.getStartRowNum()+","+pageBean.getEndRowNum()+" ");
        List<SharesHistoryData> list = jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper(SharesHistoryData.class));
        return list;
    }

    public int querySharesHistoryDataCount(SharesHistoryData sharesHistoryData){
        StringBuilder sql = new StringBuilder("select count(1) from gp_shareshistorydata t where 1=1");
       /* if(!StringUtils.isEmpty(menu.getName())){
            sql.append(" and t.name like '%"+menu.getName()+"%' ");
        }
        if(!StringUtils.isEmpty(menu.getRel())){
            sql.append(" and t.rel = '"+menu.getRel()+"' ");
        }
        if(!StringUtils.isEmpty(menu.getLevel())){
            sql.append(" and t.level = '"+menu.getLevel()+"' ");
        }
        if(!StringUtils.isEmpty(menu.getState())){
            sql.append(" and t.state = '"+menu.getState()+"' ");
        }
        sql.append(" and t.isdel = '1' ");*/
        int count = jdbcTemplate.queryForObject(sql.toString(),Integer.class).intValue();
        return count;
    }
}
