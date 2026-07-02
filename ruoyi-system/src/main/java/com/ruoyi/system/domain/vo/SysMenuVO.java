package com.ruoyi.system.domain.vo;

import java.util.Date; import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "菜单信息响应")
public class SysMenuVO {
    @Schema(description = "菜单ID") private Long menuId;
    @Schema(description = "菜单名称") private String menuName;
    @Schema(description = "父菜单ID") private Long parentId;
    @Schema(description = "显示顺序") private Integer orderNum;
    @Schema(description = "路由地址") private String path;
    @Schema(description = "组件路径") private String component;
    @Schema(description = "路由参数") private String query;
    @Schema(description = "路由名称") private String routeName;
    @Schema(description = "是否外链") private String isFrame;
    @Schema(description = "是否缓存") private String isCache;
    @Schema(description = "菜单类型") private String menuType;
    @Schema(description = "显示状态") private String visible;
    @Schema(description = "菜单状态") private String status;
    @Schema(description = "权限标识") private String perms;
    @Schema(description = "菜单图标") private String icon;
    @Schema(description = "父菜单名称") private String parentName;
    @Schema(description = "子菜单") private List<SysMenuVO> children;
    @Schema(description = "创建者") private String createBy;
    @Schema(description = "创建时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date createTime;
    @Schema(description = "更新者") private String updateBy;
    @Schema(description = "更新时间") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date updateTime;
    @Schema(description = "备注") private String remark;
    public Long getMenuId() { return menuId; } public void setMenuId(Long v) { this.menuId = v; }
    public String getMenuName() { return menuName; } public void setMenuName(String v) { this.menuName = v; }
    public Long getParentId() { return parentId; } public void setParentId(Long v) { this.parentId = v; }
    public Integer getOrderNum() { return orderNum; } public void setOrderNum(Integer v) { this.orderNum = v; }
    public String getPath() { return path; } public void setPath(String v) { this.path = v; }
    public String getComponent() { return component; } public void setComponent(String v) { this.component = v; }
    public String getQuery() { return query; } public void setQuery(String v) { this.query = v; }
    public String getRouteName() { return routeName; } public void setRouteName(String v) { this.routeName = v; }
    public String getIsFrame() { return isFrame; } public void setIsFrame(String v) { this.isFrame = v; }
    public String getIsCache() { return isCache; } public void setIsCache(String v) { this.isCache = v; }
    public String getMenuType() { return menuType; } public void setMenuType(String v) { this.menuType = v; }
    public String getVisible() { return visible; } public void setVisible(String v) { this.visible = v; }
    public String getStatus() { return status; } public void setStatus(String v) { this.status = v; }
    public String getPerms() { return perms; } public void setPerms(String v) { this.perms = v; }
    public String getIcon() { return icon; } public void setIcon(String v) { this.icon = v; }
    public String getParentName() { return parentName; } public void setParentName(String v) { this.parentName = v; }
    public List<SysMenuVO> getChildren() { return children; } public void setChildren(List<SysMenuVO> v) { this.children = v; }
    public String getCreateBy() { return createBy; } public void setCreateBy(String v) { this.createBy = v; }
    public Date getCreateTime() { return createTime; } public void setCreateTime(Date v) { this.createTime = v; }
    public String getUpdateBy() { return updateBy; } public void setUpdateBy(String v) { this.updateBy = v; }
    public Date getUpdateTime() { return updateTime; } public void setUpdateTime(Date v) { this.updateTime = v; }
    public String getRemark() { return remark; } public void setRemark(String v) { this.remark = v; }
}
