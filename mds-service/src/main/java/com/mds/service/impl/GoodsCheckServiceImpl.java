package com.mds.service.impl;

import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.DailypriceMapper;
import com.mds.dao.EmentidcontentinfoMapper;
import com.mds.dao.GoodsdetailsinfoMapper;
import com.mds.entity.Ementidcontentinfo;
import com.mds.entity.Goodsdetailsinfo;
import com.mds.service.GoodsCheckService;
import com.mds.service.GoodsDetailService;
import com.mds.utils.DateUtil;
import com.mds.utils.UUIDUtils;
import com.mds.vo.DailypriceVo;
import com.mds.vo.GoodsdetailsinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 2018/3/27.
 */
@Transactional
@Service
public class GoodsCheckServiceImpl implements GoodsCheckService {
    @Autowired
    GoodsdetailsinfoMapper detailsinfoMapper;

    @Autowired
    EmentidcontentinfoMapper checkMapper;

    @Autowired
    DailypriceMapper dailypriceMapper;

    @Override
    public ResultVo saveGoodsCheck(GoodsdetailsinfoVo goodsdetailsinfoVo) {
        ResultVo vo = null;
        try{
            Goodsdetailsinfo detailinfo = detailsinfoMapper.selectByPrimaryKey(goodsdetailsinfoVo.getId());
            if(detailinfo!=null){
                detailinfo.setIscheck(1);
                detailinfo.setCarriershape(goodsdetailsinfoVo.getCarriershape());
                detailinfo.setHoneycombshape(goodsdetailsinfoVo.getHoneycombshape());
                detailinfo.setNetweight(goodsdetailsinfoVo.getNetweight());
                detailinfo.setCheckremark(goodsdetailsinfoVo.getCheckremark());
                //修改detail中的检测信息
                detailsinfoMapper.updateByPrimaryKeySelective(detailinfo);
                //先删除之前的信息
                checkMapper.deleteEmentCheckInfo(detailinfo.getId());
                //新增检测信息
                if(goodsdetailsinfoVo.getElname()!=null &&
                        goodsdetailsinfoVo.getElname().length>0){
                    for(int i=0;i<goodsdetailsinfoVo.getElname().length;i++){
                        String ement = goodsdetailsinfoVo.getElname()[i];
                        Ementidcontentinfo ementCheck = new Ementidcontentinfo();
                        ementCheck.setId(UUIDUtils.getUUID());
                        ementCheck.setBaseelementid(ement);
                        ementCheck.setGoodsdetailid(goodsdetailsinfoVo.getId());
                        if(goodsdetailsinfoVo.getElcontent()!=null &&
                                goodsdetailsinfoVo.getElcontent().length>i){
                            String elcontent = goodsdetailsinfoVo.getElcontent()[i];
                            ementCheck.setContent(elcontent);
                            double todayprice = getTodayPrice(ement);
                            //当日价格没有录入
                            if(todayprice>0){
                                //实际价格
                                double realprice = todayprice * Double.valueOf(elcontent);
                                //参考价格
                                double reprice = 0.8 * todayprice * Double.valueOf(elcontent);
                            }else{

                            }
                        }
                        ementCheck.setCreatetime(new Date());
                        ementCheck.setIsdel(WebConstants.NO);

                        checkMapper.insert(ementCheck);
                    }

                }
            }else{
                return new ResultVo(ResultVo.FAILED,ResultVo.FAILED_MESSAGE);
            }

            vo = new ResultVo(ResultVo.SUCCESS,ResultVo.SUCCESS_MESSAGE);
        }catch(Exception e){
            e.printStackTrace();
            vo = new ResultVo(ResultVo.FAILED,ResultVo.FAILED_MESSAGE);
        }

        return vo;
    }


    /**
     * 根据元素id获得当日价格
     * @param baseelementid
     * @return
     * @throws Exception
     */
    public double getTodayPrice(String baseelementid) throws Exception{
        DailypriceVo vo = new DailypriceVo();
        vo.setId(baseelementid);
        vo.setInputtime(DateUtil.getDay());
        List<DailypriceVo> pricelist = dailypriceMapper.selectBySelective(vo);
        if(pricelist.size()>0){
            return pricelist.get(0).getDailyprice();
        }
        return -1;
    }
}
