package com.ruoyi.system.domain.dto;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "部门新增/修改请求")
public class SysDeptDTO {
    @Schema(description = "部门ID") private Long deptId;
    @Schema(description = "父部门ID") private Long parentId;
    @NotBlank(message = "部门名称不能为空") @Schema(description = "部门名称", required = true) private String deptName;
    @Schema(description = "显示顺序") private Integer orderNum;
    @Schema(description = "负责人") private String leader;
    @Schema(description = "联系电话") private String phone;
    @Schema(description = "邮箱") private String email;
    @Schema(description = "状态") private String status;
    @Schema(description = "备注") private String remark;
    public Long getDeptId() { return deptId; } public void setDeptId(Long v) { this.deptId = v; }
    public Long getParentId() { return parentId; } public void setParentId(Long v) { this.parentId = v; }
    public String getDeptName() { return deptName; } public void setDeptName(String v) { this.deptName = v; }
    public Integer getOrderNum() { return orderNum; } public void setOrderNum(Integer v) { this.orderNum = v; }
    public String getLeader() { return leader; } public void setLeader(String v) { this.leader = v; }
    public String getPhone() { return phone; } public void setPhone(String v) { this.phone = v; }
    public String getEmail() { return email; } public void setEmail(String v) { this.email = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
