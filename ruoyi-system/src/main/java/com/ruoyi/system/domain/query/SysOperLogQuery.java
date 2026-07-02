package com.ruoyi.system.domain.query;
import java.util.Date; import java.util.HashMap; import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "操作日志查询")
public class SysOperLogQuery {
    @Schema(description = "操作人员") private String operName;
    @Schema(description = "操作模块") private String title;
    @Schema(description = "业务类型") private Integer businessType;
    @Schema(description = "状态") private Integer status;
    @Schema(description = "开始时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date beginTime;
    @Schema(description = "结束时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date endTime;
    @Schema(description = "请求参数") private Map<String, Object> params;
    public String getOperName() { return operName; } public void setOperName(String v) { this.operName = v; }
    public String getTitle() { return title; } public void setTitle(String v) { this.title = v; }
    public Integer getBusinessType() { return businessType; } public void setBusinessType(Integer v) { this.businessType = v; }
    public Integer getStatus() { return status; } public void setStatus(Integer v) { this.status = v; }
    public Date getBeginTime() { return beginTime; } public void setBeginTime(Date v) { this.beginTime = v; }
    public Date getEndTime() { return endTime; } public void setEndTime(Date v) { this.endTime = v; }
    public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
    public void setParams(Map<String, Object> v) { this.params = v; }
}
