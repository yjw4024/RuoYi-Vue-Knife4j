package com.ruoyi.hospital.domain.po;

import com.ruoyi.common.core.po.BusinessPO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医院表 PO (对应 ry_hospital 表)
 *
 * @author YiJiawei
 * @date 2026/7/4
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "医院")
public class RyHospital extends BusinessPO
{
    private static final long serialVersionUID = 1L;

    @Schema(description = "名院名称")
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

    @Schema(description = "排序字段")
    private Integer sort;

    @Schema(description = "医院经纬度")
    private String hospitalLongitude;

    @Schema(description = "地区id")
    private String regionId;
}
