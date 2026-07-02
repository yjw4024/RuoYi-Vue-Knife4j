package com.ruoyi.system.domain.dto;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "参数配置新增/修改请求")
public class SysConfigDTO {
    @Schema(description = "参数ID") private Long configId;
    @NotBlank(message = "参数名称不能为空") @Schema(description = "参数名称", required = true) private String configName;
    @NotBlank(message = "参数键名不能为空") @Schema(description = "参数键名", required = true) private String configKey;
    @NotBlank(message = "参数键值不能为空") @Schema(description = "参数键值", required = true) private String configValue;
    @Schema(description = "系统内置") private String configType;
    @Schema(description = "备注") private String remark;
    public Long getConfigId() { return configId; } public void setConfigId(Long v) { this.configId = v; }
    public String getConfigName() { return configName; } public void setConfigName(String v) { this.configName = v; }
    public String getConfigKey() { return configKey; } public void setConfigKey(String v) { this.configKey = v; }
    public String getConfigValue() { return configValue; } public void setConfigValue(String v) { this.configValue = v; }
    public String getConfigType() { return configType; } public void setConfigType(String v) { this.configType = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
