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
        resultVo.setDataList(fileinfoList);
        return resultVo;
    }
}
