package com.ruoyi.common.core.domain;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * DTO基类（自增Long主键，参考 dc.base.BusinessIntFormDTO）
 *
 * @author YiJiawei
 * @date 2026/7/4
 */
@Data
@Schema(description = "DTO基类（Long主键）")
public class BaseIntDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "乐观锁版本号")
    private Integer version;

    @Schema(description = "备注")
    private String memo;
}
