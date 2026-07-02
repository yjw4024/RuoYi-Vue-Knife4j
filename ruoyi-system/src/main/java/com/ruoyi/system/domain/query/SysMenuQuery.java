package com.ruoyi.system.domain.query;
import java.util.HashMap; import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "菜单查询")
public class SysMenuQuery {
    @Schema(description = "菜单名称") private String menuName;
    @Schema(description = "状态") private String status;
    @Schema(description = "请求参数") private Map<String, Object> params;
    public String getMenuName() { return menuName; } public void setMenuName(String v) { this.menuName = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
    public void setParams(Map<String, Object> v) { this.params = v; }
}
