package com.ruoyi.common.annotation;

import java.lang.annotation.*;

/**
 * 表名注解，用于指定PO对应的数据库表名
 * 不指定则默认使用类名驼峰转下划线
 *
 * @author ruoyi
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableName
{
    String value();
}
