package com.ruoyi.common.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruoyi.common.core.mapper.BaseMapper;

/**
 * 通用 Service 实现（参考douyi-tasks模式）
 * 业务Service实现类继承此类，指定Mapper即可获得通用CRUD
 *
 * @param <M> Mapper类型
 * @param <T> PO类型
 * @author ruoyi
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T>
{
    @Autowired
    protected M mapper;

    @Override public int insert(T po) { return mapper.insert(po); }
    @Override public int insertBatch(List<T> list) { return mapper.insertBatch(list); }
    @Override public int updateById(T po) { return mapper.updateById(po); }
    @Override public int deleteById(Long id) { return mapper.deleteById(id); }
    @Override public int deleteByIds(Long[] ids) { return mapper.deleteByIds(ids); }
    @Override public T selectById(Long id) { return mapper.selectById(id); }
    @Override public List<T> selectList(T po) { return mapper.selectList(po); }
    @Override public T selectOne(T po) { return mapper.selectOne(po); }
    @Override public List<T> selectAll() { return mapper.selectAll(); }
}
