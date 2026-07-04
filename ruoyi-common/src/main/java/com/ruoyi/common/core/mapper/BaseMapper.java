package com.ruoyi.common.core.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * 通用 Mapper 接口
 * 继承此接口自动获得 CRUD，无需手写 SQL。自定义查询在 XML 中定义。
 *
 * @param <T>  PO类型
 * @param <ID> 主键类型 (Long/String)
 * @author YiJiawei
 * @date 2026/7/2
 */
public interface BaseMapper<T, ID extends Serializable>
{
    /**
     * 新增
     *
     * @param po 实体对象
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @InsertProvider(type = BaseMapperProvider.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(T po);

    /**
     * 批量新增
     *
     * @param list 实体列表
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @InsertProvider(type = BaseMapperProvider.class, method = "insertBatch")
    int insertBatch(List<T> list);

    /**
     * 根据主键修改
     *
     * @param po 实体对象
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @UpdateProvider(type = BaseMapperProvider.class, method = "updateById")
    int updateById(T po);

    /**
     * 根据主键删除
     *
     * @param id 主键值
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @DeleteProvider(type = BaseMapperProvider.class, method = "deleteById")
    int deleteById(ID id);

    /**
     * 批量删除
     *
     * @param ids 主键数组
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @DeleteProvider(type = BaseMapperProvider.class, method = "deleteByIds")
    int deleteByIds(ID[] ids);

    /**
     * 根据主键查询
     *
     * @param id 主键值
     * @return T
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @SelectProvider(type = BaseMapperProvider.class, method = "selectById")
    T selectById(ID id);

    /**
     * 条件查询列表
     *
     * @param po 查询条件
     * @return java.util.List<T>
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @SelectProvider(type = BaseMapperProvider.class, method = "selectList")
    List<T> selectList(T po);

    /**
     * 条件查询单条
     *
     * @param po 查询条件
     * @return T
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @SelectProvider(type = BaseMapperProvider.class, method = "selectOne")
    T selectOne(T po);

    /**
     * 查询全部
     *
     * @return java.util.List<T>
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @SelectProvider(type = BaseMapperProvider.class, method = "selectAll")
    List<T> selectAll();

    /**
     * 条件统计
     *
     * @param po 查询条件
     * @return int
     * @author YiJiawei
     * @date 2026/7/2
     **/
    @SelectProvider(type = BaseMapperProvider.class, method = "selectCount")
    int selectCount(T po);
}
