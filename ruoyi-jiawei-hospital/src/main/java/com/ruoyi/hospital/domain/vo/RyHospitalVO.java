package com.ruoyi.hospital.domain.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 医院响应 VO
 *
 * @author ruoyi
 * @date 2026-07-02
 */
@Data
@Schema(description = "医院响应")
public class RyHospitalVO
{
    @Schema(description = "医院ID")
    private String id;

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

    @Schema(description = "医院经纬度")
    private String hospitalLongitude;

    @Schema(description = "地区id")
    private String regionId;

    @Schema(description = "排序字段")
    private Integer sort;

    @Schema(description = "备注")
    private String memo;

    @Schema(description = "创建人")
    private String createUserName;

    @Schema(description = "修改人姓名")
    private String updateUserName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "修改时间")
    private Date updateTime;
}
