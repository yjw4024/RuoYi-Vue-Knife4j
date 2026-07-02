package com.ruoyi.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "角色信息响应")
public class SysRoleVO {
    @Schema(description = "角色ID") private Long roleId;
    @Schema(description = "角色名称") private String roleName;
    @Schema(description = "权限字符") private String roleKey;
    @Schema(description = "显示顺序") private Integer roleSort;
    @Schema(description = "数据范围") private String dataScope;
    @Schema(description = "菜单树关联") private Boolean menuCheckStrictly;
    @Schema(description = "部门树关联") private Boolean deptCheckStrictly;
    @Schema(description = "状态") private String status;
    @Schema(description = "删除标志") private String delFlag;
    @Schema(description = "管理员标识") private boolean admin;
    @Schema(description = "创建者") private String createBy;
    @Schema(description = "创建时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date createTime;
    @Schema(description = "更新者") private String updateBy;
    @Schema(description = "更新时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date updateTime;
    @Schema(description = "备注") private String remark;
    @Schema(description = "菜单ID列表") private Long[] menuIds;
    @Schema(description = "部门ID列表") private Long[] deptIds;
    public Long getRoleId() { return roleId; } public void setRoleId(Long roleId) { this.roleId = roleId; }
    public String getRoleName() { return roleName; } public void setRoleName(String roleName) { this.roleName = roleName; }
    public String getRoleKey() { return roleKey; } public void setRoleKey(String roleKey) { this.roleKey = roleKey; }
    public Integer getRoleSort() { return roleSort; } public void setRoleSort(Integer roleSort) { this.roleSort = roleSort; }
    public String getDataScope() { return dataScope; } public void setDataScope(String dataScope) { this.dataScope = dataScope; }
    public Boolean getMenuCheckStrictly() { return menuCheckStrictly; } public void setMenuCheckStrictly(Boolean v) { this.menuCheckStrictly = v; }
    public Boolean getDeptCheckStrictly() { return deptCheckStrictly; } public void setDeptCheckStrictly(Boolean v) { this.deptCheckStrictly = v; }
    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }
    public String getDelFlag() { return delFlag; } public void setDelFlag(String delFlag) { this.delFlag = delFlag; }
    public boolean isAdmin() { return admin; } public void setAdmin(boolean admin) { this.admin = admin; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String createBy) { this.createBy = createBy; }
    public Date getCreateTime() { return createTime; } public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public String getUpdateBy() { return updateBy; } public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
    public Date getUpdateTime() { return updateTime; } public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
    public String getRemark() { return remark; } public void setRemark(String remark) { this.remark = remark; }
    public Long[] getMenuIds() { return menuIds; } public void setMenuIds(Long[] menuIds) { this.menuIds = menuIds; }
    public Long[] getDeptIds() { return deptIds; } public void setDeptIds(Long[] deptIds) { this.deptIds = deptIds; }
}
