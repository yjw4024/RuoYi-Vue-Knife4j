package com.ruoyi.common.core.domain;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * DTO基类，所有DTO继承此类
 *
 * @author ruoyi
 */
@Data
@Schema(description = "DTO基类")
public class BaseDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Schema(description = "备注")
    private String remark;
}
