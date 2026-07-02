package com.ruoyi.generator.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

/**
 * 分层架构代码生成器（参考douyi-tasks的PO/DTO/VO/Query + MapperCustom模式）
 *
 * 根据数据库表名，自动生成：
 *   - PO  (继承 BasePO)
 *   - DTO (含 @NotBlank 校验)
 *   - VO  (不含敏感字段)
 *   - Query (继承 PageQuery)
 *   - Mapper (继承 BaseMapper<T> + XML)
 *   - Service (继承 BaseServiceImpl + 接口)
 *   - Controller (DTO/Query入参 + VO返回)
 *
 * @author ruoyi
 */
public class CodeGenerator
{
    private static final String AUTHOR = "ruoyi";
    private static final String BASE_PACKAGE = "com.ruoyi";
    private static final String MODULE = "system";

    public static void main(String[] args) throws Exception
    {
        // 示例：为 sys_notice 表生成全部分层代码
        generateAll(
            "SysNotice",       // 类名（大写驼峰）
            "sys_notice",      // 数据库表名
            "通知公告",         // 功能描述
            "noticeId",        // 主键字段（驼峰）
            "notice_id"        // 主键列名（下划线）
        );
    }

    /**
     * 一键生成全部文件
     */
    public static void generateAll(String className, String tableName,
                                    String description, String pkField, String pkColumn) throws Exception
    {
        String baseDir = "c:/Users/yjw/Desktop/springAi/RuoYi-Vue";
        String pkg = BASE_PACKAGE + "." + MODULE;

        // 列定义：列名(下划线), 字段名(驼峰), Java类型, 中文描述, 是否必填, 是否敏感(密码等)
        // 实际使用时应从数据库读取，这里展示模式

        // 生成文件
        generatePO(baseDir, className, tableName, description, pkg);
        generateDTO(baseDir, className, description, pkg);
        generateVO(baseDir, className, description, pkg);
        generateQuery(baseDir, className, description, pkg);
        generateMapperXml(baseDir, className, tableName, description, pkg, pkField, pkColumn);
        generateMapper(baseDir, className, description, pkg);
        generateService(baseDir, className, description, pkg);
        generateController(baseDir, className, description, pkg);

        System.out.println("✅ " + description + " 全部分层代码生成完毕！");
    }

    // ==================== PO ====================
    private static void generatePO(String baseDir, String className, String tableName,
                                    String description, String pkg) throws Exception
    {
        String content = """
            package %s.domain.po;

            import com.ruoyi.common.core.domain.BasePO;
            import io.swagger.v3.oas.annotations.media.Schema;

            /**
             * %s PO (对应表 %s)
             *
             * @author %s
             */
            @Schema(description = "%s")
            public class %sPO extends BasePO
            {
                private static final long serialVersionUID = 1L;
                // TODO: 根据实际表字段添加属性
                // @Schema(description = "字段名")
                // private String fieldName;
            }
            """.formatted(pkg, description, tableName, AUTHOR, description, className);

        writeFile(baseDir, pkg.replace('.', '/') + "/domain/po/" + className + "PO.java", content);
        System.out.println("  ✅ PO: " + className + "PO.java");
    }

    // ==================== DTO ====================
    private static void generateDTO(String baseDir, String className,
                                     String description, String pkg) throws Exception
    {
        String content = """
            package %s.domain.dto;

            import jakarta.validation.constraints.NotBlank;
            import io.swagger.v3.oas.annotations.media.Schema;

            @Schema(description = "%s新增/修改请求")
            public class %sDTO
            {
                @Schema(description = "ID(修改时必填)")
                private Long id;
                // TODO: 根据业务需要添加字段 + @NotBlank/@Size 校验
            }
            """.formatted(pkg, description, className);

        writeFile(baseDir, pkg.replace('.', '/') + "/domain/dto/" + className + "DTO.java", content);
        System.out.println("  ✅ DTO: " + className + "DTO.java");
    }

    // ==================== VO ====================
    private static void generateVO(String baseDir, String className,
                                    String description, String pkg) throws Exception
    {
        String content = """
            package %s.domain.vo;

            import java.util.Date;
            import com.fasterxml.jackson.annotation.JsonFormat;
            import io.swagger.v3.oas.annotations.media.Schema;

            @Schema(description = "%s响应")
            public class %sVO
            {
                @Schema(description = "ID")
                private Long id;
                @Schema(description = "创建者")
                private String createBy;
                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                @Schema(description = "创建时间")
                private Date createTime;
                // TODO: 根据业务需要添加展示字段
                // 严禁包含 password/salt 等敏感字段
            }
            """.formatted(pkg, description, className);

        writeFile(baseDir, pkg.replace('.', '/') + "/domain/vo/" + className + "VO.java", content);
        System.out.println("  ✅ VO: " + className + "VO.java");
    }

    // ==================== Query ====================
    private static void generateQuery(String baseDir, String className,
                                       String description, String pkg) throws Exception
    {
        String content = """
            package %s.domain.query;

            import com.ruoyi.common.core.domain.PageQuery;
            import io.swagger.v3.oas.annotations.media.Schema;

            @Schema(description = "%s查询")
            public class %sQuery extends PageQuery
            {
                // TODO: 添加查询过滤字段
                // @Schema(description = "字段名")
                // private String fieldName;
            }
            """.formatted(pkg, description, className);

        writeFile(baseDir, pkg.replace('.', '/') + "/domain/query/" + className + "Query.java", content);
        System.out.println("  ✅ Query: " + className + "Query.java（继承PageQuery）");
    }

    // ==================== Mapper ====================
    private static void generateMapper(String baseDir, String className,
                                        String description, String pkg) throws Exception
    {
        String content = """
            package %s.mapper;

            import com.ruoyi.common.core.mapper.BaseMapper;
            import %s.domain.po.%sPO;
            import org.apache.ibatis.annotations.Mapper;
            import java.util.List;

            /**
             * %s Mapper（继承BaseMapper自动获得CRUD，复杂查询在XML中定义）
             */
            @Mapper
            public interface %sMapper extends BaseMapper<%sPO>
            {
                // 简单CRUD由BaseMapper提供，无需手动编写
                // 复杂查询在此声明，在XML中实现
                // List<%sPO> select%sList(%sQuery query);
            }
            """.formatted(pkg, pkg, className, description, className, className,
                         className, className, className);

        writeFile(baseDir, pkg.replace('.', '/') + "/mapper/" + className + "Mapper.java", content);
        System.out.println("  ✅ Mapper: " + className + "Mapper.java（继承BaseMapper<" + className + "PO>）");
    }

    // ==================== Mapper XML ====================
    private static void generateMapperXml(String baseDir, String className, String tableName,
                                           String description, String pkg, String pkField,
                                           String pkColumn) throws Exception
    {
        String mapperClass = pkg + ".mapper." + className + "Mapper";
        String poClass = pkg + ".domain.po." + className + "PO";

        String content = """
            <?xml version="1.0" encoding="UTF-8"?>
            <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
                    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
            <mapper namespace="%s">

                <!-- ========== 通用CRUD（由BaseMapperProvider生成SQL，无需手写） ========== -->

                <insert id="insert" parameterType="%s">
                    INSERT INTO %s
                    <trim prefix="(" suffix=")" suffixOverrides=",">
                        <if test="createBy != null">create_by,</if>
                        <if test="createTime != null">create_time,</if>
                        <if test="remark != null">remark,</if>
                        <!-- TODO: 添加其他字段 -->
                    </trim>
                    VALUES
                    <trim prefix="(" suffix=")" suffixOverrides=",">
                        <if test="createBy != null">#{createBy},</if>
                        <if test="createTime != null">#{createTime},</if>
                        <if test="remark != null">#{remark},</if>
                        <!-- TODO: 添加其他字段 -->
                    </trim>
                </insert>

                <update id="updateById" parameterType="%s">
                    UPDATE %s SET
                    <trim suffixOverrides=",">
                        <if test="updateBy != null">update_by = #{updateBy},</if>
                        <if test="updateTime != null">update_time = #{updateTime},</if>
                        <if test="remark != null">remark = #{remark},</if>
                        <!-- TODO: 添加其他字段 -->
                    </trim>
                    WHERE %s = #{%s}
                </update>

                <delete id="deleteById">
                    DELETE FROM %s WHERE %s = #{%s}
                </delete>

                <delete id="deleteByIds">
                    DELETE FROM %s WHERE %s IN
                    <foreach collection="array" item="id" open="(" separator="," close=")">#{id}</foreach>
                </delete>

                <select id="selectById" resultType="%s">
                    SELECT * FROM %s WHERE %s = #{%s}
                </select>

                <select id="selectAll" resultType="%s">
                    SELECT * FROM %s ORDER BY create_time DESC
                </select>

                <select id="selectList" parameterType="%s" resultType="%s">
                    SELECT * FROM %s
                    <where> <!-- TODO: 添加动态查询条件 --> </where>
                    ORDER BY create_time DESC
                </select>

                <select id="selectOne" parameterType="%s" resultType="%s">
                    SELECT * FROM %s
                    <where> <!-- TODO: 添加动态查询条件 --> </where>
                    LIMIT 1
                </select>

                <!-- ========== 自定义复杂查询 ========== -->
                <!-- TODO: 在此添加复杂查询，使用 resultMap 或直接 resultType -->

            </mapper>
            """.formatted(
                mapperClass,
                poClass, tableName,
                poClass, tableName, pkColumn, pkField,
                tableName, pkColumn, pkField,
                tableName, pkColumn,
                poClass, tableName, pkColumn, pkField,
                poClass, tableName,
                poClass, poClass, tableName,
                poClass, poClass, tableName
            );

        String xmlDir = baseDir + "/ruoyi-" + MODULE + "/src/main/resources/mapper/";
        Files.createDirectories(Paths.get(xmlDir));

        // 文件名首字母小写
        String fileName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
        writeFileToString(xmlDir + fileName + "Mapper.xml", content);
        System.out.println("  ✅ XML: mapper/" + fileName + "Mapper.xml");
    }

    // ==================== Service ====================
    private static void generateService(String baseDir, String className,
                                         String description, String pkg) throws Exception
    {
        String poClass = className + "PO";
        String poFullClass = pkg + ".domain.po." + poClass;
        String mapperClass = className + "Mapper";

        // 接口
        String serviceContent = """
            package %s.service;

            import com.ruoyi.common.core.service.BaseService;
            import %s;

            /**
             * %s Service
             */
            public interface I%sService extends BaseService<%s>
            {
                // 简单CRUD由BaseService提供，无需手动声明
                // 在此声明自定义业务方法
            }
            """.formatted(pkg, poFullClass, description, className, poClass);

        writeFile(baseDir, pkg.replace('.', '/') + "/service/I" + className + "Service.java", serviceContent);

        // 实现
        String implContent = """
            package %s.service.impl;

            import org.springframework.stereotype.Service;
            import com.ruoyi.common.core.service.BaseServiceImpl;
            import %s.mapper.%sMapper;
            import %s;

            /**
             * %s Service实现
             * 继承BaseServiceImpl获得通用CRUD，无需重复编写
             */
            @Service
            public class %sServiceImpl extends BaseServiceImpl<%sMapper, %s> implements I%sService
            {
                // 简单CRUD由BaseServiceImpl提供
                // 在此编写自定义业务逻辑
            }
            """.formatted(pkg, pkg, className, poFullClass, description, className, className, poClass, className);

        writeFile(baseDir, pkg.replace('.', '/') + "/service/impl/" + className + "ServiceImpl.java", implContent);
        System.out.println("  ✅ Service: I" + className + "Service + " + className + "ServiceImpl（继承BaseServiceImpl）");
    }

    // ==================== Controller ====================
    private static void generateController(String baseDir, String className,
                                            String description, String pkg) throws Exception
    {
        String lowerName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
        String content = """
            package %s.controller;

            import java.util.List;
            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.web.bind.annotation.*;
            import com.ruoyi.common.core.controller.BaseController;
            import com.ruoyi.common.core.domain.AjaxResult;
            import com.ruoyi.common.core.page.TableDataInfo;
            import com.ruoyi.common.utils.BeanConvertUtils;
            import %s.service.I%sService;
            import %s.domain.po.%sPO;
            import %s.domain.dto.%sDTO;
            import %s.domain.vo.%sVO;
            import %s.domain.query.%sQuery;
            import io.swagger.v3.oas.annotations.Operation;
            import io.swagger.v3.oas.annotations.tags.Tag;

            /**
             * %s Controller
             */
            @Tag(name = "%s")
            @RestController
            @RequestMapping("/%s/%s")
            public class %sController extends BaseController
            {
                @Autowired
                private I%sService %sService;

                /**
                 * 查询列表
                 */
                @Operation(summary = "获取%s列表")
                @GetMapping("/list")
                public TableDataInfo list(%sQuery query)
                {
                    startPage();
                    %sPO search = BeanConvertUtils.convert(query, %sPO.class);
                    List<%sPO> list = %sService.selectList(search);
                    return getDataTable(BeanConvertUtils.convertList(list, %sVO.class));
                }

                /**
                 * 获取详情
                 */
                @Operation(summary = "获取%s详情")
                @GetMapping("/{id}")
                public AjaxResult getInfo(@PathVariable Long id)
                {
                    return success(BeanConvertUtils.convert(%sService.selectById(id), %sVO.class));
                }

                /**
                 * 新增
                 */
                @Operation(summary = "新增%s")
                @PostMapping
                public AjaxResult add(@RequestBody %sDTO dto)
                {
                    %sPO po = BeanConvertUtils.convert(dto, %sPO.class);
                    return toAjax(%sService.insert(po));
                }

                /**
                 * 修改
                 */
                @Operation(summary = "修改%s")
                @PutMapping
                public AjaxResult edit(@RequestBody %sDTO dto)
                {
                    %sPO po = BeanConvertUtils.convert(dto, %sPO.class);
                    return toAjax(%sService.updateById(po));
                }

                /**
                 * 删除
                 */
                @Operation(summary = "删除%s")
                @DeleteMapping("/{ids}")
                public AjaxResult remove(@PathVariable Long[] ids)
                {
                    return toAjax(%sService.deleteByIds(ids));
                }
            }
            """.formatted(
                pkg,  // package
                pkg, className,  // service import
                pkg, className,  // PO import
                pkg, className,  // DTO import
                pkg, className,  // VO import
                pkg, className,  // Query import
                description,     // javadoc
                description,     // @Tag
                MODULE, lowerName, // @RequestMapping
                className,       // class name
                className, lowerName, // service field
                description,     // list Operation
                className,       // Query type
                className, className, // search
                className, className, // convertList
                description,     // getInfo Operation
                className, className, // convert
                description,     // add Operation
                className,       // DTO type
                className, className, className,
                description,     // edit Operation
                className,       // DTO type
                className, className, className,
                description,     // remove Operation
                className       // service
            );

        writeFile(baseDir, pkg.replace('.', '/') + "/controller/" + className + "Controller.java", content);
        System.out.println("  ✅ Controller: " + className + "Controller.java");
    }

    // ==================== 工具方法 ====================
    private static void writeFile(String baseDir, String relativePath, String content) throws Exception
    {
        Path filePath = Paths.get(baseDir, relativePath.replace('/', File.separatorChar));
        Files.createDirectories(filePath.getParent());
        Files.writeString(filePath, content, StandardCharsets.UTF_8);
    }

    private static void writeFileToString(String absolutePath, String content) throws Exception
    {
        Path filePath = Paths.get(absolutePath);
        Files.createDirectories(filePath.getParent());
        Files.writeString(filePath, content, StandardCharsets.UTF_8);
    }
}
