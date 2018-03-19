package com.mds.service;

import com.mds.entity.Dictionary;
import com.mds.common.ResultVo;
import com.mds.utils.PageBean;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-18
 * Time: 下午2:36
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface DictionaryService {

    /**
     * 添加字典项数据
     * @param dictionary
     * @return
     */
    public ResultVo<Dictionary> addDictionary(Dictionary dictionary);

    /**
     * 修改字典项数据
     * @param dictionary
     * @return
     */
    public ResultVo<Dictionary> updateDictionary(Dictionary dictionary);

    /**
     * 批量删除字典项数据（逻辑删除）
     * @param dictionaryIds
     * @return
     */
    public ResultVo<Dictionary> deleteDictionaryByUpdate(String[] dictionaryIds);

    /**
     * 批量删除字典项数据（物理删除）
     * @param dictionaryIds
     * @return
     */
    public ResultVo<Dictionary> deleteDictionaryByDelete(String[] dictionaryIds);

    /**
     * 获取全部子字典项数据 根据父级菜单id
     * @param parentId
     * @return
     */
    public ResultVo<Dictionary> getChildDictionary(String parentId);

    /**
     * 获取字典项数据 根据查询条件
     * @param dictionary
     * @return
     */
    public ResultVo<Dictionary> queryDictionary(Dictionary dictionary);

    /**
     * 获取字典数据 根据id
     * @param dictionaryId
     * @return
     */
    public ResultVo<Dictionary> getDictionary(String dictionaryId);

    /**
     * 获取字典项数据 根据查询条件 分页模式
     * @param dictionary
     * @return
     */
    public PageBean<Dictionary> queryDictionary(Dictionary dictionary, PageBean pageBean);

}
