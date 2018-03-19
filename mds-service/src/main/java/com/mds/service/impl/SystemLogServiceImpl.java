package com.mds.service.impl;

import com.mds.common.ResultVo;
import com.mds.dao.SystemLogDao;
import com.mds.entity.SystemLog;
import com.mds.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/7
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(propagation= Propagation.REQUIRED)
public class SystemLogServiceImpl implements SystemLogService{
    @Autowired
    private SystemLogDao systemLogDao;
    @Override
    public ResultVo<SystemLog> addSystemLog(SystemLog systemLog) {
        ResultVo<SystemLog> resultVo = new ResultVo<SystemLog>();
        systemLogDao.saveSystemLog(systemLog);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }
}
