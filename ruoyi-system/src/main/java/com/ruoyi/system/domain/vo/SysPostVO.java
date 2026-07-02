package com.ruoyi.system.domain.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "岗位信息响应")
public class SysPostVO {
    @Schema(description = "岗位ID") private Long postId;
    @Schema(description = "岗位编码") private String postCode;
    @Schema(description = "岗位名称") private String postName;
    @Schema(description = "显示顺序") private Integer postSort;
    @Schema(description = "状态") private String status;
    @Schema(description = "创建者") private String createBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "创建时间") private Date createTime;
    @Schema(description = "更新者") private String updateBy; @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Schema(description = "更新时间") private Date updateTime;
    @Schema(description = "备注") private String remark;
    public Long getPostId() { return postId; } public void setPostId(Long v) { this.postId = v; }
    public String getPostCode() { return postCode; } public void setPostCode(String v) { this.postCode = v; }
    public String getPostName() { return postName; } public void setPostName(String v) { this.postName = v; }
    public Integer getPostSort() { return postSort; } public void setPostSort(Integer v) { this.postSort = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String v) { this.createBy = v; }
    public Date getCreateTime() { return createTime; } public void setCreateTime(Date v) { this.createTime = v; }
    public String getUpdateBy() { return updateBy; } public void setUpdateBy(String v) { this.updateBy = v; }
    public Date getUpdateTime() { return updateTime; } public void setUpdateTime(Date v) { this.updateTime = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
