package com.mds.service;

import com.mds.common.ResultVo;
import com.mds.entity.Baseelement;
import com.mds.utils.PageBean;
import com.mds.vo.BaseElementVo;

public interface BaseElementService {

    /**
     * 添加基本元素
     * @param baseelement
     * @return
     */
    public ResultVo<Baseelement> addBaseElement(Baseelement baseelement);

    /**
     * 修改元素基本信息
     * @param baseelement
     * @return
     */
    public ResultVo<Baseelement> updateBaseElement(Baseelement baseelement);

    /**
     * 删除元素基本信息
     * 逻辑删除
     * @param baseelement
     * @return
     */
    public ResultVo<Baseelement> deleteBaseElementForUpdate(Baseelement baseelement);

    /**
     * 删除元素基本信息
     * 物理删除
     * @param baseelement
     * @return
     */
    public ResultVo<Baseelement> deleteBaseElement(String baseelement);

    /**
     * 批量删除元素基本信息
     * @param ids
     * @return
     */
    public ResultVo<Baseelement> deleteForBaseElement(String[] ids);

    /**
     * 查询带分页
     * @param pageBean
     * @return
     */
    public PageBean<BaseElementVo> queryBaseElementInfo(BaseElementVo baseElementVo, PageBean pageBean);

    /**
     *查询元素基本信息
     * 根据id
     * @param id
     * @return
     */
    public ResultVo<Baseelement> queryBaseElementInfo(String id);

    /**
     *查询元素基本信息
     * 根据实体
     * @return
     */
    public ResultVo<BaseElementVo> queryBaseElementInfo(BaseElementVo baseElementVo);

}
