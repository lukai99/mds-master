package com.mds.service;

import com.mds.common.ResultVo;
import com.mds.entity.Ementidcontentinfo;
import com.mds.vo.EmentidcontentinfoVo;
import com.mds.vo.GoodsdetailsinfoVo;

import java.util.List;

/**
 * Created by ASUS on 2018/3/27.
 */
public interface GoodsCheckService {

    public ResultVo saveGoodsCheck(GoodsdetailsinfoVo detailsinfo);

    public List<EmentidcontentinfoVo> getCheckInfoByDetailid(String detailid);
}
