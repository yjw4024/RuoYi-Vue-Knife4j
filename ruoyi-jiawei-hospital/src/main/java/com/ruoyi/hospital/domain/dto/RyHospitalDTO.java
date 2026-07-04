package com.ruoyi.hospital.domain.dto;

import com.ruoyi.common.core.domain.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医院新增/修改请求
 *
 * @author ruoyi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "医院新增/修改请求")
public class RyHospitalDTO extends BaseDTO
{
    @Schema(description = "医院ID")
    private String id;

    @NotBlank(message = "医院名称不能为空")
    @Schema(description = "名院名称", required = true)
    private String hospitalName;

    @Schema(description = "医院等级")
    private String hospitalGrade;

    @Schema(description = "医院标签")
    private String hospitalLabel;

    @Schema(description = "封面")
    private String hospitalCover;

    @Schema(description = "医院地址")
    private String hospitalAddress;

    @Schema(description = "医院简介")
    private String briefIntroduction;

    @Schema(description = "附件ids")
    private String enclosures;

    @Schema(description = "医疗特色")
    private String hospital;

    @Schema(description = "医院位置")
    private String hospitalPosition;

    @Schema(description = "医院经纬度")
    private String hospitalLongitude;

    @NotBlank(message = "地区id不能为空")
    @Schema(description = "地区id", required = true)
    private String regionId;

    @Schema(description = "排序字段")
    private Integer sort;
}
