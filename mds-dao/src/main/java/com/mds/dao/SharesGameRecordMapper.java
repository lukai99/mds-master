package com.mds.dao;

import com.mds.entity.SharesGameRecord;
import com.mds.vo.SharesGameRecordVo;

import java.util.List;

public interface SharesGameRecordMapper {

    int deleteByPrimaryKey(String id);

    int insert(SharesGameRecord record);

    int insertSelective(SharesGameRecord record);

    int updateByPrimaryKeySelective(SharesGameRecord record);

    int updateByPrimaryKey(SharesGameRecord record);

    SharesGameRecord selectByPrimaryKey(String id);

    /**
     * 获取游戏记录列表
     * 根据传入参数
     * @param sharesGameRecordVo
     * @return
     */
    List<SharesGameRecordVo> selectBySelective(SharesGameRecordVo sharesGameRecordVo);

    /**
     * 获取游戏记录总数
     * 根据传入参数
     * @param sharesGameRecordVo
     * @return
     */
    int selectCountBySelective(SharesGameRecordVo sharesGameRecordVo);
}