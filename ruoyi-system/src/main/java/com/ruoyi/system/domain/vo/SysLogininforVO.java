package com.ruoyi.system.domain.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "登录日志响应")
public class SysLogininforVO {
    @Schema(description = "访问ID") private Long infoId;
    @Schema(description = "用户账号") private String userName;
    @Schema(description = "登录状态") private String status;
    @Schema(description = "登录IP") private String ipaddr;
    @Schema(description = "登录地点") private String loginLocation;
    @Schema(description = "浏览器类型") private String browser;
    @Schema(description = "操作系统") private String os;
    @Schema(description = "提示消息") private String msg;
    @Schema(description = "登录时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date loginTime;
    public Long getInfoId() { return infoId; } public void setInfoId(Long v) { this.infoId = v; }
    public String getUserName() { return userName; } public void setUserName(String v) { this.userName = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getIpaddr() { return ipaddr; } public void setIpaddr(String v) { this.ipaddr = v; }
    public String getLoginLocation() { return loginLocation; } public void setLoginLocation(String v) { this.loginLocation = v; }
    public String getBrowser() { return browser; } public void setBrowser(String v) { this.browser = v; }
    public String getOs() { return os; } public void setOs(String v) { this.os = v; }
    public String getMsg() { return msg; } public void setMsg(String v) { this.msg = v; }
    public Date getLoginTime() { return loginTime; } public void setLoginTime(Date v) { this.loginTime = v; }
}
