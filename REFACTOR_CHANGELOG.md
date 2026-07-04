# 若依 RuoYi-Vue 分层架构重构文档

> PO/DTO/VO/Query 分层架构重构 + Knife4j 文档升级 + 通用基类体系 + 注解驱动自动CRUD

---

## 一、Knife4j 接口文档升级

- `knife4j-openapi3-ui:4.0.0` 替换 SpringDoc Swagger UI
- `SwaggerConfig.java`：HTTP Bearer认证 + 7模块 GroupedOpenApi 分组（系统/监控/通用/定时任务/代码生成/测试/医院）
- 24个Controller + 22个实体类 全中文 @Tag/@Operation/@Schema
- 验证码接口新增 `captchaText` 返回字段

## 二、通用基类体系

| 基类 | 包路径 | 字段 | 适用 |
|------|--------|------|------|
| `BasePO` | `domain` | id(String), gmtCreate, gmtModified | varchar主键PO |
| `BaseIntPO` | `po` | id(Long), gmtCreate, gmtModified | Long主键PO |
| `BusinessPO` | `po` | extends BasePO + createUserId, createUserName, updateUserId, updateUserName, isDeleted, version, memo | varchar主键业务表 |
| `BusinessIntPO` | `po` | extends BaseIntPO + 同上 | Long主键业务表 |
| `BaseDTO` | `domain` | id(String), version, memo | varchar主键DTO |
| `BaseIntDTO` | `domain` | id(Long), version, memo | Long主键DTO |
| `PageQuery` | `domain` | pageNum, pageSize | 分页查询基类 |
| `BaseMapper<T,ID>` | `mapper` | @SelectProvider注解驱动CRUD | 通用Mapper |
| `BaseMapperProvider` | `mapper` | 自动生成INSERT/UPDATE/DELETE/SELECT SQL | SQL生成器 |
| `BaseService<T,ID>` | `service` | 通用Service接口 | 业务层 |
| `BaseServiceImpl<M,T,ID>` | `service` | 注入Mapper即可 | 业务实现 |

### 继承链

```
PO extends BusinessPO (@Data)
DTO extends BaseDTO (@Data)
Query extends PageQuery (@Data)
Mapper extends BaseMapper<T, ID>    → 基础CRUD无需手写SQL
Service extends BaseServiceImpl     → 注入Mapper即获得全部CRUD
```

## 三、注解驱动自动CRUD

`BaseMapper<T, ID>` 通过 `@SelectProvider`/`@InsertProvider`/`@UpdateProvider`/`@DeleteProvider` 注解绑定 `BaseMapperProvider`，运行时自动生成 CRUD SQL。

```java
@Mapper
public interface RyHospitalMapper extends BaseMapper<RyHospital, String> {
    // 基础CRUD由注解生成，无需声明
    // 只写自定义查询
    List<RyHospital> selectHospitalList(RyHospitalQuery query);
}
```

**XML只写自定义查询**，基础CRUD不再需要手写SQL。

## 四、jiawei-hospital 参考模块

完整示例模块，按新标准实现：

| 文件 | 继承 | 说明 |
|------|------|------|
| `po/RyHospital.java` | BusinessPO | 表名驼峰，只定义业务字段 |
| `dto/RyHospitalDTO.java` | BaseDTO | id/version/memo 由基类提供 |
| `vo/RyHospitalVO.java` | 独立 | 响应字段 |
| `query/RyHospitalQuery.java` | PageQuery | 查询条件 + pageNum/pageSize |
| `mapper/RyHospitalMapper.java` | BaseMapper<RyHospital, String> | 注解驱动CRUD |
| `service/IRyHospitalService.java` | BaseService<RyHospital, String> | 接口 |
| `service/impl/RyHospitalServiceImpl.java` | BaseServiceImpl | 空实现获全部CRUD |
| `controller/RyHospitalController.java` | BaseController | DTO/Query入参，VO返回 |

## 五、命名规范

| 层 | 规则 | 示例 |
|-----|------|------|
| PO | 表名驼峰 | `ry_hospital` → `RyHospital` |
| DTO | 实体名 + DTO | `RyHospitalDTO` |
| VO | 实体名 + VO | `RyHospitalVO` |
| Query | 实体名 + Query | `RyHospitalQuery` |
| Mapper | 实体名 + Mapper | `RyHospitalMapper` |
| Service | I + 实体名 + Service | `IRyHospitalService` |

## 六、Javadoc 规范

```java
/**
 * 获取医院列表
 *
 * @param query 查询条件
 * @return com.ruoyi.common.core.page.TableDataInfo
 * @author YiJiawei
 * @date 2026/7/4
 **/
```

## 七、文档

| 文件 | 用途 |
|------|------|
| `CLAUDE.md` | 项目编码规范 + 架构说明 |
| `.claude/refactor_prompt.md` | AI重构提示模板 |
| `REFACTOR_CHANGELOG.md` | 重构记录（本文件） |
