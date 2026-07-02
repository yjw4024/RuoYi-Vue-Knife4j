package com.ruoyi.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户响应VO（不含密码等敏感字段）
 *
 * @author ruoyi
 */
@Schema(description = "用户信息响应")
public class SysUserVO
{
    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "部门ID")
    private Long deptId;

    @Schema(description = "用户账号")
    private String userName;

    @Schema(description = "用户昵称")
    private String nickName;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "手机号码")
    private String phonenumber;

    @Schema(description = "用户性别")
    private String sex;

    @Schema(description = "头像地址")
    private String avatar;

    @Schema(description = "帐号状态")
    private String status;

    @Schema(description = "最后登录IP")
    private String loginIp;

    @Schema(description = "最后登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginDate;

    @Schema(description = "密码最后修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pwdUpdateDate;

    @Schema(description = "创建者")
    private String createBy;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Schema(description = "更新者")
    private String updateBy;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "部门信息")
    private SysDept dept;

    @Schema(description = "角色列表")
    private java.util.List<SysRole> roles;

    @Schema(description = "角色ID列表")
    private Long[] roleIds;

    @Schema(description = "岗位ID列表")
    private Long[] postIds;

    // ========== Getter/Setter ==========
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getDeptId() { return deptId; }
    public void setDeptId(Long deptId) { this.deptId = deptId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getNickName() { return nickName; }
    public void setNickName(String nickName) { this.nickName = nickName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getLoginIp() { return loginIp; }
    public void setLoginIp(String loginIp) { this.loginIp = loginIp; }
    public Date getLoginDate() { return loginDate; }
    public void setLoginDate(Date loginDate) { this.loginDate = loginDate; }
    public Date getPwdUpdateDate() { return pwdUpdateDate; }
    public void setPwdUpdateDate(Date pwdUpdateDate) { this.pwdUpdateDate = pwdUpdateDate; }
    public String getCreateBy() { return createBy; }
    public void setCreateBy(String createBy) { this.createBy = createBy; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public SysDept getDept() { return dept; }
    public void setDept(SysDept dept) { this.dept = dept; }
    public java.util.List<SysRole> getRoles() { return roles; }
    public void setRoles(java.util.List<SysRole> roles) { this.roles = roles; }
    public Long[] getRoleIds() { return roleIds; }
    public void setRoleIds(Long[] roleIds) { this.roleIds = roleIds; }
    public Long[] getPostIds() { return postIds; }
    public void setPostIds(Long[] postIds) { this.postIds = postIds; }
}
