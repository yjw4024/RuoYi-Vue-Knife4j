# Role: RuoYi Framework Expert & Java Architect

## Project Context
这是一个基于 RuoYi (Spring Boot + MyBatis) 的多模块后端项目。
- Spring Boot 4.0.3 + Spring Framework 7.0.5 + JDK 17
- 已升级 Knife4j 接口文档（springdoc-openapi + knife4j-openapi3-ui 4.0.0）
- 正在进行架构升级，从 Entity 透传模式升级为 **DTO / VO / Query** 分层模式

## 模块结构

```
ruoyi-admin/       # Controller 层（24个控制器，6个Knife4j分组）
ruoyi-common/      # 通用工具、基础Entity（BaseEntity, SysUser, SysRole等）
ruoyi-framework/   # 安全/配置层（SecurityConfig, ResourcesConfig, SwaggerConfig）
ruoyi-system/      # 系统业务模块（Service + Mapper + domain/dto/vo/query）
ruoyi-quartz/      # 定时任务模块
ruoyi-generator/   # 代码生成模块
```

## Directory Structure Rules（已实施部分）

重构采用**增量式保守策略**：新增 DTO/VO/Query 类，保留原有 Entity 作为 PO 层不变（确保 MyBatis XML 映射兼容）。

```
ruoyi-system/src/main/java/com/ruoyi/system/
├── domain/
│   ├── dto/         # 请求参数对象（含 @NotBlank/@Size 校验）
│   │   ├── SysUserDTO.java
│   │   ├── SysRoleDTO.java
│   │   ├── SysMenuDTO.java
│   │   ├── SysDeptDTO.java
│   │   ├── SysDictTypeDTO.java, SysDictDataDTO.java
│   │   ├── SysConfigDTO.java, SysNoticeDTO.java, SysPostDTO.java
│   │   └── XxxDTO.java  ← 命名模式
│   ├── vo/          # 响应视图对象（无 password 等敏感字段，含 @JsonFormat）
│   │   ├── SysUserVO.java
│   │   ├── SysRoleVO.java, SysMenuVO.java, SysDeptVO.java
│   │   ├── SysDictTypeVO.java, SysDictDataVO.java
│   │   ├── SysConfigVO.java, SysNoticeVO.java, SysPostVO.java
│   │   ├── SysOperLogVO.java, SysLogininforVO.java
│   │   ├── SysUserOnlineVO.java, SysCacheVO.java
│   │   └── XxxVO.java  ← 命名模式
│   └── query/       # 分页查询对象（含 beginTime/endTime/params Map）
│       ├── SysUserQuery.java
│       ├── SysRoleQuery.java, SysMenuQuery.java, SysDeptQuery.java
│       ├── SysDictTypeQuery.java, SysDictDataQuery.java
│       ├── SysConfigQuery.java, SysNoticeQuery.java, SysPostQuery.java
│       ├── SysOperLogQuery.java, SysLogininforQuery.java
│       ├── SysUserOnlineQuery.java
│       └── XxxQuery.java  ← 命名模式
├── service/
│   ├── ISysUserService.java     ← 新增 selectXxxVOById / insertXxxByDTO 等方法
│   └── impl/
│       └── SysUserServiceImpl.java  ← 内部用 BeanConvertUtils 做转换
└── mapper/         # 不变，继续操作 Entity(PO)

ruoyi-quartz/src/main/java/com/ruoyi/quartz/domain/
├── dto/  (SysJobDTO.java)
├── vo/   (SysJobVO.java, SysJobLogVO.java)
└── query/ (SysJobQuery.java, SysJobLogQuery.java)

ruoyi-generator/src/main/java/com/ruoyi/generator/domain/
├── vo/   (GenTableVO.java, GenTableColumnVO.java)
└── query/ (GenTableQuery.java)
```

> **注意**: 现有 Entity（如 `SysUser.java`, `SysRole.java` 等）保持在 `ruoyi-common/.../entity/` 中不变，充当 PO 层。MyBatis XML mapper 无需修改。**未来**可以考虑重命名为 `XxxPO` 并移动到 `domain/po/`。

## 分层职责

| 分层 | 位置 | 职责 | 关键注解 |
|------|------|------|----------|
| **Controller** | ruoyi-admin | 接收请求、参数校验、调用 Service | `@Valid @RequestBody DTO`, `@PreAuthorize` |
| **Service** | ruoyi-system | 业务逻辑 + DTO→PO + PO→VO 转换 | BeanConvertUtils |
| **Mapper** | ruoyi-system | 操作 Entity(PO)，MyBatis XML 映射 | 不变 |
| **DTO** | domain/dto | 新增/修改入参 | `@NotBlank`, `@Schema` |
| **VO** | domain/vo | 响应数据（无密码等敏感字段） | `@Schema`, `@JsonFormat` |
| **Query** | domain/query | 分页查询过滤条件 | `@Schema`, `params` Map |

## 对象转换规范

使用 `BeanConvertUtils`（位于 `ruoyi-common/src/main/java/com/ruoyi/common/utils/BeanConvertUtils.java`）：
```java
// 单个转换
SysUserVO vo = BeanConvertUtils.convert(sysUser, SysUserVO.class);
// 列表转换
List<SysUserVO> voList = BeanConvertUtils.convertList(poList, SysUserVO.class);
// DTO → PO
SysUser user = BeanConvertUtils.convert(dto, SysUser.class);
// Query → PO
SysUser user = BeanConvertUtils.convert(query, SysUser.class);
```

## Controller 编码模板

```java
// 列表查询: Query 入参 → VO 列表返回
@GetMapping("/list")
public TableDataInfo list(XxxQuery query) {
    startPage();
    List<Xxx> list = service.selectList(BeanConvertUtils.convert(query, Xxx.class));
    return getDataTable(BeanConvertUtils.convertList(list, XxxVO.class));
}

// 详情: ID 入参 → VO 返回
@GetMapping("/{id}")
public AjaxResult getInfo(@PathVariable Long id) {
    return success(BeanConvertUtils.convert(service.selectById(id), XxxVO.class));
}

// 新增: @Valid DTO 入参 → DTO→PO → Service
@PostMapping
public AjaxResult add(@Valid @RequestBody XxxDTO dto) {
    Xxx po = BeanConvertUtils.convert(dto, Xxx.class);
    po.setCreateBy(getUsername());
    return toAjax(service.insert(po));
}

// 修改: @Valid DTO 入参 → DTO→PO → Service
@PutMapping
public AjaxResult edit(@Valid @RequestBody XxxDTO dto) {
    Xxx po = BeanConvertUtils.convert(dto, Xxx.class);
    po.setUpdateBy(getUsername());
    return toAjax(service.update(po));
}
```

## Service 层编码模板

```java
// 接口新增分层方法（不修改原有方法）
SysUserVO selectUserVOById(Long userId);
List<SysUserVO> selectUserVOList(SysUserQuery query);
int insertUserByDTO(SysUserDTO dto);
int updateUserByDTO(SysUserDTO dto);

// 实现内部委托给原有方法 + BeanConvertUtils 转换
@Override
public SysUserVO selectUserVOById(Long userId) {
    return BeanConvertUtils.convert(selectUserById(userId), SysUserVO.class);
}
```

## Knife4j 文档规范

- 每个 Controller 必须有 `@Tag(name = "中文名称")`
- 每个方法必须有 `@Operation(summary = "中文说明")`
- 请求/响应对象必须有 `@Schema(description = "中文说明")`
- access token via `http://localhost:8080/doc.html`

### SwaggerConfig 关键配置

- Security: HTTP Bearer (`scheme("bearer")` 小写)
- 安全方案名使用 `bearerAuth`（不要用 `Authorization` 避免 Knife4j 冲突）
- 6模块 `GroupedOpenApi` bean 分组切换
- `GlobalOpenApiCustomizer` 处理子模块中文 Tag + 操作级 SecurityRequirement

## RuoYi 特性兼容

- Controller 继承 `BaseController` → 获得 `startPage()`, `getDataTable()`, `success()`, `error()` 等方法
- Entity(PO) 继承 `BaseEntity` → 获得 `createBy`, `createTime`, `updateBy`, `updateTime`, `remark`, `params`
- 导出 Excel: `@Excel` 注解保留在 Entity(PO) 上，不影响 VO
- 权限校验: `@PreAuthorize("@ss.hasPermi('system:user:list')")` 保持不变
- 操作日志: `@Log(title = "用户管理", businessType = BusinessType.xxx)` 保持不变

## 工作流（新增模块/重构模块）

1. 读取现有 Entity 类，确认字段
2. 在 `domain/dto/` 创建 DTO（只包含 add/update 需要的字段 + `@NotBlank`）
3. 在 `domain/vo/` 创建 VO（排除 password 等敏感字段，含 `@JsonFormat`）
4. 在 `domain/query/` 创建 Query（查询过滤字段 + params Map）
5. Service 接口新增方法（`selectXxxVOById`, `insertXxxByDTO` 等），不改原有方法
6. Service 实现新增方法，内部用 `BeanConvertUtils` 转换
7. Controller 方法签名改为 DTO/Query 入参、VO 返回
8. 编译验证：`mvn compile -DskipTests`
9. **不要删除**原有 Entity 和 Service 方法（向后兼容）
