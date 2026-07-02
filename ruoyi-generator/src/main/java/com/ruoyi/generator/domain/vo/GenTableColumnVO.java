package com.ruoyi.generator.domain.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "代码生成列响应")
public class GenTableColumnVO {
    @Schema(description = "列ID") private Long columnId;
    @Schema(description = "表ID") private Long tableId;
    @Schema(description = "列名称") private String columnName;
    @Schema(description = "列描述") private String columnComment;
    @Schema(description = "列类型") private String columnType;
    @Schema(description = "Java类型") private String javaType;
    @Schema(description = "Java字段") private String javaField;
    @Schema(description = "是否主键") private String isPk;
    @Schema(description = "是否自增") private String isIncrement;
    @Schema(description = "是否必填") private String isRequired;
    @Schema(description = "是否插入") private String isInsert;
    @Schema(description = "是否编辑") private String isEdit;
    @Schema(description = "是否列表") private String isList;
    @Schema(description = "是否查询") private String isQuery;
    @Schema(description = "查询方式") private String queryType;
    @Schema(description = "显示类型") private String htmlType;
    @Schema(description = "字典类型") private String dictType;
    @Schema(description = "排序") private Integer sort;
    @Schema(description = "创建者") private String createBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "创建时间") private Date createTime;
    @Schema(description = "更新者") private String updateBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "更新时间") private Date updateTime;
    public Long getColumnId() { return columnId; } public void setColumnId(Long v) { this.columnId = v; }
    public Long getTableId() { return tableId; } public void setTableId(Long v) { this.tableId = v; }
    public String getColumnName() { return columnName; } public void setColumnName(String v) { this.columnName = v; }
    public String getColumnComment() { return columnComment; } public void setColumnComment(String v) { this.columnComment = v; }
    public String getColumnType() { return columnType; } public void setColumnType(String v) { this.columnType = v; }
    public String getJavaType() { return javaType; } public void setJavaType(String v) { this.javaType = v; }
    public String getJavaField() { return javaField; } public void setJavaField(String v) { this.javaField = v; }
    public String getIsPk() { return isPk; } public void setIsPk(String v) { this.isPk = v; }
    public String getIsIncrement() { return isIncrement; } public void setIsIncrement(String v) { this.isIncrement = v; }
    public String getIsRequired() { return isRequired; } public void setIsRequired(String v) { this.isRequired = v; }
    public String getIsInsert() { return isInsert; } public void setIsInsert(String v) { this.isInsert = v; }
    public String getIsEdit() { return isEdit; } public void setIsEdit(String v) { this.isEdit = v; }
    public String getIsList() { return isList; } public void setIsList(String v) { this.isList = v; }
    public String getIsQuery() { return isQuery; } public void setIsQuery(String v) { this.isQuery = v; }
    public String getQueryType() { return queryType; } public void setQueryType(String v) { this.queryType = v; }
    public String getHtmlType() { return htmlType; } public void setHtmlType(String v) { this.htmlType = v; }
    public String getDictType() { return dictType; } public void setDictType(String v) { this.dictType = v; }
    public Integer getSort() { return sort; } public void setSort(Integer v) { this.sort = v; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String v) { this.createBy = v; }
    public Date getCreateTime() { return createTime; } public void setCreateTime(Date v) { this.createTime = v; }
    public String getUpdateBy() { return updateBy; } public void setUpdateBy(String v) { this.updateBy = v; }
    public Date getUpdateTime() { return updateTime; } public void setUpdateTime(Date v) { this.updateTime = v; }
}
