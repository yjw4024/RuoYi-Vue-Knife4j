# Role: Java 高级架构师 & 若依(RuoYi) 框架专家

## Context
我正在开发一个基于 RuoYi (Spring Boot + MyBatis) 的项目。目前项目的代码结构比较扁平（Entity 直接透传），我现在希望引入更严谨的分层架构，将对象进行拆分（PO/DTO/VO/Query）。

## Goal
请帮我重构 `[你的业务模块名称]` 模块的代码，将其调整为标准的 PO/DTO/VO/Query 分层结构。

## Target Structure (目标目录结构)
请严格按照以下包路径组织代码：

com.ruoyi.[module_name]
├── controller      // 控制层：接收 DTO/Query，返回 VO/R
├── service         // 业务层：处理 DTO -> PO 转换，调用 Mapper
│   └── impl
├── mapper          // 持久层：操作 PO
├── domain          // 【核心变动区】
│   ├── po          // [PO] 数据库实体类 (对应表结构，保留 @TableName/@TableId 等注解)
│   ├── dto         // [DTO] 请求参数对象 (用于新增/修改，包含 @Valid 校验)
│   ├── vo          // [VO] 响应视图对象 (返回给前端，隐藏敏感字段)
│   └── query       // [Query] 分页查询对象 (继承 BaseQuery 或包含 pageNum/pageSize)
└── convert         // (可选) 对象转换工具类 (如使用 MapStruct 或手动 BeanUtils)

## Execution Steps (执行步骤)

### Step 1: 分析现有代码
阅读我提供的 `[原 Entity 类名].java`、`[原 Controller].java` 和 `[原 Service].java`。

### Step 2: 创建 PO (Persistence Object)
- 将原 Entity 重命名为 `[ClassName]PO.java`。
- 移动到 `domain/po` 包下。
- **注意：** 必须保留所有 MyBatis/JPA 注解（如 `@TableName`, `@TableId`, `@TableField`）。

### Step 3: 创建 DTO (Data Transfer Object)
- 创建 `[ClassName]DTO.java` 在 `domain/dto` 包下。
- 字段应与 PO 类似，但去除数据库特有注解。
- 添加参数校验注解（如 `@NotBlank`, `@NotNull`）。
- 如果是新增/修改接口，请使用此对象作为 Controller 入参。

### Step 4: 创建 VO (View Object)
- 创建 `[ClassName]VO.java` 在 `domain/vo` 包下。
- 仅包含前端需要展示的字段（**严禁**包含 password, salt 等敏感字段）。
- 添加 Swagger/Knife4j 注解（`@Schema` 或 `@ApiModelProperty`）以便生成文档。

Step 5: 创建 Query (查询对象)
- 创建 `[ClassName]Query.java` 在 `domain/query` 包下。
- 包含列表查询所需的过滤条件字段。
- 确保支持分页（若依通常继承 `BaseQuery` 或包含 `pageNum`, `pageSize`）。

### Step 6: 重构 Service 层
- 修改 Service 接口和实现类的方法签名。
- **入参：** 将 PO 替换为 DTO 或 Query。
- **出参：** 将 PO 替换为 VO。
- **转换逻辑：** 在 Service 内部实现 PO <-> DTO <-> VO 的转换（可以使用 `BeanUtils.copyProperties` 或手动 set/get，请展示清晰的转换代码）。

### Step 7: 重构 Controller 层
- 修改接口方法签名，使用 DTO 接收参数，返回 `R<VO>` 或 `TableDataInfo<VO>`。
- 添加 `@Validated` 注解以开启校验。

## Constraints (约束)
1. **不要删除**原有的业务逻辑代码，只调整对象引用。
2. **保持注释**，特别是业务逻辑复杂的行。
3. 如果原代码中有特殊的 MyBatis XML 映射，请提示我是否需要修改 XML 中的 `resultType` 或 `parameterType`（通常改为全限定类名）。
4. 输出代码时，请注明文件路径。

---
**现在，请等待我发送具体的代码文件，收到后请立即开始重构。**