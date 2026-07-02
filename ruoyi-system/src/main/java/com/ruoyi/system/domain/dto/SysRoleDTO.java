package com.ruoyi.system.domain.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "角色新增/修改请求")
public class SysRoleDTO {
    @Schema(description = "角色ID") private Long roleId;
    @NotBlank(message = "角色名称不能为空") @Schema(description = "角色名称", required = true) private String roleName;
    @NotBlank(message = "权限字符不能为空") @Schema(description = "权限字符", required = true) private String roleKey;
    @Schema(description = "显示顺序") private Integer roleSort;
    @Schema(description = "数据范围") private String dataScope;
    @Schema(description = "菜单树关联") private Boolean menuCheckStrictly;
    @Schema(description = "部门树关联") private Boolean deptCheckStrictly;
    @Schema(description = "状态") private String status;
    @Schema(description = "菜单ID列表") private Long[] menuIds;
    @Schema(description = "部门ID列表") private Long[] deptIds;
    @Schema(description = "备注") private String remark;
    public Long getRoleId() { return roleId; } public void setRoleId(Long roleId) { this.roleId = roleId; }
    public String getRoleName() { return roleName; } public void setRoleName(String roleName) { this.roleName = roleName; }
    public String getRoleKey() { return roleKey; } public void setRoleKey(String roleKey) { this.roleKey = roleKey; }
    public Integer getRoleSort() { return roleSort; } public void setRoleSort(Integer roleSort) { this.roleSort = roleSort; }
    public String getDataScope() { return dataScope; } public void setDataScope(String dataScope) { this.dataScope = dataScope; }
    public Boolean getMenuCheckStrictly() { return menuCheckStrictly; } public void setMenuCheckStrictly(Boolean menuCheckStrictly) { this.menuCheckStrictly = menuCheckStrictly; }
    public Boolean getDeptCheckStrictly() { return deptCheckStrictly; } public void setDeptCheckStrictly(Boolean deptCheckStrictly) { this.deptCheckStrictly = deptCheckStrictly; }
    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }
    public Long[] getMenuIds() { return menuIds; } public void setMenuIds(Long[] menuIds) { this.menuIds = menuIds; }
    public Long[] getDeptIds() { return deptIds; } public void setDeptIds(Long[] deptIds) { this.deptIds = deptIds; }
    public String getRemark() { return remark; } public void setRemark(String remark) { this.remark = remark; }
}
