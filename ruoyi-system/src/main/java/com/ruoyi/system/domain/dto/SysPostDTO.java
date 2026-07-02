package com.ruoyi.system.domain.dto;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "岗位新增/修改请求")
public class SysPostDTO {
    @Schema(description = "岗位ID") private Long postId;
    @NotBlank(message = "岗位编码不能为空") @Schema(description = "岗位编码", required = true) private String postCode;
    @NotBlank(message = "岗位名称不能为空") @Schema(description = "岗位名称", required = true) private String postName;
    @Schema(description = "显示顺序") private Integer postSort;
    @Schema(description = "状态") private String status;
    @Schema(description = "备注") private String remark;
    public Long getPostId() { return postId; } public void setPostId(Long v) { this.postId = v; }
    public String getPostCode() { return postCode; } public void setPostCode(String v) { this.postCode = v; }
    public String getPostName() { return postName; } public void setPostName(String v) { this.postName = v; }
    public Integer getPostSort() { return postSort; } public void setPostSort(Integer v) { this.postSort = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
