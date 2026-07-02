package com.ruoyi.system.domain.query;
import java.util.HashMap; import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "通知公告查询")
public class SysNoticeQuery {
    @Schema(description = "公告标题") private String noticeTitle;
    @Schema(description = "公告类型") private String noticeType;
    @Schema(description = "创建者") private String createBy;
    @Schema(description = "请求参数") private Map<String, Object> params;
    public String getNoticeTitle() { return noticeTitle; } public void setNoticeTitle(String v) { this.noticeTitle = v; }
    public String getNoticeType() { return noticeType; } public void setNoticeType(String v) { this.noticeType = v; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String v) { this.createBy = v; }
    public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
    public void setParams(Map<String, Object> v) { this.params = v; }
}
