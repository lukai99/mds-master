package com.mds.service.impl;

import com.mds.common.ResultVo;
import com.mds.dao.SharePortraitDao;
import com.mds.entity.SharePortrait;
import com.mds.entity.Shares;
import com.mds.service.SharePortraitService;
import com.mds.service.SharesService;
import com.mds.vo.BasicLineChartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-10-16
 * Time: 下午10:58
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SharePortraitServiceImpl implements SharePortraitService {
    @Autowired
    private SharePortraitDao sharePortraitDao;
    @Autowired
    private SharesService sharesService;
    @Override
    public Integer saveSharePortrait(SharePortrait sharePortrait) {
        return sharePortraitDao.saveSharePortrait(sharePortrait);
    }

    @Override
    public Integer updateSharePortrait(SharePortrait sharePortrait) {
        return null;
    }

    @Override
    public List<SharePortrait> querySharePortraitList(String shareCode) {
        SharePortrait sharePortrait = new SharePortrait();
        sharePortrait.setSharesCode(shareCode);
        return querySharePortraitList(sharePortrait);
    }

    @Override
    public List<SharePortrait> querySharePortraitList(SharePortrait sharePortrait) {
        return sharePortraitDao.querySharePortraitList(sharePortrait);
    }

    @Override
    public ResultVo getSharePortrait(Integer id) {
        ResultVo<BasicLineChartVo> resultVo = new ResultVo<BasicLineChartVo>(ResultVo.SUCCESS,ResultVo.SUCCESS_MESSAGE);
        try{
            //查询股票信息
            Shares shares = sharesService.getShares(id);
            String shareCode = shares.getCode();

            SharePortrait portrait = new SharePortrait();
            portrait.setSharesCode(shareCode);
            List<SharePortrait> sharePortraitList = sharePortraitDao.querySharePortraitList(portrait);
            //resultVo.setDataList(sharePortraitList);
            resultVo.setDataList(buildChartData(sharePortraitList));
        }catch (Exception e){
            e.printStackTrace();
            resultVo.setState(ResultVo.FAILED);
            resultVo.setMessage(ResultVo.FAILED_MESSAGE);
        }
        return resultVo;
    }

    /**
     *
     * @param sharePortraitList
     * @return
     */
    public List<BasicLineChartVo> buildChartData(List<SharePortrait> sharePortraitList){
        List<BasicLineChartVo> voList = null;
        BasicLineChartVo vo = null;
        if(sharePortraitList!=null&&sharePortraitList.size()>0){
            voList = new ArrayList<BasicLineChartVo>(sharePortraitList.size());
            vo = new BasicLineChartVo();
            vo.setName("");
            vo.setColor("#1f7e92");
            vo.setLine_width(BasicLineChartVo.width3);
            String val[] = new String[sharePortraitList.size()];
            vo.setValue(val);
            for(int i=0;i<sharePortraitList.size();i++){
                val[i] = String.valueOf(sharePortraitList.get(i).getPrice());
            }
            voList.add(vo);
        }
        return voList;
    }
}
