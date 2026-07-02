package com.ruoyi.quartz.domain.dto;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "定时任务新增/修改请求")
public class SysJobDTO {
    @Schema(description = "任务ID") private Long jobId;
    @NotBlank(message = "任务名称不能为空") @Schema(description = "任务名称", required = true) private String jobName;
    @NotBlank(message = "任务组名不能为空") @Schema(description = "任务组名", required = true) private String jobGroup;
    @NotBlank(message = "调用目标不能为空") @Schema(description = "调用目标", required = true) private String invokeTarget;
    @NotBlank(message = "Cron表达式不能为空") @Schema(description = "Cron表达式", required = true) private String cronExpression;
    @Schema(description = "错误策略") private String misfirePolicy;
    @Schema(description = "是否并发") private String concurrent;
    @Schema(description = "状态") private String status;
    @Schema(description = "备注") private String remark;
    public Long getJobId() { return jobId; } public void setJobId(Long v) { this.jobId = v; }
    public String getJobName() { return jobName; } public void setJobName(String v) { this.jobName = v; }
    public String getJobGroup() { return jobGroup; } public void setJobGroup(String v) { this.jobGroup = v; }
    public String getInvokeTarget() { return invokeTarget; } public void setInvokeTarget(String v) { this.invokeTarget = v; }
    public String getCronExpression() { return cronExpression; } public void setCronExpression(String v) { this.cronExpression = v; }
    public String getMisfirePolicy() { return misfirePolicy; } public void setMisfirePolicy(String v) { this.misfirePolicy = v; }
    public String getConcurrent() { return concurrent; } public void setConcurrent(String v) { this.concurrent = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
