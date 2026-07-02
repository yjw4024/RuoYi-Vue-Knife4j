package com.ruoyi.common.core.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 分页查询基类（参考douyi-tasks的PageQuery）
 * 所有 Query 类继承此类，自动获得分页参数
 *
 * @author ruoyi
 */
@Schema(description = "分页查询基类")
public class PageQuery
{
    /** 当前页码 */
    @Schema(description = "当前页码", example = "1")
    private Integer pageNum = 1;

    /** 每页条数 */
    @Schema(description = "每页条数", example = "10")
    private Integer pageSize = 10;

    /** 排序列 */
    @Schema(description = "排序列")
    private String orderByColumn;

    /** 排序方向（asc/desc） */
    @Schema(description = "排序方向")
    private String isAsc = "desc";

    /** 查询参数（扩展用） */
    @Schema(description = "扩展参数")
    @JsonIgnore
    private Map<String, Object> params;

    // ====== Getter/Setter ======

    public Integer getPageNum() { return pageNum; }
    public void setPageNum(Integer pageNum) { this.pageNum = pageNum; }
    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
    public String getOrderByColumn() { return orderByColumn; }
    public void setOrderByColumn(String orderByColumn) { this.orderByColumn = orderByColumn; }
    public String getIsAsc() { return isAsc; }
    public void setIsAsc(String isAsc) { this.isAsc = isAsc; }
    public Map<String, Object> getParams()
    {
        if (params == null) { params = new HashMap<>(); }
        return params;
    }
    public void setParams(Map<String, Object> params) { this.params = params; }
}
