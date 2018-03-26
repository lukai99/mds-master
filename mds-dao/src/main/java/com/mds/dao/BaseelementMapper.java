package com.mds.dao;

import com.mds.entity.Baseelement;
import com.mds.vo.BaseElementVo;

import java.util.List;

public interface BaseelementMapper {
    int deleteByPrimaryKey(String id);

    int insert(Baseelement record);

    int insertSelective(Baseelement record);

    Baseelement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Baseelement record);

    int updateByPrimaryKey(Baseelement record);

    List<BaseElementVo>  selectBySelective(BaseElementVo baseElementVo);

    int selectCountBySelective(BaseElementVo baseElementVo);
}