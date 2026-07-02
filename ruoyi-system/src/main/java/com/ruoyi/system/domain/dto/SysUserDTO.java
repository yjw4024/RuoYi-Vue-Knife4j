package com.ruoyi.system.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户新增/修改请求DTO
 *
 * @author ruoyi
 */
@Schema(description = "用户新增/修改请求")
public class  SysUserDTO
{
    /** 用户ID（修改时必填） */
    @Schema(description = "用户ID")
    private Long userId;

    /** 部门ID */
    @Schema(description = "部门ID")
    private Long deptId;

    /** 用户账号 */
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    @Schema(description = "用户账号", required = true)
    private String userName;

    /** 用户昵称 */
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    @Schema(description = "用户昵称")
    private String nickName;

    /** 用户邮箱 */
    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    @Schema(description = "用户邮箱")
    private String email;

    /** 手机号码 */
    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    @Schema(description = "手机号码")
    private String phonenumber;

    /** 用户性别 */
    @Schema(description = "用户性别（0=男,1=女,2=未知）")
    private String sex;

    /** 密码 */
    @Schema(description = "密码")
    private String password;

    /** 帐号状态 */
    @Schema(description = "帐号状态（0=正常,1=停用）")
    private String status;

    /** 角色ID列表 */
    @Schema(description = "角色ID列表")
    private Long[] roleIds;

    /** 岗位ID列表 */
    @Schema(description = "岗位ID列表")
    private Long[] postIds;

    /** 备注 */
    @Schema(description = "备注")
    private String remark;

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
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long[] getRoleIds() { return roleIds; }
    public void setRoleIds(Long[] roleIds) { this.roleIds = roleIds; }
    public Long[] getPostIds() { return postIds; }
    public void setPostIds(Long[] postIds) { this.postIds = postIds; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
