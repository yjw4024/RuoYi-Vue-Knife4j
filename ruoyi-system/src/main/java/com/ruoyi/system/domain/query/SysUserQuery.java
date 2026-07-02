package com.ruoyi.system.domain.query;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户分页查询对象
 *
 * @author ruoyi
 */
@Schema(description = "用户分页查询")
public class SysUserQuery
{
    /** 搜索值 */
    @Schema(description = "搜索值")
    private String searchValue;

    /** 用户账号 */
    @Schema(description = "用户账号")
    private String userName;

    /** 用户昵称 */
    @Schema(description = "用户昵称")
    private String nickName;

    /** 手机号码 */
    @Schema(description = "手机号码")
    private String phonenumber;

    /** 用户性别 */
    @Schema(description = "用户性别")
    private String sex;

    /** 帐号状态 */
    @Schema(description = "帐号状态（0=正常 1=停用）")
    private String status;

    /** 部门ID */
    @Schema(description = "部门ID")
    private Long deptId;

    /** 开始时间 */
    @Schema(description = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    /** 结束时间 */
    @Schema(description = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 请求参数（扩展） */
    @Schema(description = "请求参数")
    private java.util.Map<String, Object> params;

    // ========== Getter/Setter ==========
    public String getSearchValue() { return searchValue; }
    public void setSearchValue(String searchValue) { this.searchValue = searchValue; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getNickName() { return nickName; }
    public void setNickName(String nickName) { this.nickName = nickName; }
    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getDeptId() { return deptId; }
    public void setDeptId(Long deptId) { this.deptId = deptId; }
    public Date getBeginTime() { return beginTime; }
    public void setBeginTime(Date beginTime) { this.beginTime = beginTime; }
    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }
    public java.util.Map<String, Object> getParams() {
        if (params == null) { params = new java.util.HashMap<>(); }
        return params;
    }
    public void setParams(java.util.Map<String, Object> params) { this.params = params; }
}
