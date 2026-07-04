package com.ruoyi.common.core.mapper;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

import com.ruoyi.common.annotation.TableName;
import org.apache.ibatis.builder.annotation.ProviderContext;

/**
 * 通用 Mapper SQL 自动生成器
 * 根据 PO 类注解自动生成 CRUD SQL，Mapper 继承 BaseMapper 后无需手写
 *
 * @author ruoyi
 * @date 2026-07-02
 */
public class BaseMapperProvider
{
    /**
     * 获取表名：类名驼峰转下划线
     * PO类名直接按表名驼峰命名（如 RyHospital → ry_hospital）
     *
     * @param clazz 实体类
     * @return 数据库表名
     */
    private static String getTableName(Class<?> clazz)
    {
        return camelToUnderscore(clazz.getSimpleName());
    }

    /**
     * 获取主键字段名（数据库列名）
     *
     * @param clazz 实体类
     * @return 主键列名
     */
    private static String getIdColumn(Class<?> clazz)
    {
        return "id";
    }

    /**
     * 获取 PO 的所有字段（去除 serialVersionUID，包含父类字段）
     *
     * @param clazz 实体类
     * @return 字段列表
     */
    private static List<Field> getFields(Class<?> clazz)
    {
        List<Field> fields = new ArrayList<>();
        for (Field f : clazz.getDeclaredFields())
        {
            if ("serialVersionUID".equals(f.getName())) continue;
            fields.add(f);
        }
        Class<?> parent = clazz.getSuperclass();
        while (parent != null && parent != Object.class)
        {
            for (Field f : parent.getDeclaredFields())
            {
                if ("serialVersionUID".equals(f.getName())) continue;
                boolean exists = fields.stream().anyMatch(x -> x.getName().equals(f.getName()));
                if (!exists) fields.add(f);
            }
            parent = parent.getSuperclass();
        }
        return fields;
    }

    /**
     * 获取非空字段的值 Map
     *
     * @param obj 实体对象
     * @return 字段名→值的映射
     */
    private static Map<String, Object> getNonNullFields(Object obj)
    {
        Map<String, Object> map = new LinkedHashMap<>();
        if (obj == null) return map;
        for (Field f : getFields(obj.getClass()))
        {
            try
            {
                f.setAccessible(true);
                Object val = f.get(obj);
                if (val != null) map.put(f.getName(), val);
            }
            catch (Exception ignored) {}
        }
        return map;
    }

    // ==================== Insert ====================

    /**
     * 生成 INSERT 语句（动态字段）
     *
     * @param po  实体对象
     * @param ctx Provider上下文，获取Mapper泛型类型
     * @return INSERT SQL
     */
    public String insert(Object po, ProviderContext ctx)
    {
        Class<?> clazz = getEntityClass(ctx);
        String table = getTableName(clazz);
        Map<String, Object> fields = getNonNullFields(po);
        StringBuilder cols = new StringBuilder();
        StringBuilder vals = new StringBuilder();
        for (String name : fields.keySet())
        {
            if (cols.length() > 0) { cols.append(", "); vals.append(", "); }
            cols.append(camelToUnderscore(name));
            vals.append("#{").append(name).append("}");
        }
        return "INSERT INTO " + table + " (" + cols + ") VALUES (" + vals + ")";
    }

    /**
     * 生成批量 INSERT 语句
     *
     * @param map 包含 list 键的 Map（MyBatis 传参格式）
     * @param ctx Provider上下文
     * @return 批量 INSERT SQL
     */
    @SuppressWarnings("unchecked")
    public String insertBatch(Map<String, Object> map, ProviderContext ctx)
    {
        List<?> list = (List<?>) map.get("list");
        if (list == null || list.isEmpty()) return "";
        Class<?> clazz = getEntityClass(ctx);
        String table = getTableName(clazz);
        List<Field> fields = getFields(clazz);
        StringBuilder cols = new StringBuilder();
        for (Field f : fields)
        {
            if (cols.length() > 0) cols.append(", ");
            cols.append(camelToUnderscore(f.getName()));
        }
        StringBuilder vals = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            if (i > 0) vals.append(", ");
            vals.append("(");
            for (int j = 0; j < fields.size(); j++)
            {
                if (j > 0) vals.append(", ");
                vals.append("#{list[").append(i).append("].").append(fields.get(j).getName()).append("}");
            }
            vals.append(")");
        }
        return "INSERT INTO " + table + " (" + cols + ") VALUES " + vals;
    }

    // ==================== Update ====================

    /**
     * 生成 UPDATE BY ID 语句（动态字段）
     *
     * @param po  实体对象
     * @param ctx Provider上下文
     * @return UPDATE SQL
     */
    public String updateById(Object po, ProviderContext ctx)
    {
        Class<?> clazz = getEntityClass(ctx);
        String table = getTableName(clazz);
        String idCol = getIdColumn(clazz);
        Map<String, Object> fields = getNonNullFields(po);
        StringBuilder sets = new StringBuilder();
        Object idVal = null;
        for (Map.Entry<String, Object> e : fields.entrySet())
        {
            if ("id".equals(e.getKey())) { idVal = e.getValue(); continue; }
            if (sets.length() > 0) sets.append(", ");
            sets.append(camelToUnderscore(e.getKey())).append(" = #{").append(e.getKey()).append("}");
        }
        if (idVal == null) throw new RuntimeException("UPDATE失败：主键id不能为空");
        return "UPDATE " + table + " SET " + sets + " WHERE " + idCol + " = #{id}";
    }

    // ==================== Delete ====================

    /**
     * 生成 DELETE BY ID 语句
     *
     * @param id  主键值
     * @param ctx Provider上下文
     * @return DELETE SQL
     */
    public String deleteById(Serializable id, ProviderContext ctx)
    {
        Class<?> clazz = getEntityClass(ctx);
        String table = getTableName(clazz);
        String idCol = getIdColumn(clazz);
        return "DELETE FROM " + table + " WHERE " + idCol + " = #{id}";
    }

    /**
     * 生成批量 DELETE 语句（IN 条件）
     *
     * @param map 包含 array 键的 Map
     * @param ctx Provider上下文
     * @return 批量 DELETE SQL（script 标签支持 foreach）
     */
    public String deleteByIds(Map<String, Object> map, ProviderContext ctx)
    {
        Class<?> clazz = getEntityClass(ctx);
        String table = getTableName(clazz);
        String idCol = getIdColumn(clazz);
        return "<script>DELETE FROM " + table + " WHERE " + idCol + " IN "
               + "<foreach collection='array' item='id' open='(' separator=',' close=')'>#{id}</foreach></script>";
    }

    // ==================== Select ====================

    /**
     * 生成 SELECT BY ID 语句
     *
     * @param id  主键值
     * @param ctx Provider上下文
     * @return SELECT SQL
     */
    public String selectById(Serializable id, ProviderContext ctx)
    {
        Class<?> clazz = getEntityClass(ctx);
        String table = getTableName(clazz);
        String idCol = getIdColumn(clazz);
        return "SELECT * FROM " + table + " WHERE " + idCol + " = #{id}";
    }

    /**
     * 生成条件查询列表语句
     *
     * @param po  查询条件对象
     * @param ctx Provider上下文
     * @return SELECT SQL（动态WHERE条件）
     */
    public String selectList(Object po, ProviderContext ctx)
    {
        Class<?> clazz = getEntityClass(ctx);
        String table = getTableName(clazz);
        Map<String, Object> fields = getNonNullFields(po);
        StringBuilder sql = new StringBuilder("SELECT * FROM " + table + " WHERE 1=1");
        for (Map.Entry<String, Object> e : fields.entrySet())
        {
            if ("params".equals(e.getKey())) continue;
            sql.append("\n  AND ").append(camelToUnderscore(e.getKey())).append(" = #{").append(e.getKey()).append("}");
        }
        return sql.toString();
    }

    /**
     * 生成条件查询单条语句
     *
     * @param po  查询条件对象
     * @param ctx Provider上下文
     * @return SELECT SQL + LIMIT 1
     */
    public String selectOne(Object po, ProviderContext ctx)
    {
        return selectList(po, ctx) + " LIMIT 1";
    }

    /**
     * 生成查询全表语句
     *
     * @param po  占位参数
     * @param ctx Provider上下文
     * @return SELECT * FROM table
     */
    public String selectAll(Object po, ProviderContext ctx)
    {
        Class<?> clazz = getEntityClass(ctx);
        String table = getTableName(clazz);
        return "SELECT * FROM " + table;
    }

    /**
     * 生成统计数量语句
     *
     * @param po  查询条件对象
     * @param ctx Provider上下文
     * @return SELECT COUNT SQL
     */
    public String selectCount(Object po, ProviderContext ctx)
    {
        Class<?> clazz = getEntityClass(ctx);
        String table = getTableName(clazz);
        return "SELECT COUNT(1) FROM " + table;
    }

    // ==================== 工具方法 ====================

    /**
     * 从 Mapper 接口的泛型参数获取实体类型
     *
     * @param ctx Provider上下文
     * @return 实体 Class
     */
    @SuppressWarnings("unchecked")
    private Class<?> getEntityClass(ProviderContext ctx)
    {
        Class<?> mapperClass = ctx.getMapperType();
        for (java.lang.reflect.Type t : mapperClass.getGenericInterfaces())
        {
            if (t instanceof ParameterizedType)
            {
                ParameterizedType pt = (ParameterizedType) t;
                if (BaseMapper.class.isAssignableFrom((Class<?>) pt.getRawType()))
                {
                    return (Class<?>) pt.getActualTypeArguments()[0];
                }
            }
        }
        throw new RuntimeException("无法获取实体类型: " + mapperClass.getName());
    }

    /**
     * 驼峰转下划线
     *
     * @param camel 驼峰字符串
     * @return 下划线字符串
     */
    private static String camelToUnderscore(String camel)
    {
        StringBuilder sb = new StringBuilder();
        for (char c : camel.toCharArray())
        {
            if (Character.isUpperCase(c))
            {
                sb.append('_').append(Character.toLowerCase(c));
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
