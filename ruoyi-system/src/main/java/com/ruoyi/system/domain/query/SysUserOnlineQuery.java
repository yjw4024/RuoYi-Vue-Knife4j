package com.ruoyi.system.domain.query;
import java.util.HashMap; import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "在线用户查询") public class SysUserOnlineQuery {
@Schema(description = "用户名称") private String userName;
@Schema(description = "登录IP") private String ipaddr;
@Schema(description = "请求参数") private Map<String,Object> params;
public String getUserName() { return userName; } public void setUserName(String v) { this.userName = v; }
public String getIpaddr() { return ipaddr; } public void setIpaddr(String v) { this.ipaddr = v; }
public Map<String,Object> getParams() { if(params==null) params=new HashMap<>(); return params; }
public void setParams(Map<String,Object> v) { this.params = v; }
}
