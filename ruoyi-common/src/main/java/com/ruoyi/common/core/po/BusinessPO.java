package com.ruoyi.common.core.po;

import com.ruoyi.common.core.domain.BasePO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务PO基类（varchar主键，含审计/逻辑删除/乐观锁，参考 dc.base.BusinessPO）
 *
 * @author YiJiawei
 * @date 2026/7/4
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "业务PO基类")
public class BusinessPO extends BasePO
{
    private static final long serialVersionUID = 1L;

    @Schema(description = "创建人id")
    private String createUserId;

    @Schema(description = "创建人")
    private String createUserName;

    @Schema(description = "修改人id")
    private String updateUserId;

    @Schema(description = "修改人姓名")
    private String updateUserName;

    @Schema(description = "是否删除（0=正常 1=删除）")
    private Integer isDeleted;

    @Schema(description = "乐观锁版本号")
    private Integer version;

    @Schema(description = "备注")
    private String memo;
}
