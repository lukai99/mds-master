package com.mds.service.impl;

import com.mds.annotation.SystemServiceLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.dao.EmentidcontentinfoMapper;
import com.mds.dao.FileinfoMapper;
import com.mds.dao.GoodsdetailsinfoMapper;
import com.mds.dao.GoodsinfoMapper;
import com.mds.entity.Ementidcontentinfo;
import com.mds.entity.Fileinfo;
import com.mds.entity.Goodsdetailsinfo;
import com.mds.entity.Goodsinfo;
import com.mds.service.GoodsDetailService;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import com.mds.vo.EmentidcontentinfoVo;
import com.mds.vo.GoodsdetailsinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 2018/3/27.
 */
@Service
public class GoodsDetailServiceImpl implements GoodsDetailService {
    @Autowired
    GoodsdetailsinfoMapper detailsinfoMapper;
    @Autowired
    GoodsinfoMapper goodsinfoMapper;
    @Autowired
    FileinfoMapper fileinfoMapper;
    @Autowired
    EmentidcontentinfoMapper ementidcontentinfoMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "添加物品信息详情",description = "添加物品信息详情")
    public ResultVo<Goodsdetailsinfo> saveGoodsDetail(GoodsdetailsinfoVo detailsinfo) {
        ResultVo<Goodsdetailsinfo> resultVo = new ResultVo<Goodsdetailsinfo>();
        detailsinfo.setId(UUIDUtils.getUUID());
        detailsinfo.setCreatetime(new Date());
        detailsinfo.setIsdel(WebConstants.NO);
        detailsinfoMapper.insertSelective(detailsinfo);
        //保存上传文件信息
        saveFile(detailsinfo);

        resultVo.setData(detailsinfo);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "修改物品信息详情",description = "修改物品信息详情")
    public ResultVo<Goodsdetailsinfo> updateGoodsDetail(GoodsdetailsinfoVo detailsinfo) {
        ResultVo<Goodsdetailsinfo> resultVo = new ResultVo<Goodsdetailsinfo>();
        detailsinfo.setUpdatetime(new Date());
        int resultNum = detailsinfoMapper.updateByPrimaryKeySelective(detailsinfo);
        //保存上传文件信息
        saveFile(detailsinfo);

        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除物品信息详情（逻辑删除）",description = "删除物品信息详情（逻辑删除）根据数据主键")
    public ResultVo<Goodsdetailsinfo> deleteGoodsDetailForUpdate(String id) {
        ResultVo<Goodsdetailsinfo> resultVo = new ResultVo<Goodsdetailsinfo>();
        Goodsdetailsinfo detailsinfo = detailsinfoMapper.selectByPrimaryKey(id);
        detailsinfo.setUpdatetime(new Date());
        detailsinfo.setIsdel(WebConstants.YES);
        int resultNum = detailsinfoMapper.updateByPrimaryKeySelective(detailsinfo);
        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除物品信息详情（逻辑删除）",description = "删除物品信息详情（逻辑删除）根据数据主键")
    public ResultVo<Goodsdetailsinfo> deleteGoodsDetailForUpdate(String[] ids) {
        ResultVo<Goodsdetailsinfo> resultVo = new ResultVo<Goodsdetailsinfo>();
        for(String id : ids){
            Goodsdetailsinfo goodsdetailObj = detailsinfoMapper.selectByPrimaryKey(id);
            goodsdetailObj.setIsdel(WebConstants.YES);
            detailsinfoMapper.updateByPrimaryKeySelective(goodsdetailObj);
        }
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除物品信息详情（物理删除）",description = "删除物品信息详情（物理删除）根据数据主键")
    public ResultVo<Goodsdetailsinfo> deleteGoodsDetailForDelete(String id) {
        ResultVo<Goodsdetailsinfo> resultVo = new ResultVo<Goodsdetailsinfo>();
        int resultNum = detailsinfoMapper.deleteByPrimaryKey(id);
        resultVo.setData(resultNum);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "删除物品信息详情（物理删除）",description = "删除物品信息详情（物理删除）")
    public ResultVo<Goodsdetailsinfo> deleteGoodsDetailForDelete(String[] ids) {
        ResultVo<Goodsdetailsinfo> resultVo = new ResultVo<Goodsdetailsinfo>();
        for(String id : ids){
            detailsinfoMapper.deleteByPrimaryKey(id);
        }
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public PageBean<GoodsdetailsinfoVo> queryGoodsDetail(GoodsdetailsinfoVo goodsdetailVo, PageBean pageBean) {
//        PageBean<GoodsdetailsinfoVo> resultPageBean = new PageBean<GoodsdetailsinfoVo>();
        goodsdetailVo.setPage(pageBean.getStartRowNum());
        goodsdetailVo.setLimit(pageBean.getEndRowNum());
        goodsdetailVo.setIsdel(WebConstants.NO);
        List<GoodsdetailsinfoVo> resultList = detailsinfoMapper.listGoodsDetail(goodsdetailVo);
        int count = detailsinfoMapper.countGoodsDetail(goodsdetailVo);
        pageBean.setRows(resultList);
        pageBean.setTotal(count);
        pageBean.setResultCode(WebConstants.layuiRequestCode);
        return pageBean;
    }

    @Override
    public ResultVo<GoodsdetailsinfoVo> queryGoodsDetail(String id) {
        ResultVo<GoodsdetailsinfoVo> resultVo = new ResultVo<GoodsdetailsinfoVo>();
        Goodsdetailsinfo goodsdetailsinfo = detailsinfoMapper.selectByPrimaryKey(id);
        resultVo.setData(goodsdetailsinfo);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Override
    public ResultVo<GoodsdetailsinfoVo> queryGoodsDetail(GoodsdetailsinfoVo goodsdetailVo) {
        ResultVo<GoodsdetailsinfoVo> resultVo = new ResultVo<GoodsdetailsinfoVo>();
        List<GoodsdetailsinfoVo> resultList = detailsinfoMapper.selectBySelective(goodsdetailVo);
        resultVo.setDataList(resultList);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        resultVo.setState(ResultVo.SUCCESS);
        return resultVo;
    }

    @Override
    public List<GoodsdetailsinfoVo> getUnCheckList() {
        GoodsdetailsinfoVo vo = new GoodsdetailsinfoVo();
        vo.setIscheck(0);
        List<GoodsdetailsinfoVo> detailsinfovo = detailsinfoMapper.listGoodsDetail(vo);
        return detailsinfovo;
    }

    @Override
    public ResultVo<GoodsdetailsinfoVo> queryGoodsDetailForPrice(String id) {
        ResultVo<GoodsdetailsinfoVo> resultVo = new ResultVo<GoodsdetailsinfoVo>();
        Goodsdetailsinfo goodsdetailsinfo = detailsinfoMapper.selectByPrimaryKey(id);
        //计算总参考价格
        List<EmentidcontentinfoVo> ementidcontentinfoList = ementidcontentinfoMapper.getCheckInfoByDetailid(goodsdetailsinfo.getId());
        Double totalPrice = new Double(0);
        for(EmentidcontentinfoVo vo:ementidcontentinfoList){
            totalPrice += vo.getRealprice();
        }
        //获得物品名称
        Goodsinfo goodsinfo = goodsinfoMapper.selectByPrimaryKey(goodsdetailsinfo.getGoodsinfoid());

        //返回结果
        GoodsdetailsinfoVo goodsdetailsinfoVo = new GoodsdetailsinfoVo();
        goodsdetailsinfoVo.setTotalreprice(totalPrice+"");
        goodsdetailsinfoVo.setSyscode(goodsdetailsinfo.getSyscode());
        goodsdetailsinfoVo.setGoodsname(goodsinfo.getGoodsname());
        resultVo.setData(goodsdetailsinfoVo);
        resultVo.setState(ResultVo.SUCCESS);
        resultVo.setMessage(ResultVo.SUCCESS_MESSAGE);
        return resultVo;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    @SystemServiceLog(module = "mds",option = "上传文件",description = "上传文件")
    public void saveFile(GoodsdetailsinfoVo goodsdetailVo){
        Fileinfo file = new Fileinfo();
        file.setDetailinfo(goodsdetailVo.getId());
        file.setIsdel(WebConstants.YES);
        fileinfoMapper.updateByDetailId(file);

        if(goodsdetailVo.getRealnames()!=null && goodsdetailVo.getRealnames().length>0){
            for(int i=0;i<goodsdetailVo.getRealnames().length;i++){
                //有一条空的记录会传过来。直接跳过
                if("".equals(goodsdetailVo.getUploadnames()[i])){
                    continue;
                }
                Fileinfo fileinfo = new Fileinfo();
                fileinfo.setId(UUIDUtils.getUUID());
                fileinfo.setIsdel(WebConstants.NO);
                fileinfo.setDetailinfo(goodsdetailVo.getId());
                fileinfo.setRealname(goodsdetailVo.getRealnames()[i]);
                if(goodsdetailVo.getUploadnames()!=null &&
                        goodsdetailVo.getUploadnames().length>i){
                    fileinfo.setUploadname(goodsdetailVo.getUploadnames()[i]);
                }
                if(goodsdetailVo.getDirname()!=null &&
                        goodsdetailVo.getDirname().length>i){
                    fileinfo.setDir(goodsdetailVo.getDirname()[i]);
                }

                fileinfoMapper.insertSelective(fileinfo);
            }
        }
    }
}
