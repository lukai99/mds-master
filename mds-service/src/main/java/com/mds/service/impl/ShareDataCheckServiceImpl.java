package com.mds.service.impl;

import com.mds.dao.ShareDataCheckDao;
import com.mds.entity.DataCheck;
import com.mds.service.ShareDataCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-11-14
 * Time: 下午9:53
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ShareDataCheckServiceImpl implements ShareDataCheckService {
    @Autowired
    private ShareDataCheckDao shareDataCheckDao;
    @Override
    public List<DataCheck> queryDataCheckList() {
        return shareDataCheckDao.queryDataCheckList();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<DataCheck> queryDataCheckList(String shareCode) {
        return shareDataCheckDao.queryDataCheckByShareCode(shareCode);
    }

    @Override
    public DataCheck getDataCheck(Integer id) {
        return shareDataCheckDao.getDataCheck(id);
    }

    @Override
    public Integer addDataCheck(DataCheck dataCheck) {
        return shareDataCheckDao.addDataCheck(dataCheck);
    }

    @Override
    public boolean updateDataCheck(DataCheck dataCheck) {
        shareDataCheckDao.updateDataCheck(dataCheck);
        return false;
    }

    @Override
    public boolean deleteDataCheck(Integer id) {
        shareDataCheckDao.deleteDataCheck(id);
        return false;
    }
}
