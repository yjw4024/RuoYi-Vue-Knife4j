package com.ruoyi.common.core.service;

import java.util.List;

/**
 * 通用 Service 接口（参考douyi-tasks的MapperCustom + Service模式）
 * 业务Service继承此接口即可获得通用CRUD方法
 *
 * @param <T> PO类型
 * @author ruoyi
 */
public interface BaseService<T>
{
    /** 新增 */
    int insert(T po);
    /** 批量新增 */
    int insertBatch(List<T> list);
    /** 根据ID修改 */
    int updateById(T po);
    /** 根据ID删除 */
    int deleteById(Long id);
    /** 批量删除 */
    int deleteByIds(Long[] ids);
    /** 根据ID查询 */
    T selectById(Long id);
    /** 条件查询列表 */
    List<T> selectList(T po);
    /** 条件查询单个 */
    T selectOne(T po);
    /** 查询全部 */
    List<T> selectAll();
}
