package com.mds.service.impl;

import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.ConfigMapper;
import com.mds.dao.DailypriceMapper;
import com.mds.dao.EmentidcontentinfoMapper;
import com.mds.dao.GoodsdetailsinfoMapper;
import com.mds.entity.Config;
import com.mds.entity.Dailyprice;
import com.mds.entity.Ementidcontentinfo;
import com.mds.entity.Goodsdetailsinfo;
import com.mds.service.GoodsCheckService;
import com.mds.utils.DateUtil;
import com.mds.utils.UUIDUtils;
import com.mds.vo.DailypriceVo;
import com.mds.vo.EmentidcontentinfoVo;
import com.mds.vo.GoodsdetailsinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    @Autowired
    ConfigMapper configMapper;

    @Override
    public ResultVo saveGoodsCheck(GoodsdetailsinfoVo goodsdetailsinfoVo) {
        ResultVo vo = null;
        try{
            Goodsdetailsinfo detailinfo = detailsinfoMapper.selectByPrimaryKey(goodsdetailsinfoVo.getId());
            if(detailinfo!=null){
                //先删除之前的信息
                checkMapper.deleteEmentCheckInfo(detailinfo.getId());
                //新增检测信息
                if(goodsdetailsinfoVo.getElname()!=null &&
                        goodsdetailsinfoVo.getElname().length>0){
                    /**查询当日维护的价格，会有多条，以最新的为准**/
                    DailypriceVo o = new DailypriceVo();
                    o.setInputtime(DateUtil.getDay());
                    List<Dailyprice> dailyprice = dailypriceMapper.queryTodayPrice(o);
                    if(dailyprice == null || dailyprice.size() == 0){
                        throw new Exception("元素当日价格未维护，请先维护价格");
                    }
                    Dailyprice daily = dailyprice.get(0);
                    for(int i=0;i<goodsdetailsinfoVo.getElname().length;i++){
                        String ement = goodsdetailsinfoVo.getElname()[i];
                        Ementidcontentinfo ementCheck = new Ementidcontentinfo();
                        ementCheck.setSort(i);
                        ementCheck.setId(UUIDUtils.getUUID());
                        ementCheck.setBaseelementid(ement);
                        ementCheck.setGoodsdetailid(goodsdetailsinfoVo.getId());
                        if(goodsdetailsinfoVo.getElcontent()!=null &&
                                goodsdetailsinfoVo.getElcontent().length>i){
                            String elcontent = goodsdetailsinfoVo.getElcontent()[i];
                            ementCheck.setContent(elcontent);
                            //获得元素当日价格
                            Double todayprice = null;
                            if("01".equals(ement)){//钯
                                todayprice = daily.getBa_dailyprice();
                            }else if("02".equals(ement)){//铂
                                todayprice = daily.getDailyprice();
                            }else if("03".equals(ement)){//铑
                                todayprice = daily.getLao_dailyprice();
                            }
                            //获得折扣率
                            Double zkrate = getZkRate();

                            //当日价格没有录入
                            if(todayprice == null){
                                throw new Exception("元素当日价格未维护，请先维护价格");
                            }
                            if(zkrate == null){
                                throw new Exception("折扣率未维护，请先维护折扣率");
                            }
                            //算出物品的ppm
                            Double unit = Double.valueOf(goodsdetailsinfoVo.getNetweight()) / 1000000;
                            //实际价格
                            BigDecimal realprice = new BigDecimal(todayprice * Double.valueOf(elcontent) * unit).setScale(2,BigDecimal.ROUND_HALF_UP);
                            //参考价格
                            BigDecimal reprice = new BigDecimal(String.valueOf(zkrate)).multiply(realprice).setScale(2,BigDecimal.ROUND_HALF_UP);

                            ementCheck.setDailyprice(todayprice);
                            ementCheck.setZkrate(zkrate);
                            ementCheck.setRealprice(realprice.doubleValue());
                            ementCheck.setReprice(reprice.doubleValue());
                        }
                        ementCheck.setCreatetime(new Date());
                        ementCheck.setIsdel(WebConstants.NO);

                        checkMapper.insert(ementCheck);
                    }

                }

                //保存检测填写的详细信息
                detailinfo.setIscheck(1);
                detailinfo.setCarriershape(goodsdetailsinfoVo.getCarriershape());
                detailinfo.setHoneycombshape(goodsdetailsinfoVo.getHoneycombshape());
                detailinfo.setNetweight(goodsdetailsinfoVo.getNetweight());
                detailinfo.setCheckremark(goodsdetailsinfoVo.getCheckremark());
                //修改detail中的检测信息
                detailsinfoMapper.updateByPrimaryKeySelective(detailinfo);

            }else{
                return new ResultVo(ResultVo.FAILED,ResultVo.FAILED_MESSAGE);
            }

            vo = new ResultVo(ResultVo.SUCCESS,ResultVo.SUCCESS_MESSAGE);
        }catch(Exception e){
            e.printStackTrace();
            vo = new ResultVo(ResultVo.FAILED,e.getMessage());
        }

        return vo;
    }


    /**
     * 根据元素id获得当日价格
     * @param baseelementid
     * @return
     * @throws Exception
     */
    public Double getTodayPrice(String baseelementid) throws Exception{
        DailypriceVo vo = new DailypriceVo();
        vo.setBaseelementid(baseelementid);
        vo.setInputtime(DateUtil.getDay());
        List<Dailyprice> pricelist = dailypriceMapper.queryTodayPrice(vo);
        if(pricelist.size()>0){
            return pricelist.get(0).getDailyprice();
        }
        return null;
    }

    /**
     * 获得折扣率
     * @return
     * @throws Exception
     */
    public Double getZkRate()throws Exception{

        Config config = new Config();
        List<Config> configList = configMapper.selectBySelective(config);
        if(configList.size() > 0){
            return Double.valueOf(configList.get(0).getDiscount());
        }
        return null;
    }

    @Override
    public List<EmentidcontentinfoVo> getCheckInfoByDetailid(String detailid) {
        return checkMapper.getCheckInfoByDetailid(detailid);
    }
}
