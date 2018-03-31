package com.mds.service.impl;

import com.mds.common.ResultVo;
import com.mds.dao.FileinfoMapper;
import com.mds.entity.Fileinfo;
import com.mds.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2018/3/31.
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {
    @Autowired
    FileinfoMapper fileinfoMapper;
    @Override
    public ResultVo<Fileinfo> findFileinfoByDetailId(Fileinfo fileinfo) {
        ResultVo<Fileinfo> resultVo = new ResultVo<Fileinfo>();
        List<Fileinfo> fileinfoList = fileinfoMapper.selectBySelective(fileinfo);
        String realnames = "";
        String uploadnames = "";
        String dirnames = "";
        for(Fileinfo info : fileinfoList){
            realnames += info.getRealname()+",";
            uploadnames += info.getUploadname()+",";
            dirnames += info.getDir()+",";
        }
        String[] strArr = new String[3];
        strArr[0] = realnames;
        strArr[1] = uploadnames;
        strArr[2] = dirnames;
        resultVo.setData(strArr);
        resultVo.setDataList(fileinfoList);
        return resultVo;
    }
}
