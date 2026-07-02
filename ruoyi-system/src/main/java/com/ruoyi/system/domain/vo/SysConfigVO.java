package com.ruoyi.system.domain.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "参数配置响应")
public class SysConfigVO {
    @Schema(description = "参数ID") private Long configId;
    @Schema(description = "参数名称") private String configName;
    @Schema(description = "参数键名") private String configKey;
    @Schema(description = "参数键值") private String configValue;
    @Schema(description = "系统内置") private String configType;
    @Schema(description = "创建者") private String createBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "创建时间") private Date createTime;
    @Schema(description = "更新者") private String updateBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "更新时间") private Date updateTime;
    @Schema(description = "备注") private String remark;
    public Long getConfigId() { return configId; } public void setConfigId(Long v) { this.configId = v; }
    public String getConfigName() { return configName; } public void setConfigName(String v) { this.configName = v; }
    public String getConfigKey() { return configKey; } public void setConfigKey(String v) { this.configKey = v; }
    public String getConfigValue() { return configValue; } public void setConfigValue(String v) { this.configValue = v; }
    public String getConfigType() { return configType; } public void setConfigType(String v) { this.configType = v; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String v) { this.createBy = v; }
    public Date getCreateTime() { return createTime; } public void setCreateTime(Date v) { this.createTime = v; }
    public String getUpdateBy() { return updateBy; } public void setUpdateBy(String v) { this.updateBy = v; }
    public Date getUpdateTime() { return updateTime; } public void setUpdateTime(Date v) { this.updateTime = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
