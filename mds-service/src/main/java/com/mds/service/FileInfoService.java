package com.mds.service;

import com.mds.common.ResultVo;
import com.mds.entity.Fileinfo;

/**
 * Created by ASUS on 2018/3/31.
 */
public interface FileInfoService {

    ResultVo<Fileinfo> findFileinfoByDetailId(Fileinfo fileinfo);
}
