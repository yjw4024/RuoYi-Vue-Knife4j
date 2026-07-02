package com.ruoyi.system.domain.query;

import java.util.HashMap;
import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "字典数据查询")
public class SysDictDataQuery {
    @Schema(description = "字典类型")
    private String dictType;
    @Schema(description = "字典标签")
    private String dictLabel;
    @Schema(description = "状态")
    private String status;
    @Schema(description = "请求参数")
    private Map<String, Object> params;

    public String getDictType() { return dictType; }
    public void setDictType(String dictType) { this.dictType = dictType; }
    public String getDictLabel() { return dictLabel; }
    public void setDictLabel(String dictLabel) { this.dictLabel = dictLabel; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Map<String, Object> getParams() { if (params == null) params = new HashMap<>(); return params; }
    public void setParams(Map<String, Object> params) { this.params = params; }
}
