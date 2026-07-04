package com.ruoyi.common.core.domain;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分页查询基类，所有 Query 类继承此类
 *
 * @author YiJiawei
 * @date 2026/7/4
 */
@Data
@Schema(description = "分页查询基类")
public class PageQuery implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Schema(description = "当前页码", example = "1")
    private Integer pageNum = 1;

    @Schema(description = "每页条数", example = "10")
    private Integer pageSize = 10;
}
