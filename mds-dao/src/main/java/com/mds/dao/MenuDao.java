package com.mds.dao;

import com.mds.entity.Menu;
import com.mds.utils.DateUtil;
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
 * Date: 17-8-10
 * Time: 下午5:52
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class MenuDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取全部子菜单 根据父级菜单id
     * @param parentId
     * @return
     */
    public List<Menu> getChildMenus(String parentId){
        String sql = "select * from sys_menu where parentid = ? and isdel = '1' order by `order` asc";
        List<Menu> list = jdbcTemplate.query(sql,new Object[]{parentId},new BeanPropertyRowMapper(Menu.class));
        return list;
    }
    public List<Menu> queryMenus(Menu menu){
        StringBuilder sql = new StringBuilder("select t.* from sys_menu t where 1=1");
        if(!StringUtils.isEmpty(menu.getLevel())){
            sql.append(" and t.level = '"+menu.getLevel()+"' ");
        }
        if(!StringUtils.isEmpty(menu.getState())){
            sql.append(" and t.state = '"+menu.getState()+"' ");
        }
        sql.append(" and t.isdel = '1' ");
        sql.append(" order by `order` asc ");
        List<Menu> list = jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper(Menu.class));
        return list;
    }
    public int queryMenusCount(Menu menu){
        StringBuilder sql = new StringBuilder("select count(1) from sys_menu t where 1=1");
        if(!StringUtils.isEmpty(menu.getName())){
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
        sql.append(" and t.isdel = '1' ");
        int count = jdbcTemplate.queryForObject(sql.toString(),Integer.class).intValue();
        return count;
    }
    public List<Menu> queryMenus(Menu menu,PageBean pageBean){
        StringBuilder sql = new StringBuilder("select t.* from sys_menu t where 1=1");
        if(!StringUtils.isEmpty(menu.getName())){
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
        sql.append(" and t.isdel = '1' ");
//        sql.append(" order by createTime asc ");
        sql.append(" order by `order` asc ");
        sql.append(" limit "+pageBean.getStartRowNum()+","+pageBean.getEndRowNum()+" ");
        List<Menu> list = jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper(Menu.class));
        return list;
    }
    public Menu getMenuInfo(String id){
        String sql = "select * from sys_menu where id = ? ";
        List<Menu> list = jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper(Menu.class));
        return list.get(0);
    }

    public int saveMenu(Menu menu){
        StringBuilder sql = new StringBuilder("");
        sql.append("insert into sys_menu(id,name,rel,parentid,url,icon,level,`order`,state,createtime,remark) values(?,?,?,?,?,?,?,?,?,?,?)");
        return jdbcTemplate.update(sql.toString(),menu.getId(),menu.getName(),menu.getRel(),menu.getParentId(),menu.getUrl(),menu.getIcon(),menu.getLevel(),menu.getOrder(),menu.getState(),menu.getCreateTime(),menu.getRemark());
    }

    public int updateMenu(Menu menu){
        StringBuilder sql = new StringBuilder("");
        sql.append("update  sys_menu set name = ?,rel = ?,parentid = ?,url = ?,icon = ?,level = ?,`order` = ?,state = ?,remark = ? where id = ?");
        return jdbcTemplate.update(sql.toString(),menu.getName(),menu.getRel(),menu.getParentId(),menu.getUrl(),menu.getIcon(),menu.getLevel(),menu.getOrder(),menu.getState(),menu.getRemark(),menu.getId());
    }

    public int deleteMenu(String ids){
        StringBuilder sql = new StringBuilder("");
        sql.append("delete from sys_menu where id in ("+ids+")");
        return jdbcTemplate.update(sql.toString());
    }
    public int deleteMenuByUpdate(String ids){
        StringBuilder sql = new StringBuilder("");
        sql.append("update sys_menu set isdel = '0' where id in ("+ids+")");
        return jdbcTemplate.update(sql.toString());
    }
}
