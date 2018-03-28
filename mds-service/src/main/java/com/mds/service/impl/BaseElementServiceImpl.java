package com.mds.service.impl;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.BaseelementMapper;
import com.mds.entity.Baseelement;
import com.mds.service.BaseElementService;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import com.mds.vo.BaseElementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BaseElementServiceImpl implements BaseElementService{

    @Autowired
    private BaseelementMapper baseelementMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "添加元素基本信息",description = "添加元素基本信息")
    public ResultVo<Baseelement> addBaseElement(Baseelement baseelement) {
        ResultVo<Baseelement> resultVo = new ResultVo<Baseelement>();
        baseelement.setId(UUIDUtils.getUUID());
        baseelement.setCreatetime(new Date());
        baseelement.setIsdel(WebConstants.NO);
        baseelementMapper.insert(baseelement);
        resultVo.setData(baseelement);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "修改元素基本信息",description = "修改元素基本信息")
    public ResultVo<Baseelement> updateBaseElement(Baseelement baseelement) {
        ResultVo<Baseelement> resultVo = new ResultVo<Baseelement>();
        baseelement.setUpdatetime(new Date());
        int resultNum = baseelementMapper.updateByPrimaryKeySelective(baseelement);
        resultVo.setData(resultNum);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除元素基本信息（逻辑）",description = "删除元素基本信息（逻辑）")
    public ResultVo<Baseelement> deleteBaseElementForUpdate(Baseelement baseelement) {
        ResultVo<Baseelement> resultVo = new ResultVo<Baseelement>();
        baseelement.setUpdatetime(new Date());
        baseelement.setIsdel(WebConstants.YES);
        int  resultNum = baseelementMapper.updateByPrimaryKeySelective(baseelement);
        resultVo.setData(resultNum);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除元素基本信息（物理）",description = "删除元素基本信息（物理）")
    public ResultVo<Baseelement> deleteBaseElement(String id) {
        ResultVo<Baseelement> resultVo = new ResultVo<Baseelement>();
        int resultNum = baseelementMapper.deleteByPrimaryKey(id);
        resultVo.setData(resultNum);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public PageBean<BaseElementVo> queryBaseElementInfo(BaseElementVo baseElementVo, PageBean pageBean) {
        PageBean<BaseElementVo> resultPageBean = new PageBean<BaseElementVo>();
        baseElementVo.setPage(pageBean.getStartRowNum());
        baseElementVo.setLimit(pageBean.getEndRowNum());
        baseElementVo.setIsdel(WebConstants.NO);
        List<BaseElementVo> resultList = baseelementMapper.selectBySelective(baseElementVo);
        int rowCount = baseelementMapper.selectCountBySelective(baseElementVo);
        resultPageBean.setRows(resultList);
        resultPageBean.setTotal(rowCount);
        resultPageBean.setResultCode(WebConstants.layuiRequestCode);
        return resultPageBean;
    }

    @Override
    public ResultVo<Baseelement> queryBaseElementInfo(String id) {
        ResultVo<Baseelement> resultVo = new ResultVo<Baseelement>();
        Baseelement baseelement = baseelementMapper.selectByPrimaryKey(id);
        resultVo.setData(baseelement);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<BaseElementVo> queryBaseElementInfo(BaseElementVo baseElementVo) {
        ResultVo<BaseElementVo> resultVo = new ResultVo<BaseElementVo>();
        List<BaseElementVo> baseElementVoList = baseelementMapper.selectBySelective(baseElementVo);
        resultVo.setDataList(baseElementVoList);
        resultVo.setState(resultVo.SUCCESS);
        resultVo.setMessage(resultVo.SUCCESS_MESSAGE);
        return resultVo;
    }
}
