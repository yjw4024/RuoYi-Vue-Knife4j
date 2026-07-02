package com.ruoyi.system.domain.dto;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "通知公告新增/修改请求")
public class SysNoticeDTO {
    @Schema(description = "公告ID") private Long noticeId;
    @NotBlank(message = "公告标题不能为空") @Schema(description = "公告标题", required = true) private String noticeTitle;
    @Schema(description = "公告类型") private String noticeType;
    @NotBlank(message = "公告内容不能为空") @Schema(description = "公告内容") private String noticeContent;
    @Schema(description = "状态") private String status;
    @Schema(description = "备注") private String remark;
    public Long getNoticeId() { return noticeId; } public void setNoticeId(Long v) { this.noticeId = v; }
    public String getNoticeTitle() { return noticeTitle; } public void setNoticeTitle(String v) { this.noticeTitle = v; }
    public String getNoticeType() { return noticeType; } public void setNoticeType(String v) { this.noticeType = v; }
    public String getNoticeContent() { return noticeContent; } public void setNoticeContent(String v) { this.noticeContent = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
