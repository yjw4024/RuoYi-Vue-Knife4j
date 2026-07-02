package com.ruoyi.system.domain.query;
import java.util.Date; import java.util.HashMap; import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "参数配置查询")
public class SysConfigQuery {
    @Schema(description = "参数名称") private String configName;
    @Schema(description = "参数键名") private String configKey;
    @Schema(description = "系统内置") private String configType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "开始时间") private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "结束时间") private Date endTime;
    @Schema(description = "请求参数") private Map<String, Object> params;
    public String getConfigName() { return configName; } public void setConfigName(String v) { this.configName = v; }
    public String getConfigKey() { return configKey; } public void setConfigKey(String v) { this.configKey = v; }
    public String getConfigType() { return configType; } public void setConfigType(String v) { this.configType = v; }
    public Date getBeginTime() { return beginTime; } public void setBeginTime(Date v) { this.beginTime = v; }
    public Date getEndTime() { return endTime; } public void setEndTime(Date v) { this.endTime = v; }
    public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
    public void setParams(Map<String, Object> v) { this.params = v; }
}
