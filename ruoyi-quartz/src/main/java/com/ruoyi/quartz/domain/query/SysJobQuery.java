package com.ruoyi.quartz.domain.query;
import java.util.HashMap; import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "定时任务查询")
public class SysJobQuery {
    @Schema(description = "任务名称") private String jobName;
    @Schema(description = "任务组名") private String jobGroup;
    @Schema(description = "状态") private String status;
    @Schema(description = "请求参数") private Map<String, Object> params;
    public String getJobName() { return jobName; } public void setJobName(String v) { this.jobName = v; }
    public String getJobGroup() { return jobGroup; } public void setJobGroup(String v) { this.jobGroup = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
    public void setParams(Map<String, Object> v) { this.params = v; }
}
