package com.ruoyi.quartz.domain.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "定时任务日志响应")
public class SysJobLogVO {
    @Schema(description = "日志ID") private Long jobLogId;
    @Schema(description = "任务名称") private String jobName;
    @Schema(description = "任务组名") private String jobGroup;
    @Schema(description = "调用目标") private String invokeTarget;
    @Schema(description = "日志信息") private String jobMessage;
    @Schema(description = "执行状态") private String status;
    @Schema(description = "异常信息") private String exceptionInfo;
    @Schema(description = "开始时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date startTime;
    @Schema(description = "结束时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date endTime;
    public Long getJobLogId() { return jobLogId; } public void setJobLogId(Long v) { this.jobLogId = v; }
    public String getJobName() { return jobName; } public void setJobName(String v) { this.jobName = v; }
    public String getJobGroup() { return jobGroup; } public void setJobGroup(String v) { this.jobGroup = v; }
    public String getInvokeTarget() { return invokeTarget; } public void setInvokeTarget(String v) { this.invokeTarget = v; }
    public String getJobMessage() { return jobMessage; } public void setJobMessage(String v) { this.jobMessage = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getExceptionInfo() { return exceptionInfo; } public void setExceptionInfo(String v) { this.exceptionInfo = v; }
    public Date getStartTime() { return startTime; } public void setStartTime(Date v) { this.startTime = v; }
    public Date getEndTime() { return endTime; } public void setEndTime(Date v) { this.endTime = v; }
}
