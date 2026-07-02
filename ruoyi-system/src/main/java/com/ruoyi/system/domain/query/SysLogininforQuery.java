package com.ruoyi.system.domain.query;
import java.util.Date; import java.util.HashMap; import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "登录日志查询")
public class SysLogininforQuery {
    @Schema(description = "用户账号") private String userName;
    @Schema(description = "登录状态") private String status;
    @Schema(description = "登录IP") private String ipaddr;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "开始时间") private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "结束时间") private Date endTime;
    @Schema(description = "请求参数") private Map<String, Object> params;
    public String getUserName() { return userName; } public void setUserName(String v) { this.userName = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getIpaddr() { return ipaddr; } public void setIpaddr(String v) { this.ipaddr = v; }
    public Date getBeginTime() { return beginTime; } public void setBeginTime(Date v) { this.beginTime = v; }
    public Date getEndTime() { return endTime; } public void setEndTime(Date v) { this.endTime = v; }
    public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
    public void setParams(Map<String, Object> v) { this.params = v; }
}
