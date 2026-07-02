package com.ruoyi.system.domain.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "字典类型新增/修改请求")
public class SysDictTypeDTO {
    @Schema(description = "字典ID")
    private Long dictId;
    @NotBlank(message = "字典名称不能为空")
    @Schema(description = "字典名称", required = true)
    private String dictName;
    @NotBlank(message = "字典类型不能为空")
    @Schema(description = "字典类型", required = true)
    private String dictType;
    @Schema(description = "状态（0正常 1停用）")
    private String status;
    @Schema(description = "备注")
    private String remark;

    public Long getDictId() { return dictId; }
    public void setDictId(Long dictId) { this.dictId = dictId; }
    public String getDictName() { return dictName; }
    public void setDictName(String dictName) { this.dictName = dictName; }
    public String getDictType() { return dictType; }
    public void setDictType(String dictType) { this.dictType = dictType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
