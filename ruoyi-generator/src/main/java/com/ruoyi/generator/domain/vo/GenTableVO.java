package com.ruoyi.generator.domain.vo;
import java.util.Date; import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.generator.domain.GenTableColumn;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "代码生成表响应")
public class GenTableVO {
    @Schema(description = "表ID") private Long tableId;
    @Schema(description = "表名称") private String tableName;
    @Schema(description = "表描述") private String tableComment;
    @Schema(description = "子表名称") private String subTableName;
    @Schema(description = "子表外键") private String subTableFkName;
    @Schema(description = "实体类名") private String className;
    @Schema(description = "模板") private String tplCategory;
    @Schema(description = "前端模板") private String tplWebType;
    @Schema(description = "包路径") private String packageName;
    @Schema(description = "模块名") private String moduleName;
    @Schema(description = "业务名") private String businessName;
    @Schema(description = "功能名") private String functionName;
    @Schema(description = "作者") private String functionAuthor;
    @Schema(description = "表单列数") private Integer formColNum;
    @Schema(description = "生成方式") private String genType;
    @Schema(description = "生成路径") private String genPath;
    @Schema(description = "列信息") private List<GenTableColumn> columns;
    @Schema(description = "创建者") private String createBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "创建时间") private Date createTime;
    @Schema(description = "更新者") private String updateBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "更新时间") private Date updateTime;
    @Schema(description = "备注") private String remark;
    public Long getTableId() { return tableId; } public void setTableId(Long v) { this.tableId = v; }
    public String getTableName() { return tableName; } public void setTableName(String v) { this.tableName = v; }
    public String getTableComment() { return tableComment; } public void setTableComment(String v) { this.tableComment = v; }
    public String getSubTableName() { return subTableName; } public void setSubTableName(String v) { this.subTableName = v; }
    public String getSubTableFkName() { return subTableFkName; } public void setSubTableFkName(String v) { this.subTableFkName = v; }
    public String getClassName() { return className; } public void setClassName(String v) { this.className = v; }
    public String getTplCategory() { return tplCategory; } public void setTplCategory(String v) { this.tplCategory = v; }
    public String getTplWebType() { return tplWebType; } public void setTplWebType(String v) { this.tplWebType = v; }
    public String getPackageName() { return packageName; } public void setPackageName(String v) { this.packageName = v; }
    public String getModuleName() { return moduleName; } public void setModuleName(String v) { this.moduleName = v; }
    public String getBusinessName() { return businessName; } public void setBusinessName(String v) { this.businessName = v; }
    public String getFunctionName() { return functionName; } public void setFunctionName(String v) { this.functionName = v; }
    public String getFunctionAuthor() { return functionAuthor; } public void setFunctionAuthor(String v) { this.functionAuthor = v; }
    public Integer getFormColNum() { return formColNum; } public void setFormColNum(Integer v) { this.formColNum = v; }
    public String getGenType() { return genType; } public void setGenType(String v) { this.genType = v; }
    public String getGenPath() { return genPath; } public void setGenPath(String v) { this.genPath = v; }
    public List<GenTableColumn> getColumns() { return columns; } public void setColumns(List<GenTableColumn> v) { this.columns = v; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String v) { this.createBy = v; }
    public Date getCreateTime() { return createTime; } public void setCreateTime(Date v) { this.createTime = v; }
    public String getUpdateBy() { return updateBy; } public void setUpdateBy(String v) { this.updateBy = v; }
    public Date getUpdateTime() { return updateTime; } public void setUpdateTime(Date v) { this.updateTime = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
