# Role: RuoYi Framework Expert & Java Architect

## Project Context
这是一个基于 RuoYi (Spring Boot + MyBatis) 的多模块后端项目。
- Spring Boot 4.0.3 + Spring Framework 7.0.5 + JDK 17
- 已升级 Knife4j 接口文档（springdoc-openapi + knife4j-openapi3-ui 4.0.0）
- 通用基类体系：BasePO / BaseIntPO / BusinessPO / BusinessIntPO / BaseDTO / BaseIntDTO / PageQuery
- BaseMapper<T,ID> + BaseMapperProvider 注解驱动自动 CRUD（无需手写基础 SQL）
- 参考模块：ruoyi-jiawei-hospital（完整示例）

## 通用基类（ruoyi-common）

### PO 基类层次

```
BasePO (varchar主键: id, gmtCreate, gmtModified)
  └── BusinessPO (+ createUserId, createUserName, updateUserId, updateUserName, isDeleted, version, memo)

BaseIntPO (Long主键: id, gmtCreate, gmtModified)
  └── BusinessIntPO (+ 同上业务字段)
```

| 基类 | 位置 | 适用场景 |
|------|------|----------|
| `BasePO` | `domain/BasePO.java` | varchar主键表，只有创建/修改时间 |
| `BaseIntPO` | `po/BaseIntPO.java` | 自增Long主键表，只有创建/修改时间 |
| `BusinessPO` | `po/BusinessPO.java` | varchar主键 + 审计/逻辑删除/乐观锁 |
| `BusinessIntPO` | `po/BusinessIntPO.java` | Long主键 + 审计/逻辑删除/乐观锁 |

### DTO 基类

| 基类 | 位置 | 适用场景 |
|------|------|----------|
| `BaseDTO` | `domain/BaseDTO.java` | varchar主键 (id, version, memo) |
| `BaseIntDTO` | `domain/BaseIntDTO.java` | Long主键 (id, version, memo) |

### Query 基类

| 基类 | 位置 | 字段 |
|------|------|------|
| `PageQuery` | `domain/PageQuery.java` | pageNum, pageSize |

### Mapper/Service 基类

| 基类 | 位置 | 用途 |
|------|------|------|
| `BaseMapper<T,ID>` | `mapper/BaseMapper.java` | 注解驱动自动CRUD（@SelectProvider/@InsertProvider） |
| `BaseMapperProvider` | `mapper/BaseMapperProvider.java` | 通用CRUD SQL生成器 |
| `BaseService<T,ID>` | `service/BaseService.java` | 通用Service接口 |
| `BaseServiceImpl<M,T,ID>` | `service/BaseServiceImpl.java` | 通用Service实现 |

### Mapper 继承链

```
你的Mapper extends BaseMapper<Xxx, ID>
    ↓
BaseMapper 通过 @SelectProvider/@InsertProvider 注解自动生成 CRUD SQL
    ↓
基础CRUD无需手写SQL，也无需XML
    ↓
复杂查询才在XML中手写
```

### 分层继承链

```
PO extends BusinessPO (@Data)        → 自动获得 id/createUserId/gmtCreate/version/isDeleted 等
DTO extends BaseDTO (@Data)          → 自动获得 id/version/memo
Query extends PageQuery (@Data)      → 自动获得 pageNum/pageSize
Mapper extends BaseMapper<Xxx, ID>   → 自动获得 CRUD 方法
Service extends BaseServiceImpl      → 注入Mapper即获得全部CRUD
```

**新模块必须**：全部使用 `@Data`（Lombok），继承对应基类。

## 模块结构

```
ruoyi-admin/             # Controller 层
ruoyi-common/            # 通用工具 + 基类 + BaseEntity
ruoyi-framework/         # 安全/配置层
ruoyi-system/            # 系统业务模块（传统方式）
ruoyi-quartz/            # 定时任务模块
ruoyi-generator/         # 代码生成模块
ruoyi-jiawei-hospital/   # 医院模块（新标准参考）
```

## 新模块标准结构（以 jiawei-hospital 为例）

```
ruoyi-jiawei-hospital/
├── pom.xml
└── src/main/
    ├── java/com/ruoyi/hospital/
    │   ├── controller/RyHospitalController.java
    │   ├── service/IRyHospitalService.java
    │   ├── service/impl/RyHospitalServiceImpl.java
    │   ├── mapper/RyHospitalMapper.java
    │   └── domain/
    │       ├── po/RyHospital.java          ← 表名驼峰命名，extends BusinessPO
    │       ├── dto/RyHospitalDTO.java      ← extends BaseDTO + @Data
    │       ├── vo/RyHospitalVO.java        ← 独立VO（无基类）
    │       └── query/RyHospitalQuery.java  ← extends PageQuery + @Data
    └── resources/
        └── mapper/RyHospitalMapper.xml     ← 只写自定义查询
```

### 命名规范

- **PO类名**：表名驼峰（如 `ry_hospital` → `RyHospital`），不加 PO 后缀
- **DTO类名**：实体名 + `DTO`（如 `RyHospitalDTO`）
- **VO类名**：实体名 + `VO`（如 `RyHospitalVO`）
- **Query类名**：实体名 + `Query`（如 `RyHospitalQuery`）
- **Mapper类名**：实体名 + `Mapper`（如 `RyHospitalMapper`）
- **Service类名**：`I` + 实体名 + `Service`（如 `IRyHospitalService`）
- **Controller类名**：实体名 + `Controller`（如 `RyHospitalController`）

## Javadoc 规范

```java
/**
 * 方法功能描述
 *
 * @param dto 参数说明
 * @return 返回值类型
 * @author YiJiawei
 * @date 2026/7/4
 **/
```

每个方法必须写 Javadoc，包含 `@param`、`@return`、`@author YiJiawei`、`@date`。

## Knife4j 文档规范

- 每个 Controller 必须有 `@Tag(name = "中文名称")`
- 每个方法必须有 `@Operation(summary = "中文说明")`
- 所有实体/基类字段必须有 `@Schema(description = "中文说明")`

### SwaggerConfig 关键配置

- Security: HTTP Bearer (`scheme("bearer")` 小写)，安全方案名 `bearerAuth`
- `GroupedOpenApi` bean 分组切换（7组：系统/监控/通用/定时任务/代码生成/测试/医院）
- `GlobalOpenApiCustomizer` 处理子模块中文 Tag + 操作级 SecurityRequirement

## 编码模板

### Controller

```java
@Tag(name = "医院管理")
@RestController
@RequestMapping("/hospital")
public class RyHospitalController extends BaseController {
    @Autowired
    private IRyHospitalService hospitalService;

    @GetMapping("/list")
    public TableDataInfo list(RyHospitalQuery query) {
        startPage();
        RyHospital search = BeanConvertUtils.convert(query, RyHospital.class);
        return getDataTable(BeanConvertUtils.convertList(hospitalService.selectList(search), RyHospitalVO.class));
    }

    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable String id) {
        return success(BeanConvertUtils.convert(hospitalService.selectById(id), RyHospitalVO.class));
    }

    @PostMapping
    public AjaxResult add(@Valid @RequestBody RyHospitalDTO dto) {
        RyHospital po = BeanConvertUtils.convert(dto, RyHospital.class);
        po.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return toAjax(hospitalService.insert(po));
    }

    @PutMapping
    public AjaxResult edit(@Valid @RequestBody RyHospitalDTO dto) {
        return toAjax(hospitalService.updateById(BeanConvertUtils.convert(dto, RyHospital.class)));
    }

    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable String id) {
        return toAjax(hospitalService.deleteById(id));
    }
}
```

### Service

```java
// 接口
public interface IRyHospitalService extends BaseService<RyHospital, String> { }

// 实现（继承BaseServiceImpl自动获得全部CRUD，无需写任何代码）
@Service
public class RyHospitalServiceImpl extends BaseServiceImpl<RyHospitalMapper, RyHospital, String>
        implements IRyHospitalService { }
```

### Mapper

```java
@Mapper
public interface RyHospitalMapper extends BaseMapper<RyHospital, String> {
    // 基础CRUD由BaseMapper注解自动生成，无需声明
    // 复杂查询在此声明，XML中实现
    List<RyHospital> selectHospitalList(RyHospitalQuery query);
}
```

### Mapper XML（只写自定义查询）

```xml
<mapper namespace="com.ruoyi.hospital.mapper.RyHospitalMapper">
    <!-- 基础CRUD由BaseMapperProvider自动生成，无需在此定义 -->

    <select id="selectHospitalList" resultMap="BaseResultMap">
        SELECT * FROM ry_hospital WHERE is_deleted = 0
        <if test="hospitalName != null">AND hospital_name LIKE CONCAT('%', #{hospitalName}, '%')</if>
        ORDER BY gmt_create DESC
    </select>
</mapper>
```

## 工作流（新增模块）

1. 数据库中建表
2. 创建 Maven 模块 + pom.xml（依赖 ruoyi-common + lombok）
3. 创建 PO 继承 `BusinessPO`（varchar主键）或 `BusinessIntPO`（Long主键）
4. 创建 DTO 继承 `BaseDTO` 或 `BaseIntDTO`
5. 创建 Query 继承 `PageQuery`
6. 创建 VO（独立）
7. 创建 Mapper 继承 `BaseMapper<Xxx, ID>`，XML 只写自定义查询
8. 创建 Service 继承 `BaseServiceImpl`
9. 创建 Controller 继承 `BaseController`
10. 注册到根 pom、ruoyi-admin/pom、SwaggerConfig、SecurityConfig
11. 编译验证：`mvn compile -DskipTests`
