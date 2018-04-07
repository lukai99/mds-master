package com.mds.service.impl;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.DailypriceMapper;
import com.mds.entity.Dailyprice;
import com.mds.entity.Dictionary;
import com.mds.service.DailypriceService;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import com.mds.vo.DailypriceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/3/21
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DailypriceServiceImpl implements DailypriceService {

    @Autowired
    private DailypriceMapper dailypriceMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "添加每日价格",description = "添加每日价格")
    public ResultVo<Dailyprice> saveDailyprice(Dailyprice dailyprice) {
        ResultVo<Dailyprice> resultVo = new ResultVo<Dailyprice>();
        //验证数据是否已经存在
        DailypriceVo vo = new DailypriceVo();
        vo.setBaseelementid(dailyprice.getBaseelementid());
        vo.setInputtime(dailyprice.getInputtime());
        List<Dailyprice> vilist = dailypriceMapper.queryTodayPrice(vo);
        if(vilist!=null&&vilist.size()>0){
            resultVo.setState(ResultVo.FAILED);
            resultVo.setMessage("价格已录入！");
            return resultVo;
        }
        dailyprice.setId(UUIDUtils.getUUID());
        dailyprice.setCreatetime(new Date());
        dailyprice.setIsdel(WebConstants.NO);
        dailypriceMapper.insertSelective(dailyprice);
        resultVo.setData(dailyprice);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "修改每日价格",description = "修改每日价格")
    public ResultVo<Dailyprice> updateDailyprice(Dailyprice dailyprice) {
        ResultVo<Dailyprice> resultVo = new ResultVo<Dailyprice>();
        //验证数据是否已经存在
        DailypriceVo vo = new DailypriceVo();
        vo.setBaseelementid(dailyprice.getBaseelementid());
        vo.setInputtime(dailyprice.getInputtime());
        List<Dailyprice> vilist = dailypriceMapper.queryTodayPrice(vo);
        if(vilist!=null&&vilist.size()>0){
            resultVo.setState(ResultVo.FAILED);
            resultVo.setMessage("价格已录入！");
            return resultVo;
        }
        dailyprice.setUpdatetime(new Date());
        int resultNum = dailypriceMapper.updateByPrimaryKeySelective(dailyprice);
        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除每日价格",description = "删除每日价格")
    public ResultVo<Dailyprice> deleteDailypriceForUpdate(String id) {
        ResultVo<Dailyprice> resultVo = new ResultVo<Dailyprice>();
        Dailyprice dailyprice = dailypriceMapper.selectByPrimaryKey(id);
        dailyprice.setUpdatetime(new Date());
        dailyprice.setIsdel(WebConstants.YES);
        int resultNum = dailypriceMapper.updateByPrimaryKeySelective(dailyprice);
        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<Dailyprice> deleteDailypriceForUpdate(String[] ids) {
        ResultVo<Dailyprice> resultVo = new ResultVo<Dailyprice>();
        for(String id : ids){
            Dailyprice dailyprice = dailypriceMapper.selectByPrimaryKey(id);
            dailyprice.setIsdel(WebConstants.YES);
            dailypriceMapper.updateByPrimaryKeySelective(dailyprice);
        }
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<Dailyprice> deleteDailypriceForDelete(String id) {
        ResultVo<Dailyprice> resultVo = new ResultVo<Dailyprice>();
        int resultNum = dailypriceMapper.deleteByPrimaryKey(id);
        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<Dailyprice> deleteDailypriceForDelete(String[] ids) {
        ResultVo<Dailyprice> resultVo = new ResultVo<Dailyprice>();
        for(String id : ids){
            dailypriceMapper.deleteByPrimaryKey(id);
        }
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public PageBean<DailypriceVo> queryDailyprice(DailypriceVo dailypriceVo, PageBean pageBean) {
        PageBean<DailypriceVo> resultPageBean = new PageBean<DailypriceVo>();
        dailypriceVo.setPage(pageBean.getStartRowNum());
        dailypriceVo.setLimit(pageBean.getEndRowNum());
        dailypriceVo.setIsdel(WebConstants.NO);
        List<DailypriceVo> resultList = dailypriceMapper.selectVoBySelective(dailypriceVo);
        int count = dailypriceMapper.selectVoCountBySelective(dailypriceVo);
        resultPageBean.setRows(resultList);
        resultPageBean.setTotal(count);
        resultPageBean.setResultCode(WebConstants.layuiRequestCode);
        return resultPageBean;
    }

    @Override
    public ResultVo<Dailyprice> queryDailyprice(String id) {
        ResultVo<Dailyprice> resultVo = new ResultVo<Dailyprice>();
        Dailyprice vo = dailypriceMapper.selectByPrimaryKey(id);
        resultVo.setData(vo);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<DailypriceVo> queryDailyprice(DailypriceVo dailypriceVo) {
        ResultVo<DailypriceVo> resultVo = new ResultVo<DailypriceVo>();
        List<DailypriceVo> resultList = dailypriceMapper.selectVoBySelective(dailypriceVo);
        resultVo.setDataList(resultList);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }
}
