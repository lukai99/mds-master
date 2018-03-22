package com.mds.service.impl;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.GoodsinfoMapper;
import com.mds.entity.Dictionary;
import com.mds.entity.Goodsinfo;
import com.mds.service.GoodsInfoService;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import com.mds.vo.GoodsInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 2018/3/21.
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService{

    @Autowired
    GoodsinfoMapper goodsinfoMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "添加物品",description = "添加物品")
    public ResultVo<Goodsinfo> saveGoodsInfo(Goodsinfo goodsinfo) {
        ResultVo<Goodsinfo> resultVo = new ResultVo<Goodsinfo>();
        goodsinfo.setId(UUIDUtils.getUUID());
        goodsinfo.setCreatetime(new Date());
        goodsinfo.setIsdel(WebConstants.NO);
        goodsinfoMapper.insertSelective(goodsinfo);
        resultVo.setData(goodsinfo);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "修改物品",description = "修改物品")
    public ResultVo<Goodsinfo> updateGoodsInfo(Goodsinfo goodsinfo) {
        ResultVo<Goodsinfo> resultVo = new ResultVo<Goodsinfo>();
        goodsinfo.setUpdatetime(new Date());
        int resultNum = goodsinfoMapper.updateByPrimaryKeySelective(goodsinfo);
        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除物品（逻辑删除）",description = "删除物品（逻辑删除）根据数据主键")
    public ResultVo<Goodsinfo> deleteGoodsInfoForUpdate(String id) {
        ResultVo<Goodsinfo> resultVo = new ResultVo<Goodsinfo>();
        Goodsinfo goodsinfo = goodsinfoMapper.selectByPrimaryKey(id);
        goodsinfo.setUpdatetime(new Date());
        goodsinfo.setIsdel(WebConstants.YES);
        int resultNum = goodsinfoMapper.updateByPrimaryKeySelective(goodsinfo);
        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除物品（逻辑删除）",description = "删除物品（逻辑删除）根据数据主键")
    public ResultVo<Goodsinfo> deleteGoodsInfoForUpdate(String[] ids) {
        ResultVo<Goodsinfo> resultVo = new ResultVo<Goodsinfo>();
        for(String id : ids){
            Goodsinfo goodsinfoObj = goodsinfoMapper.selectByPrimaryKey(id);
            goodsinfoObj.setIsdel(WebConstants.YES);
            goodsinfoMapper.updateByPrimaryKeySelective(goodsinfoObj);
        }
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除物品（物理删除）",description = "删除物品（物理删除）根据数据主键")
    public ResultVo<Goodsinfo> deleteGoodsInfoForDelete(String id) {
        ResultVo<Goodsinfo> resultVo = new ResultVo<Goodsinfo>();
        int resultNum = goodsinfoMapper.deleteByPrimaryKey(id);
        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除字典项（物理删除）",description = "删除字典项（物理删除）")
    public ResultVo<Goodsinfo> deleteGoodsInfoForDelete(String[] ids) {
        ResultVo<Goodsinfo> resultVo = new ResultVo<Goodsinfo>();
        for(String id : ids){
            goodsinfoMapper.deleteByPrimaryKey(id);
        }
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public PageBean<GoodsInfoVo> queryGoodsInfo(GoodsInfoVo goodsInfoVo, PageBean pageBean) {

        PageBean<GoodsInfoVo> resultPageBean = new PageBean<GoodsInfoVo>();
        goodsInfoVo.setPage(pageBean.getStartRowNum());
        goodsInfoVo.setLimit(pageBean.getEndRowNum());
        goodsInfoVo.setIsdel(WebConstants.NO);
        List<GoodsInfoVo> resultList = goodsinfoMapper.selectBySelective(goodsInfoVo);
        int count = goodsinfoMapper.selectCountBySelective(goodsInfoVo);
        resultPageBean.setRows(resultList);
        resultPageBean.setTotal(count);
        resultPageBean.setResultCode(WebConstants.layuiRequestCode);
        return resultPageBean;
    }

    @Override
    public ResultVo<Goodsinfo> queryGoodsInfo(String id) {
        ResultVo<Goodsinfo> resultVo = new ResultVo<Goodsinfo>();
        Goodsinfo goodsinfo = goodsinfoMapper.selectByPrimaryKey(id);
        resultVo.setData(goodsinfo);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<GoodsInfoVo> querySharesAccountInfo(GoodsInfoVo goodsInfoVo) {
        ResultVo<GoodsInfoVo> resultVo = new ResultVo<GoodsInfoVo>();
        List<GoodsInfoVo> resultList = goodsinfoMapper.selectBySelective(goodsInfoVo);
        resultVo.setDataList(resultList);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        resultVo.setState(ResultVo.SUCCESS);
        return resultVo;
    }
}
