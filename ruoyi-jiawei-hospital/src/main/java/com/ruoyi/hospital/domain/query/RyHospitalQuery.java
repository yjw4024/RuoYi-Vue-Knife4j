package com.ruoyi.hospital.domain.query;

import com.ruoyi.common.core.domain.PageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医院查询
 *
 * @author ruoyi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "医院查询")
public class RyHospitalQuery extends PageQuery
{
    @Schema(description = "名院名称")
    private String hospitalName;

    @Schema(description = "医院等级")
    private String hospitalGrade;

    @Schema(description = "地区id")
    private String regionId;

    @Schema(description = "是否删除")
    private Integer isDeleted;
}
