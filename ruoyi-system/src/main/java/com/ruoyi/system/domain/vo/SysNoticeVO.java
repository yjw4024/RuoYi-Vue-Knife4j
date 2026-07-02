package com.ruoyi.system.domain.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "通知公告响应")
public class SysNoticeVO {
    @Schema(description = "公告ID") private Long noticeId;
    @Schema(description = "公告标题") private String noticeTitle;
    @Schema(description = "公告类型") private String noticeType;
    @Schema(description = "公告内容") private String noticeContent;
    @Schema(description = "状态") private String status;
    @Schema(description = "创建者") private String createBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "创建时间") private Date createTime;
    @Schema(description = "更新者") private String updateBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "更新时间") private Date updateTime;
    @Schema(description = "备注") private String remark;
    @Schema(description = "是否已读") private boolean isRead;
    public Long getNoticeId() { return noticeId; } public void setNoticeId(Long v) { this.noticeId = v; }
    public String getNoticeTitle() { return noticeTitle; } public void setNoticeTitle(String v) { this.noticeTitle = v; }
    public String getNoticeType() { return noticeType; } public void setNoticeType(String v) { this.noticeType = v; }
    public String getNoticeContent() { return noticeContent; } public void setNoticeContent(String v) { this.noticeContent = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String v) { this.createBy = v; }
    public Date getCreateTime() { return createTime; } public void setCreateTime(Date v) { this.createTime = v; }
    public String getUpdateBy() { return updateBy; } public void setUpdateBy(String v) { this.updateBy = v; }
    public Date getUpdateTime() { return updateTime; } public void setUpdateTime(Date v) { this.updateTime = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
    public boolean isRead() { return isRead; } public void setRead(boolean v) { this.isRead = v; }
}
