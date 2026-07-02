package com.ruoyi.system.domain.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "操作日志响应")
public class SysOperLogVO {
    @Schema(description = "日志ID") private Long operId;
    @Schema(description = "操作模块") private String title;
    @Schema(description = "业务类型") private Integer businessType;
    @Schema(description = "方法名称") private String method;
    @Schema(description = "请求方式") private String requestMethod;
    @Schema(description = "操作类别") private Integer operatorType;
    @Schema(description = "操作人员") private String operName;
    @Schema(description = "部门名称") private String deptName;
    @Schema(description = "请求URL") private String operUrl;
    @Schema(description = "操作IP") private String operIp;
    @Schema(description = "操作地点") private String operLocation;
    @Schema(description = "请求参数") private String operParam;
    @Schema(description = "返回参数") private String jsonResult;
    @Schema(description = "操作状态") private Integer status;
    @Schema(description = "错误消息") private String errorMsg;
    @Schema(description = "操作时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date operTime;
    @Schema(description = "消耗时间(ms)") private Long costTime;
    public Long getOperId() { return operId; } public void setOperId(Long v) { this.operId = v; }
    public String getTitle() { return title; } public void setTitle(String v) { this.title = v; }
    public Integer getBusinessType() { return businessType; } public void setBusinessType(Integer v) { this.businessType = v; }
    public String getMethod() { return method; } public void setMethod(String v) { this.method = v; }
    public String getRequestMethod() { return requestMethod; } public void setRequestMethod(String v) { this.requestMethod = v; }
    public Integer getOperatorType() { return operatorType; } public void setOperatorType(Integer v) { this.operatorType = v; }
    public String getOperName() { return operName; } public void setOperName(String v) { this.operName = v; }
    public String getDeptName() { return deptName; } public void setDeptName(String v) { this.deptName = v; }
    public String getOperUrl() { return operUrl; } public void setOperUrl(String v) { this.operUrl = v; }
    public String getOperIp() { return operIp; } public void setOperIp(String v) { this.operIp = v; }
    public String getOperLocation() { return operLocation; } public void setOperLocation(String v) { this.operLocation = v; }
    public String getOperParam() { return operParam; } public void setOperParam(String v) { this.operParam = v; }
    public String getJsonResult() { return jsonResult; } public void setJsonResult(String v) { this.jsonResult = v; }
    public Integer getStatus() { return status; } public void setStatus(Integer v) { this.status = v; }
    public String getErrorMsg() { return errorMsg; } public void setErrorMsg(String v) { this.errorMsg = v; }
    public Date getOperTime() { return operTime; } public void setOperTime(Date v) { this.operTime = v; }
    public Long getCostTime() { return costTime; } public void setCostTime(Long v) { this.costTime = v; }
}
