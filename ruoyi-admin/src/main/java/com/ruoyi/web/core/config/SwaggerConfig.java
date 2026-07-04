package com.ruoyi.web.core.config;

import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ruoyi.common.config.RuoYiConfig;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * Swagger/Knife4j 接口配置
 *
 * @author ruoyi
 */
@Configuration
public class SwaggerConfig
{
    @Autowired
    private RuoYiConfig ruoyiConfig;

    @Bean
    public OpenAPI customOpenApi()
    {
        return new OpenAPI()
            .components(new Components()
                .addSecuritySchemes("Authorization", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("token")
                    .description("登录后粘贴Token即可（不要加Bearer前缀）")))
            // 全局安全要求
            .addSecurityItem(new SecurityRequirement().addList("Authorization"))
            .info(getApiInfo());
    }


    @Bean
    public GlobalOpenApiCustomizer globalOpenApiCustomizer()
    {
        return openApi -> {
            if (openApi.getPaths() != null) {
                var securityReq = new SecurityRequirement().addList("Authorization");
                openApi.getPaths().forEach((path, pathItem) -> {
                    pathItem.readOperations().forEach(op -> {
                        // 子模块中文标签
                        if (path.startsWith("/monitor/job")) {
                            op.setTags(java.util.List.of("定时任务"));
                        } else if (path.startsWith("/tool/gen")) {
                            op.setTags(java.util.List.of("代码生成"));
                        }
                        // 显式添加操作级安全要求，确保Knife4j发送Authorization头
                        op.addSecurityItem(securityReq);
                    });
                });
            }
        };
    }

    @Bean
    public GroupedOpenApi systemApi()
    {
        return GroupedOpenApi.builder().group("system").displayName("系统模块")
                .packagesToScan("com.ruoyi.web.controller.system").build();
    }

    @Bean
    public GroupedOpenApi monitorApi()
    {
        return GroupedOpenApi.builder().group("monitor").displayName("监控模块")
                .packagesToScan("com.ruoyi.web.controller.monitor").build();
    }

    @Bean
    public GroupedOpenApi commonApi()
    {
        return GroupedOpenApi.builder().group("common").displayName("通用模块")
                .packagesToScan("com.ruoyi.web.controller.common").build();
    }

    @Bean
    public GroupedOpenApi quartzApi()
    {
        return GroupedOpenApi.builder().group("quartz").displayName("定时任务")
                .packagesToScan("com.ruoyi.quartz.controller").build();
    }

    @Bean
    public GroupedOpenApi generatorApi()
    {
        return GroupedOpenApi.builder().group("generator").displayName("代码生成")
                .packagesToScan("com.ruoyi.generator.controller").build();
    }

    @Bean
    public GroupedOpenApi testApi()
    {
        return GroupedOpenApi.builder().group("test").displayName("测试模块")
                .packagesToScan("com.ruoyi.web.controller.tool").build();
    }

    @Bean
    public GroupedOpenApi hospitalApi()
    {
        return GroupedOpenApi.builder().group("hospital").displayName("医院管理")
                .packagesToScan("com.ruoyi.hospital.controller").build();
    }

    public Info getApiInfo()
    {
        return new Info()
            .title("标题：若依管理系统_接口文档")
            .description("描述：用于管理集团旗下公司的人员信息,具体包括XXX,XXX模块...")
            .contact(new Contact().name(ruoyiConfig.getName()))
            .version("版本号:" + ruoyiConfig.getVersion());
    }
}
