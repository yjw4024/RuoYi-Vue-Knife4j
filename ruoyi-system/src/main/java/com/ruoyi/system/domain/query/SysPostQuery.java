package com.ruoyi.system.domain.query;
import java.util.HashMap; import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "岗位查询") public class SysPostQuery {
@Schema(description = "岗位编码") private String postCode;
@Schema(description = "岗位名称") private String postName;
@Schema(description = "状态") private String status;
@Schema(description = "请求参数") private Map<String, Object> params;
public String getPostCode() { return postCode; } public void setPostCode(String v) { this.postCode = v; }
public String getPostName() { return postName; } public void setPostName(String v) { this.postName = v; }
public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
public void setParams(Map<String, Object> v) { this.params = v; }
}
