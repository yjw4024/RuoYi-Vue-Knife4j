package com.ruoyi.common.core.mapper;

import java.util.List;

/**
 * 通用 Mapper 接口，业务 Mapper 继承此接口获得通用 CRUD 方法
 * 复杂查询通过 XML mapper 实现
 *
 * @param <T> PO类型
 *
 * @author ruoyi
 */
public interface BaseMapper<T>
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

    /** 根据条件统计数量 */
    int selectCount(T po);
}
