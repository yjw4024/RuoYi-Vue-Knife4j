package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通知公告新增/修改请求
 *
 * @author ruoyi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "通知公告新增/修改请求")
public class SysNoticeDTO extends BaseDTO
{
    @Schema(description = "公告ID")
    private Long noticeId;

    @NotBlank(message = "公告标题不能为空")
    @Schema(description = "公告标题", required = true)
    private String noticeTitle;

    @Schema(description = "公告类型（1=通知 2=公告）")
    private String noticeType;

    @NotBlank(message = "公告内容不能为空")
    @Schema(description = "公告内容")
    private String noticeContent;

    @Schema(description = "公告状态（0=正常 1=关闭）")
    private String status;
}
