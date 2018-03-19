package com.mds.controller;

import com.mds.annotation.SystemControllerLog;
import com.mds.entity.*;
import com.mds.service.*;
import com.mds.utils.PageBean;
import com.mds.common.ResultVo;
import com.mds.vo.KChartDataVo;
import com.mds.vo.SharesGameRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-13
 * Time: 下午10:21
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/shares")
public class SharesController {
    @Autowired
    private SharesService sharesService;
    @Autowired
    private ExpectService expectService;
    @Autowired
    private SharePortraitService sharePortraitService;
    @Autowired
    ShareDataCheckService shareDataCheckService;
    @Autowired
    private SharesHistoryDataService sharesHistoryDataService;

    @RequestMapping("toSharesManagerPage.do")
    public String sharesManagerPage(){
        return "shares/sharesManager/sharesManager";
    }
    /* 股票 开始*/
    /**
     * 股票数据列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("querySharesList.do")
    @ResponseBody
    public PageBean<Shares> querySharesList(Shares shares,PageBean<Shares> pageBean,HttpServletRequest request, HttpServletResponse response){
        pageBean =  sharesService.querySharesListForPage(shares,pageBean);
        return pageBean;
    }

    /**
     * 查询股票期望数据
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("queryExpectList.do")
    @ResponseBody
    public List<Expect> queryExpectList(HttpServletRequest request, HttpServletResponse response,String sharesCode){
        List<Expect> list = expectService.queryExpectList(sharesCode);
        return list;
    }

    @RequestMapping("addSharesPage.do")
    public String addSharesPage(){
        return "shares/operatorShares";
    }

    @RequestMapping("saveShares.do")
     public ResultVo saveShares(HttpServletRequest request, HttpServletResponse response,Shares shares){
        return null;
    }

    @RequestMapping("updateShares.do")
    public ResultVo updateShares(HttpServletRequest request, HttpServletResponse response,Shares shares){
        return null;
    }

    @RequestMapping("deleteShares.do")
    public ResultVo deleteShares(HttpServletRequest request, HttpServletResponse response,Shares shares){
        return null;
    }
    /* 股票 结束 */
    /* 预期 开始 */
    @RequestMapping("addExpectPage.do")
    public String addExpectPage(){
        return "shares/operatorExpect";
    }
    @RequestMapping("operatorExpect.do")
    @ResponseBody
    public ResultVo saveExpect(HttpServletRequest request, HttpServletResponse response,Expect expect){
        ResultVo resultVo = null;
        if(expect.getId()!=null){
            expectService.updateExpect(expect);
        }else{
            resultVo = expectService.saveExpect(expect);
        }
        return resultVo;
    }

    @RequestMapping("createExpectPrice.do")
    @ResponseBody
    public ResultVo createExpectPrice(HttpServletRequest request, HttpServletResponse response,Expect expect){
        ResultVo resultVo = null;
        resultVo = expectService.createExpectPrice(expect);
        return resultVo;
    }

    /* 预期 结束*/
    /* 股票画像 开始*/
    @RequestMapping("toSharePortraitChartPage.do")
    public String sharePortraitChartPage(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Shares> list = sharesService.querySharesList();
        model.addAttribute("shareList",list);
        return "shares/sharesPortraitChart/sharePortraitChart";
    }
    @RequestMapping("getSharePortrait.do")
    @ResponseBody
    public ResultVo getSharePortrait(HttpServletRequest request, HttpServletResponse response,Integer dataId){
        ResultVo resultVo = null;
        resultVo = sharePortraitService.getSharePortrait(dataId);
        return resultVo;
    }
    /* 股票画像 结束*/
    /* 股票点位分析 开始 */
    @RequestMapping("toShareAnalysisPage.do")      //http://localhost:8080/shares/toShareAnalysisPage.do
    public String shareAnalysisPage(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Shares> list = sharesService.querySharesList();
        model.addAttribute("shareList",list);
        return "shares/share_analysis/shareAnalysisAdd";
    }
    /* 股票点位分析 结束 */
    /* 选点 开始 */

    /**
     * 主界面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toDataCheckManagerPage.do")      //http://localhost:8080/shares/toDataCheckManagerPage.do
    public String toDataCheckManagerPage(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Shares> list = sharesService.querySharesList();
        model.addAttribute("shareList",list);
        /*shareDataCheckService.getDataCheck();*/
        return "shares/dataCheck/dataCheckManager";
    }

    /**
     * 选点数据列表子页面
     * @param shareDataId
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toShareDataCheckPage.do")      //http://localhost:8080/shares/toShareDataCheckPage.do
    public String toShareDataCheckPage(String shareDataId,HttpServletRequest request, HttpServletResponse response,Model model){
       // List<Shares> list = sharesService.querySharesList();
        Shares shares = sharesService.getShares(Integer.valueOf(shareDataId));
        List<DataCheck> list = shareDataCheckService.queryDataCheckList(shares.getCode());
        model.addAttribute("dataCheckList",list);
        /*shareDataCheckService.getDataCheck();*/
        return "shares/dataCheck/dataCheckPage";
    }

    @RequestMapping("toOperationDataCheckPage.do")      //http://localhost:8080/shares/toShareDataCheckPage.do
    public String toOperationDataCheckPage(String sharesCode,HttpServletRequest request, HttpServletResponse response,Model model){
        // List<Shares> list = sharesService.querySharesList();
        //Shares shares = sharesService.getShares(Integer.valueOf(shareDataId));
        //List<DataCheck> list = shareDataCheckService.queryDataCheckList(shares.getCode());
        //model.addAttribute("dataCheckList",list);
        /*shareDataCheckService.getDataCheck();*/
        model.addAttribute("shareCode",sharesCode);
        return "shares/dataCheck/operationDataCheckPage";
    }
    @RequestMapping("saveDataCheck.do")
    public String saveDataCheck(DataCheck dataCheck,HttpServletRequest request, HttpServletResponse response,Model model){
        dataCheck.setCreateTime(new Date());
        shareDataCheckService.addDataCheck(dataCheck);
        return "redirect:/shares/toOperationDataCheckPage.do";
    }
    /* 选点 结束 */
    /* 股票历史数据 开始*/

    /**
     * 跳转股票历史数据管理页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toSharesHistoryDataPage.do")
    public String toSharesHistoryDataPage(HttpServletRequest request, HttpServletResponse response,Model model){
        return "shares/sharesHistory/sharesHistoryDataManager";
    }

    /* 获取菜单列表 */
    @RequestMapping("getSharesHistoryDataList.do")
    @SystemControllerLog(module = "mds",option = "查询股票历史数据列表",description = "分页查询股票历史数据")
    @ResponseBody
    public PageBean<SharesHistoryData> getSharesHistoryDataList(SharesHistoryData sharesHistoryData, HttpServletRequest request, Model model){
        PageBean<SharesHistoryData> resultPageBean = sharesHistoryDataService.querySharesHistoryData(sharesHistoryData);
        return resultPageBean;
    }

    /**
     * 导入数据
     * @param file
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("importSharesHistoryData.do")
    @ResponseBody
    @SystemControllerLog(module = "mds",option = "数据导入",description = "股票历史数据导入")
    public ResultVo toImportSharesHistoryDataPage(@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request, HttpServletResponse response, Model model){
        ResultVo resultVo = sharesHistoryDataService.impSharesHistoryData(file);
        return resultVo;
    }
    /* 股票历史数据 结束*/
    /* 股票数据K线展示 开始*/

    /**
     *
     * 股票K线图展示页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toKChartShowPage.do")
    public String toKChartShowPage(HttpServletRequest request, HttpServletResponse response,Model model){
//        List<Shares> list = sharesService.querySharesList();
//        model.addAttribute("shareList",list);
        /*shareDataCheckService.getDataCheck();*/
        return "shares/sharesKChart/kChartShow";
    }
    @RequestMapping("KChartShow.do")
    @SystemControllerLog(module = "mds",option = "查看股票K线数据",description = "查看股票K线数据")
    @ResponseBody
    public KChartDataVo KChartShow(SharesHistoryData sharesHistoryData, HttpServletRequest request, Model model){
//        PageBean<SharesHistoryData> resultPageBean = sharesHistoryDataService.querySharesHistoryData(sharesHistoryData);
        KChartDataVo kChartDataVo = sharesHistoryDataService.queryKChartData(sharesHistoryData);
        return kChartDataVo;
    }
    /* 股票数据K线展示 结束*/

    /* 股票实盘交易模拟 开始*/
    /**
     * 实盘交易模拟页面
     * @return
     */
    @RequestMapping("toSharesDealSimulationListPage.do")
    public String toSharesDealSimulationListPage(){
        //return "shares/sharesDealSimulation/sharesDealSimulationPage";
        return "shares/sharesDealSimulation/sharesDealSimulationManager";
    }
    /**
     * 获取游戏模拟记录列表
     * @param sharesGameRecordVo
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("getSharesDealSimulationList.do")
    @ResponseBody
    public PageBean<SharesGameRecordVo> getSharesDealSimulationList(SharesGameRecordVo sharesGameRecordVo, HttpServletRequest request, Model model){
        //PageBean<Dictionary> resultPageBean = dictionaryService.queryDictionary(dictionary,pageBean);
        PageBean<SharesGameRecordVo> resultPageBean = sharesService.getSharesDealSimulationList(sharesGameRecordVo);
        return resultPageBean;
    }

    /**
     * 新建模拟游戏练习
     * @param request
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("generatorSharesDealGame.do")
    @ResponseBody
    public ResultVo generatorSharesDealGame(HttpServletRequest request,HttpSession session, Model model){
        //PageBean<Dictionary> resultPageBean = dictionaryService.queryDictionary(dictionary,pageBean);
        ResultVo resultVo = sharesService.generatorSharesDealGame(request,session);
        return resultVo;
    }

    /**
     * 实盘交易模拟页面
     * @return
     */
    @RequestMapping("toSharesDealSimulationPage.do")
    public String toSharesDealSimulationPage(String gameCode,Model model){
        model.addAttribute("gameCode",gameCode);
        return "shares/sharesDealSimulation/sharesDealSimulationPage";
    }

    /**
     * 获取游戏的K线数据
     * @param gameCode
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("getGameKChartData.do")
    @SystemControllerLog(module = "mds",option = "获取股票数据",description = "获取模拟游戏对应的股票数据")
    @ResponseBody
    public KChartDataVo getGameKChartData(String gameCode,String next, HttpServletRequest request, Model model){
       // KChartDataVo kChartDataVo = sharesHistoryDataService.queryKChartData(sharesHistoryData);
        KChartDataVo kChartDataVo = sharesHistoryDataService.queryGameKChartData(gameCode,next);
        return kChartDataVo;
    }

    /* 股票实盘交易模拟 结束*/
}
