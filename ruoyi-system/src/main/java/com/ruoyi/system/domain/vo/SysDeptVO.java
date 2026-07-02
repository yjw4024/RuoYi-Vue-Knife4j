package com.ruoyi.system.domain.vo;
import java.util.Date; import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "部门信息响应")
public class SysDeptVO {
    @Schema(description = "部门ID") private Long deptId;
    @Schema(description = "父部门ID") private Long parentId;
    @Schema(description = "祖级列表") private String ancestors;
    @Schema(description = "部门名称") private String deptName;
    @Schema(description = "显示顺序") private Integer orderNum;
    @Schema(description = "负责人") private String leader;
    @Schema(description = "联系电话") private String phone;
    @Schema(description = "邮箱") private String email;
    @Schema(description = "状态") private String status;
    @Schema(description = "删除标志") private String delFlag;
    @Schema(description = "父部门名称") private String parentName;
    @Schema(description = "子部门") private List<SysDeptVO> children;
    @Schema(description = "创建者") private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "创建时间") private Date createTime;
    @Schema(description = "更新者") private String updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "更新时间") private Date updateTime;
    @Schema(description = "备注") private String remark;
    public Long getDeptId() { return deptId; } public void setDeptId(Long v) { this.deptId = v; }
    public Long getParentId() { return parentId; } public void setParentId(Long v) { this.parentId = v; }
    public String getAncestors() { return ancestors; } public void setAncestors(String v) { this.ancestors = v; }
    public String getDeptName() { return deptName; } public void setDeptName(String v) { this.deptName = v; }
    public Integer getOrderNum() { return orderNum; } public void setOrderNum(Integer v) { this.orderNum = v; }
    public String getLeader() { return leader; } public void setLeader(String v) { this.leader = v; }
    public String getPhone() { return phone; } public void setPhone(String v) { this.phone = v; }
    public String getEmail() { return email; } public void setEmail(String v) { this.email = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getDelFlag() { return delFlag; } public void setDelFlag(String v) { this.delFlag = v; }
    public String getParentName() { return parentName; } public void setParentName(String v) { this.parentName = v; }
    public List<SysDeptVO> getChildren() { return children; } public void setChildren(List<SysDeptVO> v) { this.children = v; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String v) { this.createBy = v; }
    public Date getCreateTime() { return createTime; } public void setCreateTime(Date v) { this.createTime = v; }
    public String getUpdateBy() { return updateBy; } public void setUpdateBy(String v) { this.updateBy = v; }
    public Date getUpdateTime() { return updateTime; } public void setUpdateTime(Date v) { this.updateTime = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
