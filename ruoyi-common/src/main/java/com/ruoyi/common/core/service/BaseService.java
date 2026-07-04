package com.ruoyi.common.core.service;

import java.io.Serializable;
import java.util.List;

/**
 * 通用 Service 接口，业务Service继承此接口获得通用CRUD方法
 *
 * @param <T>  PO类型
 * @param <ID> 主键类型
 * @author YiJiawei
 * @date 2026/7/4
 */
public interface BaseService<T, ID extends Serializable>
{
    /**
     * 新增
     *
     * @param po 实体对象
     * @return int
     * @author YiJiawei
     * @date 2026/7/4
     **/
    int insert(T po);

    /**
     * 批量新增
     *
     * @param list 实体列表
     * @return int
     * @author YiJiawei
     * @date 2026/7/4
     **/
    int insertBatch(List<T> list);

    /**
     * 根据主键修改
     *
     * @param po 实体对象
     * @return int
     * @author YiJiawei
     * @date 2026/7/4
     **/
    int updateById(T po);

    /**
     * 根据主键删除
     *
     * @param id 主键值
     * @return int
     * @author YiJiawei
     * @date 2026/7/4
     **/
    int deleteById(ID id);

    /**
     * 批量删除
     *
     * @param ids 主键数组
     * @return int
     * @author YiJiawei
     * @date 2026/7/4
     **/
    int deleteByIds(ID[] ids);

    /**
     * 根据主键查询
     *
     * @param id 主键值
     * @return T
     * @author YiJiawei
     * @date 2026/7/4
     **/
    T selectById(ID id);

    /**
     * 条件查询列表
     *
     * @param po 查询条件
     * @return java.util.List<T>
     * @author YiJiawei
     * @date 2026/7/4
     **/
    List<T> selectList(T po);

    /**
     * 条件查询单条
     *
     * @param po 查询条件
     * @return T
     * @author YiJiawei
     * @date 2026/7/4
     **/
    T selectOne(T po);

    /**
     * 查询全部
     *
     * @return java.util.List<T>
     * @author YiJiawei
     * @date 2026/7/4
     **/
    List<T> selectAll();
}
