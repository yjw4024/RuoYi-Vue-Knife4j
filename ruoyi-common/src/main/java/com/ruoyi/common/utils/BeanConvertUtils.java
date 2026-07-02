package com.ruoyi.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;

/**
 * PO/DTO/VO 对象转换工具（参考douyi-tasks分层架构）
 *
 * @author ruoyi
 */
public class BeanConvertUtils
{
    /**
     * 对象属性拷贝
     * @param source 源对象
     * @param targetClass 目标类
     * @return 目标对象
     */
    public static <T> T convert(Object source, Class<T> targetClass)
    {
        if (source == null) return null;
        try
        {
            T target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        }
        catch (Exception e)
        {
            throw new RuntimeException("对象转换失败: " + e.getMessage(), e);
        }
    }

    /**
     * 列表转换
     * @param sourceList 源列表
     * @param targetClass 目标类
     * @return 目标列表
     */
    public static <T> List<T> convertList(List<?> sourceList, Class<T> targetClass)
    {
        if (sourceList == null) return new ArrayList<>();
        return sourceList.stream()
                .map(s -> convert(s, targetClass))
                .collect(Collectors.toList());
    }
}
