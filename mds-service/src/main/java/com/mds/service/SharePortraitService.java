package com.mds.service;


import com.mds.entity.SharePortrait;
import com.mds.common.ResultVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-10-16
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
public interface SharePortraitService {

    /**
     * 保存股票画像
     * @param sharePortrait
     * @return
     */
    public Integer saveSharePortrait(SharePortrait sharePortrait);

    /**
     * 修改股票画像数据
     * @param sharePortrait
     * @return
     */
    public Integer updateSharePortrait(SharePortrait sharePortrait);

    /**
     * 获取股票画像数据 根据股票编号
     * @param shareCode
     * @return
     */
    public List<SharePortrait> querySharePortraitList(String shareCode);

    /**
     * 获取股票画像数据 根据数据实体
     * @param sharePortrait
     * @return
     */
    public List<SharePortrait> querySharePortraitList(SharePortrait sharePortrait);

    /**
     * 获取股票画像数据 根据数据id
     * @param id
     * @return
     */
    public ResultVo getSharePortrait(Integer id);


}
