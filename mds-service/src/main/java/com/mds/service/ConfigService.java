package com.mds.service;

import com.mds.common.ResultVo;
import com.mds.entity.Config;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/3/28
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public interface ConfigService {
    /**
     * 添加系统配置
     * @param config
     * @return
     */
    public ResultVo<Config> addConfig(Config config);

    /**
     * 修改基本信息
     * @param config
     * @return
     */
    public ResultVo<Config> updateConfig(Config config);

    /**
     *查询系统配置
     * 根据id
     * @param id
     * @return
     */
    public ResultVo<Config> queryConfigInfo(String id);
    /**
     * 查询系统配置
     * 根据查询实体
     * @return
     */
    public ResultVo<Config> queryConfigInfo(Config config);

}
