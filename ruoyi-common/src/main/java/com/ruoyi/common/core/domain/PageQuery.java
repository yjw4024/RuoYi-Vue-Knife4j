package com.ruoyi.common.core.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分页查询基类，所有 Query 类继承此类
 *
 * @author ruoyi
 */
@Data
@Schema(description = "分页查询基类")
public class PageQuery
{
    @Schema(description = "当前页码", example = "1")
    private Integer pageNum = 1;

    @Schema(description = "每页条数", example = "10")
    private Integer pageSize = 10;

    @Schema(description = "排序列")
    private String orderByColumn;

    @Schema(description = "排序方向")
    private String isAsc = "desc";

    @Schema(description = "扩展参数")
    @JsonIgnore
    private Map<String, Object> params;

    public Map<String, Object> getParams()
    {
        if (params == null) { params = new HashMap<>(); }
        return params;
    }

    public void setParams(Map<String, Object> params) { this.params = params; }
}
