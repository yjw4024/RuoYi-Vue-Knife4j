package com.ruoyi.system.domain.vo;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "缓存信息响应")
public class SysCacheVO {
    @Schema(description = "缓存名称") private String cacheName;
    @Schema(description = "缓存键名") private String cacheKey;
    @Schema(description = "缓存内容") private String cacheValue;
    @Schema(description = "备注") private String remark;
    public String getCacheName() { return cacheName; } public void setCacheName(String v) { this.cacheName = v; }
    public String getCacheKey() { return cacheKey; } public void setCacheKey(String v) { this.cacheKey = v; }
    public String getCacheValue() { return cacheValue; } public void setCacheValue(String v) { this.cacheValue = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
