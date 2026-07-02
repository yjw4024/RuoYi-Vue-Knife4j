package com.ruoyi.system.domain.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "字典数据新增/修改请求")
public class SysDictDataDTO {
    @Schema(description = "字典编码")
    private Long dictCode;
    @Schema(description = "字典排序")
    private Integer dictSort;
    @NotBlank(message = "字典标签不能为空")
    @Schema(description = "字典标签", required = true)
    private String dictLabel;
    @NotBlank(message = "字典键值不能为空")
    @Schema(description = "字典键值", required = true)
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
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
