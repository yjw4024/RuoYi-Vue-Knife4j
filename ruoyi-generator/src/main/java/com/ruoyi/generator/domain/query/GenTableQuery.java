package com.ruoyi.generator.domain.query;
import java.util.HashMap; import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "代码生成表查询")
public class GenTableQuery {
    @Schema(description = "表名称") private String tableName;
    @Schema(description = "表描述") private String tableComment;
    @Schema(description = "请求参数") private Map<String,Object> params;
    public String getTableName() { return tableName; } public void setTableName(String v) { this.tableName = v; }
    public String getTableComment() { return tableComment; } public void setTableComment(String v) { this.tableComment = v; }
    public Map<String,Object> getParams() { if(params==null) params=new HashMap<>(); return params; }
    public void setParams(Map<String,Object> v) { this.params = v; }
}
