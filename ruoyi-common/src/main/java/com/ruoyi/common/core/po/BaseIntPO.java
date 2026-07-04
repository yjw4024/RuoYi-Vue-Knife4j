package com.ruoyi.common.core.po;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * PO基类（自增Long主键，参考 dc.base.BaseIntPO）
 *
 * @author YiJiawei
 * @date 2026/7/4
 */
@Data
@Schema(description = "PO基类（Long主键）")
public class BaseIntPO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建时间")
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "修改时间")
    private Date gmtModified;
}
