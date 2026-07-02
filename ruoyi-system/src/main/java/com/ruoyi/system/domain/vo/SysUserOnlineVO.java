package com.ruoyi.system.domain.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "在线用户响应")
public class SysUserOnlineVO {
    @Schema(description = "会话编号") private String tokenId;
    @Schema(description = "部门名称") private String deptName;
    @Schema(description = "用户名称") private String userName;
    @Schema(description = "登录IP") private String ipaddr;
    @Schema(description = "登录地点") private String loginLocation;
    @Schema(description = "浏览器类型") private String browser;
    @Schema(description = "操作系统") private String os;
    @Schema(description = "登录时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date loginTime;
    public String getTokenId() { return tokenId; } public void setTokenId(String v) { this.tokenId = v; }
    public String getDeptName() { return deptName; } public void setDeptName(String v) { this.deptName = v; }
    public String getUserName() { return userName; } public void setUserName(String v) { this.userName = v; }
    public String getIpaddr() { return ipaddr; } public void setIpaddr(String v) { this.ipaddr = v; }
    public String getLoginLocation() { return loginLocation; } public void setLoginLocation(String v) { this.loginLocation = v; }
    public String getBrowser() { return browser; } public void setBrowser(String v) { this.browser = v; }
    public String getOs() { return os; } public void setOs(String v) { this.os = v; }
    public Date getLoginTime() { return loginTime; } public void setLoginTime(Date v) { this.loginTime = v; }
}
