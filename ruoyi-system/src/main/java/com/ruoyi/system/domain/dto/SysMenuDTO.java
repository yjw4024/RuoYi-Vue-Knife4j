package com.ruoyi.system.domain.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "菜单新增/修改请求")
public class SysMenuDTO {
    @Schema(description = "菜单ID") private Long menuId;
    @Schema(description = "父菜单ID") private Long parentId;
    @NotBlank(message = "菜单名称不能为空") @Schema(description = "菜单名称", required = true) private String menuName;
    @Schema(description = "显示顺序") private Integer orderNum;
    @NotBlank(message = "路由地址不能为空") @Schema(description = "路由地址") private String path;
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
    @Schema(description = "备注") private String remark;
    public Long getMenuId() { return menuId; } public void setMenuId(Long menuId) { this.menuId = menuId; }
    public Long getParentId() { return parentId; } public void setParentId(Long parentId) { this.parentId = parentId; }
    public String getMenuName() { return menuName; } public void setMenuName(String menuName) { this.menuName = menuName; }
    public Integer getOrderNum() { return orderNum; } public void setOrderNum(Integer orderNum) { this.orderNum = orderNum; }
    public String getPath() { return path; } public void setPath(String path) { this.path = path; }
    public String getComponent() { return component; } public void setComponent(String component) { this.component = component; }
    public String getQuery() { return query; } public void setQuery(String query) { this.query = query; }
    public String getRouteName() { return routeName; } public void setRouteName(String routeName) { this.routeName = routeName; }
    public String getIsFrame() { return isFrame; } public void setIsFrame(String isFrame) { this.isFrame = isFrame; }
    public String getIsCache() { return isCache; } public void setIsCache(String isCache) { this.isCache = isCache; }
    public String getMenuType() { return menuType; } public void setMenuType(String menuType) { this.menuType = menuType; }
    public String getVisible() { return visible; } public void setVisible(String visible) { this.visible = visible; }
    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }
    public String getPerms() { return perms; } public void setPerms(String perms) { this.perms = perms; }
    public String getIcon() { return icon; } public void setIcon(String icon) { this.icon = icon; }
    public String getRemark() { return remark; } public void setRemark(String remark) { this.remark = remark; }
}
