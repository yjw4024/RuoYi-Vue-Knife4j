# 若依 RuoYi-Vue 分层架构重构文档

> 基于 `refactor_prompt.md` 和 douyi-tasks 参考项目，对后端项目进行 PO/DTO/VO/Query 分层架构重构 + Knife4j 文档升级。

---

## 一、Knife4j 接口文档升级

### 1.1 依赖变更

| 文件 | 变更 |
|------|------|
| `pom.xml` | 新增 `knife4j-openapi3-ui:4.0.0` 依赖 |
| `ruoyi-admin/pom.xml` | 同上 |
| `ruoyi-common/pom.xml` | 新增 `springdoc-openapi-starter-webmvc-ui` 依赖（为实体类提供 @Schema 注解） |
| `ruoyi-quartz/pom.xml` | 同上 |
| `ruoyi-generator/pom.xml` | 同上 |

### 1.2 配置变更

| 文件 | 变更说明 |
|------|----------|
| `SwaggerConfig.java` | 完全重写：HTTP Bearer 认证 + 6模块 GroupedOpenApi 分组 + GlobalOpenApiCustomizer |
| `SecurityConfig.java` | 白名单新增 `/doc.html`、`/webjars/**`、`/swagger-resources/**` |
| `ResourcesConfig.java` | 新增 Knife4j webjars 静态资源映射 |
| `application.yml` | `springdoc.*` 配置更新 |
| `CaptchaController.java` | 响应新增 `captchaText` 字段，文档中可直接看到数学表达式 |
| `SysIndexController.java` | `@RequestMapping("/")` → `@GetMapping("/")` 修复重复接口问题 |

### 1.3 Knife4j 模块分组

访问 `http://localhost:8080/doc.html`，右上角下拉切换：

| 分组 | 扫描包 | 接口数 |
|------|--------|--------|
| 系统模块 | `com.ruoyi.web.controller.system` | 81 |
| 监控模块 | `com.ruoyi.web.controller.monitor` | 19 |
| 通用模块 | `com.ruoyi.web.controller.common` | 5 |
| 定时任务 | `com.ruoyi.quartz.controller` | 12 |
| 代码生成 | `com.ruoyi.generator.controller` | 13 |
| 测试模块 | `com.ruoyi.web.controller.tool` | 4 |

### 1.4 接口中文注解（24个Controller + 22个实体类）

所有 Controller 添加 `@Tag(name = "中文名称")` + `@Operation(summary = "中文说明")`。
所有实体类/DTO 添加 `@Schema(description = "中文说明")`。

| 模块 | 控制器 | Tag | 实体类 Schema |
|------|--------|-----|---------------|
| 登录 | SysLoginController | 登录认证 | LoginBody, RegisterBody |
| 用户 | SysUserController | 用户管理 | SysUser |
| 角色 | SysRoleController | 角色管理 | SysRole |
| 菜单 | SysMenuController | 菜单管理 | SysMenu |
| 部门 | SysDeptController | 部门管理 | SysDept |
| 岗位 | SysPostController | 岗位管理 | SysPost |
| 字典类型 | SysDictTypeController | 字典类型管理 | SysDictType |
| 字典数据 | SysDictDataController | 字典数据管理 | SysDictData |
| 参数配置 | SysConfigController | 参数配置管理 | SysConfig |
| 通知公告 | SysNoticeController | 通知公告管理 | SysNotice |
| 注册 | SysRegisterController | 注册认证 | — |
| 个人中心 | SysProfileController | 个人中心 | — |
| 首页 | SysIndexController | 首页 | — |
| 验证码 | CaptchaController | 验证码 | — |
| 通用功能 | CommonController | 通用功能 | — |
| 在线用户 | SysUserOnlineController | 在线用户管理 | SysUserOnline |
| 操作日志 | SysOperlogController | 操作日志管理 | SysOperLog |
| 登录日志 | SysLogininforController | 登录日志管理 | SysLogininfor |
| 缓存管理 | CacheController | 缓存管理 | SysCache |
| 服务器监控 | ServerController | 服务器监控 | — |
| 定时任务 | SysJobController | 定时任务管理 | SysJob |
| 任务日志 | SysJobLogController | 定时任务日志管理 | SysJobLog |
| 代码生成 | GenController | 代码生成 | GenTable, GenTableColumn |
| 测试 | TestController | 用户信息管理 | — |
| — | — | — | BaseEntity, R, RouterVo, MetaVo |

---

## 二、PO/DTO/VO/Query 分层架构重构

> **策略**：增量式重构。新增 DTO/VO/Query 类和 Service 方法，保留原有 PO（Entity）和方法不变，确保向后兼容。

### 2.1 项目分层结构（重构后）

```
ruoyi-admin/src/main/java/com/ruoyi/web/controller/
├── common/          # 通用模块（验证码、上传下载）
├── monitor/         # 监控模块（日志、在线用户、缓存、服务器）
├── system/          # 系统模块（用户、角色、菜单、部门...）
│   ├── SysUserController.java      ← @Valid SysUserDTO 入参 → R<SysUserVO> 返回
│   ├── SysRoleController.java      ← @Valid SysRoleDTO 入参 → R<SysRoleVO> 返回
│   ├── SysMenuController.java
│   ├── SysDeptController.java
│   ├── SysPostController.java
│   ├── SysDictTypeController.java
│   ├── SysDictDataController.java
│   ├── SysConfigController.java
│   ├── SysNoticeController.java
│   ├── SysRegisterController.java
│   ├── SysProfileController.java
│   ├── SysIndexController.java
│   └── SysLoginController.java
└── tool/             # 测试模块

ruoyi-system/src/main/java/com/ruoyi/system/
├── service/          # 业务接口层
│   ├── ISysUserService.java       ← 新增 selectUserVOById / insertUserByDTO 等
│   ├── ISysRoleService.java       ← 新增 selectRoleVOById / insertRoleByDTO 等
│   ├── ISysMenuService.java
│   ├── ISysDeptService.java
│   └── impl/          # 业务实现层（内部 BeanConvertUtils 做 PO↔DTO↔VO 转换）
│       ├── SysUserServiceImpl.java
│       ├── SysRoleServiceImpl.java
│       ├── SysMenuServiceImpl.java
│       └── SysDeptServiceImpl.java
├── mapper/           # 持久层（不变）
└── domain/           # 【核心重构区】
    ├── po/           # (暂保留原Entity作为PO层，向后兼容MyBatis XML映射)
    ├── dto/          # 请求参数对象（含 @Valid 校验）
    │   ├── SysUserDTO.java
    │   ├── SysRoleDTO.java
    │   ├── SysMenuDTO.java
    │   ├── SysDeptDTO.java
    │   ├── SysDictTypeDTO.java
    │   ├── SysDictDataDTO.java
    │   ├── SysConfigDTO.java
    │   ├── SysNoticeDTO.java
    │   └── SysPostDTO.java
    ├── vo/           # 响应视图对象（隐藏密码等敏感字段）
    │   ├── SysUserVO.java         ← 无 password 字段
    │   ├── SysRoleVO.java
    │   ├── SysMenuVO.java
    │   ├── SysDeptVO.java
    │   ├── SysDictTypeVO.java
    │   ├── SysDictDataVO.java
    │   ├── SysConfigVO.java
    │   ├── SysNoticeVO.java
    │   ├── SysPostVO.java
    │   ├── SysOperLogVO.java
    │   ├── SysLogininforVO.java
    │   ├── SysUserOnlineVO.java
    │   └── SysCacheVO.java
    └── query/        # 分页查询对象
        ├── SysUserQuery.java
        ├── SysRoleQuery.java
        ├── SysMenuQuery.java
        ├── SysDeptQuery.java
        ├── SysDictTypeQuery.java
        ├── SysDictDataQuery.java
        ├── SysConfigQuery.java
        ├── SysNoticeQuery.java
        ├── SysPostQuery.java
        ├── SysOperLogQuery.java
        ├── SysLogininforQuery.java
        └── SysUserOnlineQuery.java

ruoyi-quartz/src/main/java/com/ruoyi/quartz/
├── controller/
│   ├── SysJobController.java     ← @Valid SysJobDTO 入参 + SysJobQuery 入参
│   └── SysJobLogController.java  ← SysJobLogQuery 入参 + SysJobLogVO 返回
├── service/
├── mapper/
└── domain/
    ├── dto/    (SysJobDTO.java)
    ├── vo/     (SysJobVO.java, SysJobLogVO.java)
    └── query/  (SysJobQuery.java, SysJobLogQuery.java)

ruoyi-generator/src/main/java/com/ruoyi/generator/
├── controller/
│   └── GenController.java        ← GenTableQuery 入参 + GenTableVO 返回
├── service/
├── mapper/
└── domain/
    ├── vo/     (GenTableVO.java, GenTableColumnVO.java)
    └── query/  (GenTableQuery.java)

ruoyi-common/src/main/java/com/ruoyi/common/utils/
└── BeanConvertUtils.java         # PO/DTO/VO 转换工具类
```

### 2.2 分层职责

| 分层 | 包名 | 职责 | 注解 |
|------|------|------|------|
| **Controller** | `controller/` | 接收请求、参数校验、调用Service、返回响应 | `@Valid` + `@RequestBody DTO` |
| **Service** | `service/` | 业务逻辑、DTO→PO 转换、PO→VO 转换 | `@Service` |
| **Mapper** | `mapper/` | 数据库操作（不变） | MyBatis XML |
| **DTO** | `domain/dto/` | 新增/修改请求参数 | `@NotBlank`, `@Schema` |
| **VO** | `domain/vo/` | 响应数据（隐藏敏感字段） | `@Schema`, `@JsonFormat` |
| **Query** | `domain/query/` | 分页查询条件 | `@Schema`, `params` Map |
| **PO** | `(原Entity)` | 数据库实体（保持不变） | `@Excel`, `@Schema` |

### 2.3 数据流转模式

```
请求 → Controller(@Valid DTO/Query) → Service(DTO→PO转换)
                                           ↓
                                      Mapper(操作PO)
                                           ↓
响应 ← Controller(VO) ← Service(PO→VO转换)
```

### 2.4 转换示例

```java
// Controller: DTO 入参 → PO → Service
@PostMapping
public AjaxResult add(@Valid @RequestBody SysUserDTO dto) {
    SysUser user = BeanConvertUtils.convert(dto, SysUser.class);
    user.setCreateBy(getUsername());
    return toAjax(userService.insertUser(user));
}

// Controller: Query 入参 → PO → 查询 → VO 返回
@GetMapping("/list")
public TableDataInfo list(SysUserQuery query) {
    startPage();
    SysUser user = BeanConvertUtils.convert(query, SysUser.class);
    List<SysUser> list = userService.selectUserList(user);
    List<SysUserVO> voList = BeanConvertUtils.convertList(list, SysUserVO.class);
    return getDataTable(voList);
}

// Controller: PO → VO 详情返回
@GetMapping("/{userId}")
public AjaxResult getInfo(@PathVariable Long userId) {
    SysUser user = userService.selectUserById(userId);
    SysUserVO vo = BeanConvertUtils.convert(user, SysUserVO.class);
    return success(vo);
}
```

---

## 三、重构前后对比

| 维度 | 重构前 | 重构后 |
|------|--------|--------|
| **Swagger UI** | SpringDoc Swagger UI | Knife4j `doc.html`，6模块分组切换 |
| **接口文档** | 仅2个控制器有中文Tag | 24个控制器全中文Tag + 161个@Operation |
| **实体类文档** | 仅TestController有@Schema | 22个实体类完整@Schema中文描述 |
| **入参对象** | 直接透传 Entity（含数据库字段） | DTO（仅必要字段+校验注解） |
| **出参对象** | 直接返回 Entity（含 password） | VO（隐藏敏感字段，仅前端需展示的） |
| **查询对象** | Entity 充当查询条件 | Query（独立查询对象+分页参数） |
| **对象转换** | 无 | BeanConvertUtils（Spring BeanUtils封装） |
| **验证码** | 文档中不可见 | captchaText 字段直接显示数学表达式 |

---

## 四、启动说明

```bash
# 编译
mvn clean compile -DskipTests

# 启动
mvn spring-boot:run -pl ruoyi-admin

# 访问文档
http://localhost:8080/doc.html
```

### Knife4j 使用流程

1. `POST /login` 登录获取 Token
2. 点右上角 🔒 **Authorize** → 粘贴 Token（不要加 `Bearer ` 前缀）→ 点 **Authorize** → Close
3. 右上角下拉切换模块分组
4. 选择接口 → **Try it out** → **Execute**

---

## 五、修改文件统计

| 类别 | 文件数 | 说明 |
|------|--------|------|
| pom.xml | 5 | 依赖管理 |
| 配置类 | 4 | SwaggerConfig, SecurityConfig, ResourcesConfig, application.yml |
| Controller | 24 | @Tag + @Operation + DTO/Query 入参 + VO 返回 |
| Service接口 | 4 | 新增分层方法 |
| Service实现 | 4 | BeanConvertUtils 转换实现 |
| DTO类 | 11 | 请求参数对象 |
| VO类 | 16 | 响应视图对象 |
| Query类 | 14 | 分页查询对象 |
| 工具类 | 1 | BeanConvertUtils |
| 实体类 | 7 | @Schema 注解补充 |
| **总计** | **~90** | — |

---

> 📅 2026-07-01 | 🏷️ v3.9.2-knife4j
