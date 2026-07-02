package com.ruoyi.quartz.domain.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "定时任务响应")
public class SysJobVO {
    @Schema(description = "任务ID") private Long jobId;
    @Schema(description = "任务名称") private String jobName;
    @Schema(description = "任务组名") private String jobGroup;
    @Schema(description = "调用目标") private String invokeTarget;
    @Schema(description = "Cron表达式") private String cronExpression;
    @Schema(description = "错误策略") private String misfirePolicy;
    @Schema(description = "是否并发") private String concurrent;
    @Schema(description = "状态") private String status;
    @Schema(description = "创建者") private String createBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "创建时间") private Date createTime;
    @Schema(description = "更新者") private String updateBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "更新时间") private Date updateTime;
    @Schema(description = "备注") private String remark;
    public Long getJobId() { return jobId; } public void setJobId(Long v) { this.jobId = v; }
    public String getJobName() { return jobName; } public void setJobName(String v) { this.jobName = v; }
    public String getJobGroup() { return jobGroup; } public void setJobGroup(String v) { this.jobGroup = v; }
    public String getInvokeTarget() { return invokeTarget; } public void setInvokeTarget(String v) { this.invokeTarget = v; }
    public String getCronExpression() { return cronExpression; } public void setCronExpression(String v) { this.cronExpression = v; }
    public String getMisfirePolicy() { return misfirePolicy; } public void setMisfirePolicy(String v) { this.misfirePolicy = v; }
    public String getConcurrent() { return concurrent; } public void setConcurrent(String v) { this.concurrent = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String v) { this.createBy = v; }
    public Date getCreateTime() { return createTime; } public void setCreateTime(Date v) { this.createTime = v; }
    public String getUpdateBy() { return updateBy; } public void setUpdateBy(String v) { this.updateBy = v; }
    public Date getUpdateTime() { return updateTime; } public void setUpdateTime(Date v) { this.updateTime = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
