package com.ruoyi.common.core.mapper;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * 通用 Mapper SQL 生成器（参考douyi-tasks的MapperCustom模式）
 * 根据PO类自动生成基本的CRUD SQL，无需手写XML
 *
 * 使用方式（在XML mapper中引用）：
 * <insert id="insert">${sql}</insert>
 * 其中 sql 由 BaseMapperProvider 动态生成
 *
 * @author ruoyi
 */
public class BaseMapperProvider
{
    /**
     * 生成 INSERT SQL
     */
    public static <T> String buildInsert(T po, String tableName)
    {
        Class<?> clazz = po.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (Field f : fields)
        {
            if ("serialVersionUID".equals(f.getName())) continue;
            try
            {
                f.setAccessible(true);
                Object val = f.get(po);
                if (val != null)
                {
                    if (columns.length() > 0) { columns.append(", "); values.append(", "); }
                    columns.append(camelToUnderscore(f.getName()));
                    values.append("#{").append(f.getName()).append("}");
                }
            }
            catch (Exception ignored) {}
        }
        return "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
    }

    /**
     * 生成 UPDATE BY ID SQL
     */
    public static <T> String buildUpdateById(T po, String tableName, String idColumn)
    {
        Class<?> clazz = po.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sets = new StringBuilder();
        Object idVal = null;

        for (Field f : fields)
        {
            if (f.getName().equals(idColumn) || "serialVersionUID".equals(f.getName())) continue;
            try
            {
                f.setAccessible(true);
                Object val = f.get(po);
                if (val != null)
                {
                    if (sets.length() > 0) sets.append(", ");
                    sets.append(camelToUnderscore(f.getName())).append(" = #{").append(f.getName()).append("}");
                }
            }
            catch (Exception ignored) {}
        }

        try
        {
            Field idField = clazz.getDeclaredField(idColumn);
            idField.setAccessible(true);
            idVal = idField.get(po);
        }
        catch (Exception ignored) {}

        if (idVal == null) throw new RuntimeException("UPDATE失败：主键" + idColumn + "不能为空");
        return "UPDATE " + tableName + " SET " + sets + " WHERE " + camelToUnderscore(idColumn) + " = #{" + idColumn + "}";
    }

    /**
     * 生成 DELETE BY ID SQL
     */
    public static String buildDeleteById(String tableName, String idColumn)
    {
        return "DELETE FROM " + tableName + " WHERE " + camelToUnderscore(idColumn) + " = #{" + idColumn + "}";
    }

    /**
     * 生成 SELECT BY ID SQL
     */
    public static String buildSelectById(String tableName, String idColumn)
    {
        return "SELECT * FROM " + tableName + " WHERE " + camelToUnderscore(idColumn) + " = #{" + idColumn + "}";
    }

    /**
     * 生成 SELECT ALL SQL
     */
    public static String buildSelectAll(String tableName)
    {
        return "SELECT * FROM " + tableName;
    }

    /**
     * 驼峰转下划线
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
