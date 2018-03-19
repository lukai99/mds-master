package com.mds.service.impl;

import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.SharesDao;
import com.mds.dao.SharesGameRecordMapper;
import com.mds.dao.SharesHistoryDataMapper;
import com.mds.entity.Shares;
import com.mds.entity.SharesGameRecord;
import com.mds.entity.SharesHistoryData;
import com.mds.entity.User;
import com.mds.service.SharesService;
import com.mds.utils.DateUtil;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import com.mds.vo.SharesGameRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-15
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SharesServiceImpl implements SharesService {


    @Autowired
    private SharesDao sharesDao;
    @Autowired
    private SharesGameRecordMapper sharesGameRecordMapper;
    @Autowired
    private SharesHistoryDataMapper sharesHistoryDataMapper;

    @Override
    public List<Shares> querySharesList() {
        return sharesDao.querySharesList();
    }

    @Override
    public PageBean<Shares> querySharesListForPage(Shares shares, PageBean<Shares> pageBean) {
        List<Shares> sharesList = sharesDao.querySharesListForPage(shares,pageBean.getPage(),pageBean.getLimit());
       // int count = sharesDao.querySharesCountForPage(shares,pageBean.getPageNum(),pageBean.getPageSize());
        pageBean.setTotal(2);
        pageBean.setRows(sharesList);
        return pageBean;
    }

    @Override
    public Shares getShares(Integer id) {
        return sharesDao.getShares(id);
    }

    @Override
    public Shares getShares(String code) {
        return sharesDao.getShares(code);
    }

    @Override
    public PageBean<SharesGameRecordVo> getSharesDealSimulationList(SharesGameRecordVo sharesGameRecordVo) {
        PageBean<SharesGameRecordVo> pageBean = new PageBean<SharesGameRecordVo>();
        List<SharesGameRecordVo> resultList = sharesGameRecordMapper.selectBySelective(sharesGameRecordVo);
        int count = sharesGameRecordMapper.selectCountBySelective(sharesGameRecordVo);
        pageBean.setTotal(count);
        pageBean.setRows(resultList);
        pageBean.setResultCode(WebConstants.HTTPSTATE_SUCCESS);
        return pageBean;
    }

    @Override
    @Transactional
    public ResultVo generatorSharesDealGame(HttpServletRequest request, HttpSession session){
        ResultVo resultVo = new ResultVo();
        //获取用户id
        //随机获取股票
        //获取随机开始点
        //设置初始资金 默认10000
        User user = (User) session.getAttribute(WebConstants.CURRENT_USER);//获得登录用户信息
        Shares shares = sharesDao.getRandShares();//随机获得股票数据
        SharesHistoryData queryHistoryData = new SharesHistoryData();
        queryHistoryData.setSharesId(shares.getId());
        SharesHistoryData sharesHistoryData = sharesHistoryDataMapper.getRandStartData(queryHistoryData);//获取随机开始点
        if(sharesHistoryData==null){
            resultVo.setState(ResultVo.FAILED);
            resultVo.setMessage("获取随机开始点异常");
            return resultVo;
        }
        SharesGameRecord sharesGameRecord = new SharesGameRecord();
        sharesGameRecord.setUserid(user.getId());
        sharesGameRecord.setSharesid(shares.getId());
        sharesGameRecord.setStartrecordid(sharesHistoryData.getId());
        sharesGameRecord.setId(UUIDUtils.getUUID());
        sharesGameRecord.setInitmoney(10000D);
        sharesGameRecord.setCurrentmoney(10000D);
        sharesGameRecord.setFrequency("5");
        sharesGameRecord.setGamecode(DateUtil.formatDate2Str(new Date(),"yyyyMMddHHmmss"));
        sharesGameRecord.setOffsetnum(0L);
        sharesGameRecord.setGamestate(WebConstants.GP.DOING);
        sharesGameRecord.setCreatetime(new Date());

        sharesGameRecordMapper.insertSelective(sharesGameRecord);

        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }
}
