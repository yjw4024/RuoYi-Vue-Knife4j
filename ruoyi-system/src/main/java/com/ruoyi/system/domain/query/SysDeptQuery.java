package com.ruoyi.system.domain.query;
import java.util.HashMap; import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "部门查询")
public class SysDeptQuery {
    @Schema(description = "部门名称") private String deptName;
    @Schema(description = "状态") private String status;
    @Schema(description = "请求参数") private Map<String, Object> params;
    public String getDeptName() { return deptName; } public void setDeptName(String v) { this.deptName = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
    public void setParams(Map<String, Object> v) { this.params = v; }
}
