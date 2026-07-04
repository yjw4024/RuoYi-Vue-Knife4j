package com.ruoyi.common.core.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruoyi.common.core.mapper.BaseMapper;

/**
 * 通用 Service 实现，继承此类指定Mapper即可获得通用CRUD
 *
 * @param <M>  Mapper类型
 * @param <T>  PO类型
 * @param <ID> 主键类型
 * @author YiJiawei
 * @date 2026/7/2
 */
public class BaseServiceImpl<M extends BaseMapper<T, ID>, T, ID extends Serializable> implements BaseService<T, ID>
{
    @Autowired
    protected M mapper;

    /**
     * 新增
     *
     * @param po 实体对象
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Override public int insert(T po) { return mapper.insert(po); }

    /**
     * 批量新增
     *
     * @param list 实体列表
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Override public int insertBatch(List<T> list) { return mapper.insertBatch(list); }

    /**
     * 根据主键修改
     *
     * @param po 实体对象
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Override public int updateById(T po) { return mapper.updateById(po); }

    /**
     * 根据主键删除
     *
     * @param id 主键值
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Override public int deleteById(ID id) { return mapper.deleteById(id); }

    /**
     * 批量删除
     *
     * @param ids 主键数组
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Override public int deleteByIds(ID[] ids) { return mapper.deleteByIds(ids); }

    /**
     * 根据主键查询
     *
     * @param id 主键值
     * @return T
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Override public T selectById(ID id) { return mapper.selectById(id); }

    /**
     * 条件查询列表
     *
     * @param po 查询条件
     * @return java.util.List<T>
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Override public List<T> selectList(T po) { return mapper.selectList(po); }

    /**
     * 条件查询单条
     *
     * @param po 查询条件
     * @return T
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Override public T selectOne(T po) { return mapper.selectOne(po); }

    /**
     * 查询全部
     *
     * @return java.util.List<T>
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @Override public List<T> selectAll() { return mapper.selectAll(); }
}
