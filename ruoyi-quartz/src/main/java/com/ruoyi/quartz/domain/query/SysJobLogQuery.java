package com.ruoyi.quartz.domain.query;
import java.util.Date; import java.util.HashMap; import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "定时任务日志查询")
public class SysJobLogQuery {
    @Schema(description = "任务名称") private String jobName;
    @Schema(description = "任务组名") private String jobGroup;
    @Schema(description = "执行状态") private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "开始时间") private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "结束时间") private Date endTime;
    @Schema(description = "请求参数") private Map<String,Object> params;
    public String getJobName() { return jobName; } public void setJobName(String v) { this.jobName = v; }
    public String getJobGroup() { return jobGroup; } public void setJobGroup(String v) { this.jobGroup = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public Date getBeginTime() { return beginTime; } public void setBeginTime(Date v) { this.beginTime = v; }
    public Date getEndTime() { return endTime; } public void setEndTime(Date v) { this.endTime = v; }
    public Map<String,Object> getParams() { if(params==null) params=new HashMap<>(); return params; }
    public void setParams(Map<String,Object> v) { this.params = v; }
}
