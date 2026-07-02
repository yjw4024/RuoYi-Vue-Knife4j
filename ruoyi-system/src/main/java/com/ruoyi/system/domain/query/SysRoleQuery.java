package com.ruoyi.system.domain.query;

import java.util.Date; import java.util.HashMap; import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "角色分页查询")
public class SysRoleQuery {
    @Schema(description = "角色名称") private String roleName;
    @Schema(description = "权限字符") private String roleKey;
    @Schema(description = "状态") private String status;
    @Schema(description = "开始时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date beginTime;
    @Schema(description = "结束时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date endTime;
    @Schema(description = "请求参数") private Map<String, Object> params;
    public String getRoleName() { return roleName; } public void setRoleName(String roleName) { this.roleName = roleName; }
    public String getRoleKey() { return roleKey; } public void setRoleKey(String roleKey) { this.roleKey = roleKey; }
    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }
    public Date getBeginTime() { return beginTime; } public void setBeginTime(Date beginTime) { this.beginTime = beginTime; }
    public Date getEndTime() { return endTime; } public void setEndTime(Date endTime) { this.endTime = endTime; }
    public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
    public void setParams(Map<String, Object> params) { this.params = params; }
}
