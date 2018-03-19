package com.mds.service;

import com.mds.entity.Expect;
import com.mds.common.ResultVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-9-19
 * Time: 下午12:25
 * To change this template use File | Settings | File Templates.
 */
public interface ExpectService {
    /**
     * 获取全部预期数据
     * @return
     */
    public List<Expect> queryExpectList();

    /**
     * 获取预期数据 根据实体查询
     * @param expect
     * @return
     */
    public List<Expect> queryExpectList(Expect expect);

    /**
     * 获取预期数据 根据股票代码
     * @param sharesCode
     * @return
     */
    public List<Expect> queryExpectList(String sharesCode);

    /**
     * 获取预期数据 根据数据编号
     * @param id
     * @return
     */
    public Expect getExpect(Integer id);

    /**
     * 添加预期
     * @param expect
     * @return 添加数据的数据编号
     */
    public ResultVo saveExpect(Expect expect);

    /**
     *修改预期
     * @param expect
     * @return
     */
    public Integer updateExpect(Expect expect);

    /**
     * 删除预期
     * @param id
     * @return
     */
    public Integer deleteExpect(Integer id);

    /**
     * 生成预期价格 和 止损价格
     * @param expect
     * @return
     */
    public ResultVo createExpectPrice(Expect expect);
}
