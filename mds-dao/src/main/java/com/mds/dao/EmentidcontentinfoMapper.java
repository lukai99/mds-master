package com.mds.dao;

import com.mds.entity.Ementidcontentinfo;
import com.mds.vo.EmentidcontentinfoVo;

import java.util.List;

public interface EmentidcontentinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Ementidcontentinfo record);

    int insertSelective(Ementidcontentinfo record);

    Ementidcontentinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Ementidcontentinfo record);

    int updateByPrimaryKey(Ementidcontentinfo record);

    int deleteEmentCheckInfo(String goodsdetailid);

    List<EmentidcontentinfoVo> getCheckInfoByDetailid(String detailid);
}