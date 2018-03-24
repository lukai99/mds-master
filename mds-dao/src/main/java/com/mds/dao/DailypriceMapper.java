package com.mds.dao;

import com.mds.entity.Dailyprice;
import com.mds.vo.DailypriceVo;

import java.util.List;

public interface DailypriceMapper {

    int deleteByPrimaryKey(String id);

    int insert(Dailyprice record);

    int insertSelective(Dailyprice record);

    Dailyprice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dailyprice record);

    int updateByPrimaryKey(Dailyprice record);

    List<DailypriceVo> selectBySelective(DailypriceVo dailypriceVo);

    int selectCountBySelective(DailypriceVo dailypriceVo);

    /**
     * 级联基本元素表查询
     * 分页模式
     * @param dailypriceVo
     * @return
     */
    List<DailypriceVo> selectVoBySelective(DailypriceVo dailypriceVo);

    /**
     * 级联基本元素表查询总数
     *
     * @param dailypriceVo
     * @return
     */
    int selectVoCountBySelective(DailypriceVo dailypriceVo);
}