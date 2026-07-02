package com.ruoyi.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "字典数据响应")
public class SysDictDataVO {
    @Schema(description = "字典编码")
    private Long dictCode;
    @Schema(description = "字典排序")
    private Integer dictSort;
    @Schema(description = "字典标签")
    private String dictLabel;
    @Schema(description = "字典键值")
    private String dictValue;
    @Schema(description = "字典类型")
    private String dictType;
    @Schema(description = "样式属性")
    private String cssClass;
    @Schema(description = "表格回显样式")
    private String listClass;
    @Schema(description = "是否默认")
    private String isDefault;
    @Schema(description = "状态")
    private String status;
    @Schema(description = "创建者")
    private String createBy;
    @Schema(description = "创建时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @Schema(description = "更新者")
    private String updateBy;
    @Schema(description = "更新时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @Schema(description = "备注")
    private String remark;

    public Long getDictCode() { return dictCode; }
    public void setDictCode(Long dictCode) { this.dictCode = dictCode; }
    public Integer getDictSort() { return dictSort; }
    public void setDictSort(Integer dictSort) { this.dictSort = dictSort; }
    public String getDictLabel() { return dictLabel; }
    public void setDictLabel(String dictLabel) { this.dictLabel = dictLabel; }
    public String getDictValue() { return dictValue; }
    public void setDictValue(String dictValue) { this.dictValue = dictValue; }
    public String getDictType() { return dictType; }
    public void setDictType(String dictType) { this.dictType = dictType; }
    public String getCssClass() { return cssClass; }
    public void setCssClass(String cssClass) { this.cssClass = cssClass; }
    public String getListClass() { return listClass; }
    public void setListClass(String listClass) { this.listClass = listClass; }
    public String getIsDefault() { return isDefault; }
    public void setIsDefault(String isDefault) { this.isDefault = isDefault; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCreateBy() { return createBy; }
    public void setCreateBy(String createBy) { this.createBy = createBy; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
