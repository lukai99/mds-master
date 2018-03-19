package com.mds.service.impl;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.DictionaryMapper;
import com.mds.entity.Dictionary;
import com.mds.service.DictionaryService;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/28
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "添加字典项",description = "添加字典项")
    public ResultVo<Dictionary> addDictionary(Dictionary dictionary) {
        ResultVo<Dictionary> resultVo = new ResultVo<Dictionary>();
        dictionary.setId(UUIDUtils.getUUID());
        dictionary.setCreatetime(new Date());
        dictionaryMapper.insertSelective(dictionary);
        resultVo.setData(dictionary);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "修改字典项",description = "修改字典项")
    public ResultVo<Dictionary> updateDictionary(Dictionary dictionary) {
        ResultVo<Dictionary> resultVo = new ResultVo<Dictionary>();
        if(dictionary.getState()==null){
            dictionary.setState("0");
        }
        dictionary.setUpdatetime(new Date());
        int resultNum = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除字典项（逻辑删除）",description = "删除字典项（逻辑删除）")
    public ResultVo<Dictionary> deleteDictionaryByUpdate(String[] dictionaryIds) {
        ResultVo<Dictionary> resultVo = new ResultVo<Dictionary>();
        for(String id : dictionaryIds){
            Dictionary dictionaryObj = dictionaryMapper.selectByPrimaryKey(id);
            dictionaryObj.setIsdel(WebConstants.YES);
            dictionaryMapper.updateByPrimaryKeySelective(dictionaryObj);
        }
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除字典项（物理删除）",description = "删除字典项（物理删除）")
    public ResultVo<Dictionary> deleteDictionaryByDelete(String[] dictionaryIds) {
        ResultVo<Dictionary> resultVo = new ResultVo<Dictionary>();
        for(String id : dictionaryIds){
            dictionaryMapper.deleteByPrimaryKey(id);
        }
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @SystemServiceLog(module = "mds",option = "获取字典项数据",description = "获取全部子字典项数据 根据父级菜单id")
    public ResultVo<Dictionary> getChildDictionary(String parentId) {
        ResultVo<Dictionary> resultVo = new ResultVo<Dictionary>();
        Dictionary queryDictionart = new Dictionary();
        queryDictionart.setParentid(parentId);
        List<Dictionary> resultList = dictionaryMapper.selectBySelective(queryDictionart);
        resultVo.setData(resultList);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @SystemServiceLog(module = "mds",option = "获取字典项数据",description = "获取字典项数据 根据传入的实体参数")
    public ResultVo<Dictionary> queryDictionary(Dictionary dictionary) {
        ResultVo<Dictionary> resultVo = new ResultVo<Dictionary>();
        resultVo.setData(dictionary);
        dictionaryMapper.selectBySelective(dictionary);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @SystemServiceLog(module = "mds",option = "获取字典项",description = "获取字典项根据数据id")
    public ResultVo<Dictionary> getDictionary(String dictionaryId) {
        ResultVo<Dictionary> resultVo = new ResultVo<Dictionary>();
        Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(dictionaryId);
        resultVo.setData(dictionary);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public PageBean<Dictionary> queryDictionary(Dictionary dictionary, PageBean pageBean) {
        PageBean<Dictionary> resultPageBean = new PageBean<Dictionary>();
        dictionary.setPage(pageBean.getStartRowNum());
        dictionary.setLimit(pageBean.getEndRowNum());
        dictionary.setIsdel(WebConstants.NO);
        List<Dictionary> resultList = dictionaryMapper.selectBySelective(dictionary);
        int count = dictionaryMapper.selectCountBySelective(dictionary);
        resultPageBean.setRows(resultList);
        resultPageBean.setTotal(count);
        resultPageBean.setResultCode(0);
        return resultPageBean;
    }
}
