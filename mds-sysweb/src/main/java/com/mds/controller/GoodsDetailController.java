package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.common.ResultVo;
import com.mds.common.WebConstants;
import com.mds.entity.Fileinfo;
import com.mds.entity.Goodsdetailsinfo;
import com.mds.entity.Goodsinfo;
import com.mds.service.FileInfoService;
import com.mds.service.GoodsDetailService;
import com.mds.service.GoodsInfoService;
import com.mds.utils.PageBean;
import com.mds.utils.UUIDUtils;
import com.mds.vo.GoodsdetailsinfoVo;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2018/3/27.
 */
@Controller
@RequestMapping("/goodsDetail")
public class GoodsDetailController {

    @Autowired
    GoodsDetailService detailService;
    @Autowired
    GoodsInfoService goodsInfoService;
    @Autowired
    FileInfoService fileInfoService;

    /* 物品信息管理 */
    @RequestMapping("/toGoodsDetailPage.do")
    public String toGoodsInfoManagerPage(HttpServletRequest request, Model model){
        return "goodsDetail/goodsDetailManager";
    }
    /* 获取物品信息列表 */
    @RequestMapping("getGoodsDetailList.do")
    @ResponseBody
    public PageBean<GoodsdetailsinfoVo> getGoodsDetailList(GoodsdetailsinfoVo detailsinfoVo, PageBean pageBean, HttpServletRequest request, Model model){
        PageBean<GoodsdetailsinfoVo> resultPageBean = detailService.queryGoodsDetail(detailsinfoVo,pageBean);
        return resultPageBean;
    }

    /* 添加物品信息页面 */
    @RequestMapping("/toOperatorGoodsDetailPage.do")
    public String addGoodsInfoPage(Goodsdetailsinfo detailsinfo, HttpServletRequest request, Model model){
        List<Goodsinfo> goodslist = goodsInfoService.getGoodsList();
        model.addAttribute("goodslist",goodslist);
        if(detailsinfo.getId() != null){
            ResultVo vo = detailService.queryGoodsDetail(detailsinfo.getId());
            Goodsdetailsinfo detailsinfoObj = (Goodsdetailsinfo)vo.getData();
            model.addAttribute("detailsinfoObj",detailsinfoObj);
            Fileinfo fileinfo = new Fileinfo();
            fileinfo.setIsdel(WebConstants.NO);
            fileinfo.setDetailinfo(detailsinfo.getId());
            ResultVo rvo = fileInfoService.findFileinfoByDetailId(fileinfo);
            List<Fileinfo> filelist = rvo.getDataList();
            model.addAttribute("filelist",filelist);
        }
        return "goodsDetail/operatorGoodsDetailsInfo";
    }

    /* 增改操作数据 */
    @RequestMapping("operatorGoodsDetail.do")
    @SystemControllerLog(module = "mds",option = "增改物品信息详情",description = "增改物品信息详情")
    @ResponseBody
    public ResultVo operatorGoodsDetail(GoodsdetailsinfoVo detailsinfo, PageBean pageBean, HttpServletRequest request, Model model){
        ResultVo vo =  null;
        //id为空的话 为添加菜单的操作 不为空的话为修改的操作
        if(detailsinfo.getId()!=null&&!"".equals(detailsinfo.getId())){
            vo = detailService.updateGoodsDetail(detailsinfo);
        }else{
            vo = detailService.saveGoodsDetail(detailsinfo);
        }
        return vo;
    }

    /* 删除数据数据 */
    @RequestMapping("toDeleteGoodsDetailPage.do")
    @SystemControllerLog(module = "mds",option = "删除物品信息详情",description = "删除物品信息详情")
    @ResponseBody
    public ResultVo deleteGoodsInfo(String[] ids,PageBean pageBean,HttpServletRequest request,Model model){
        ResultVo vo =  null;
        vo = detailService.deleteGoodsDetailForUpdate(ids);
        return vo;
    }

    @RequestMapping("uploadGoodsIamges.do")
    @ResponseBody
    public Map<String,String> upload(MultipartFile upload, HttpServletResponse response){
        response.setContentType("text/html");

        Map<String,String> resmap = new HashMap<String,String>();
        FileOutputStream fos = null;
        InputStream in = null;
        try{
            //文件夹名称
            String dirname = new SimpleDateFormat("yyyyMM").format(new Date());
            //文件真实名称
            String realname = upload.getOriginalFilename();
            //当前时间戳加文件后缀
            String uploadname = UUIDUtils.getUUID()+realname.substring(realname.lastIndexOf("."));

            String path = "E:\\upload";
            File file = new File(path);
            if(!file.exists()){
                file.mkdir();
            }
            path = "E:\\upload"+File.separator+dirname;
            file = new File(path);
            if(!file.exists()){
                file.mkdir();
            }
            path = path+File.separator+uploadname;
            file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            in = upload.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }


            resmap.put("realname",realname);
            resmap.put("uploadname",uploadname);
            resmap.put("dirname",dirname);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resmap;
    }
}
