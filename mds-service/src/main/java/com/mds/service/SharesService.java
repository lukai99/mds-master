package com.mds.service;

import com.mds.common.ResultVo;
import com.mds.entity.Shares;
import com.mds.utils.PageBean;
import com.mds.vo.SharesGameRecordVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-15
 * Time: 下午4:57
 * To change this template use File | Settings | File Templates.
 */
public interface SharesService {

    /**
     * 获取所有股票数据
     * @return
     */
    public List<Shares> querySharesList();

    /**
     * 获取股票分页获取
     * @param shares
     * @return
     */
    public PageBean<Shares> querySharesListForPage(Shares shares, PageBean<Shares> pageBean);

    /**
     * 获取股票数据 根据数据编号
     * @param id
     * @return
     */
    public Shares getShares(Integer id);

    /**
     * 获取股票数据
     * @param code
     * @return
     */
    public Shares getShares(String code);

    /**
     * 获取股票模拟练习列表
     * 分页模式
     * @param sharesGameRecordVo
     * @return
     */
    public PageBean<SharesGameRecordVo> getSharesDealSimulationList(SharesGameRecordVo sharesGameRecordVo);

    /**
     * 新建游戏模拟记录
     * @param request
     * @param session
     * @return
     */
    public ResultVo generatorSharesDealGame(HttpServletRequest request, HttpSession session);
}
