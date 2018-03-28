package com.mds.service.impl;

import com.mds.common.ResultVo;
import com.mds.dao.ConfigMapper;
import com.mds.entity.Config;
import com.mds.service.ConfigService;
import com.mds.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/3/28
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ConfigServiceImpl implements ConfigService{
    @Autowired
    public ConfigMapper configMapper;
    @Override
    public ResultVo<Config> addConfig(Config config) {
        ResultVo<Config> resultVo = new ResultVo<Config>();
        config.setId(UUIDUtils.getUUID());
        configMapper.insertSelective(config);
        resultVo.setData(config);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<Config> updateConfig(Config config) {
        ResultVo<Config> resultVo = new ResultVo<Config>();
        configMapper.updateByPrimaryKeySelective(config);
        resultVo.setData(config);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<Config> queryConfigInfo(String id) {
        ResultVo<Config> resultVo = new ResultVo<Config>();
        Config config = configMapper.selectByPrimaryKey(id);
        resultVo.setData(config);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<Config> queryConfigInfo(Config config) {
        ResultVo<Config> resultVo = new ResultVo<Config>();
        List<Config> configList = configMapper.selectBySelective(config);
        if(configList!=null&&configList.size()==1){
            resultVo.setData(configList.get(0));
            resultVo.setState(ResultVo.SUCCESS);
            resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        }else{
            try {
                throw new Exception("查询数据不符合预期");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultVo;
    }

}
