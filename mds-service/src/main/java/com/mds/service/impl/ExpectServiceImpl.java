package com.mds.service.impl;

import com.mds.common.ResultVo;
import com.mds.dao.ExpectDao;
import com.mds.entity.Expect;
import com.mds.service.ExpectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-19
 * Time: 下午12:48
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ExpectServiceImpl implements ExpectService {
    @Autowired
    private ExpectDao expectDao;
    @Override
    public List<Expect> queryExpectList() {
        return expectDao.queryExpectList();
    }

    @Override
    public List<Expect> queryExpectList(Expect expect) {
        return expectDao.queryExpectList(expect);
    }

    @Override
    public List<Expect> queryExpectList(String sharesCode) {
        Expect expect = new Expect();
        expect.setSharesCode(sharesCode);
        return expectDao.queryExpectList(expect);
    }

    @Override
    public Expect getExpect(Integer id) {
        return expectDao.getExpect(id);
    }

    @Override
    public ResultVo saveExpect(Expect expect) {
        ResultVo resultVo = new ResultVo(ResultVo.SUCCESS,ResultVo.SUCCESS_MESSAGE);
        Integer dataId = expectDao.saveExpect(expect);
        if(dataId==null&&dataId.equals(0)){
            resultVo.setState(ResultVo.FAILED);
            resultVo.setMessage(ResultVo.FAILED_MESSAGE);
        }
        return resultVo;
    }

    @Override
    public Integer updateExpect(Expect expect) {
        return null;
    }

    @Override
    public Integer deleteExpect(Integer id) {
        return null;
    }

    @Override
    public ResultVo createExpectPrice(Expect expect) {
        ResultVo resultVo = new ResultVo(ResultVo.SUCCESS,ResultVo.SUCCESS_MESSAGE);
        Double highPrice = expect.getHighPrice();
        Double lowPrice = expect.getLowPrice();
        Double expectPrice = (highPrice -  lowPrice)/2 + lowPrice;
        Double stopPrice = expectPrice - (expectPrice*0.03);
        expect.setExpectPrice(expectPrice);
        expect.setStopPrice(stopPrice);
        resultVo.setData(expect);
        return resultVo;
    }
}
