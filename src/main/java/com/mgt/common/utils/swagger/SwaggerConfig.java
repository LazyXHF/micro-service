package com.mgt.common.utils.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: mgt-contrl-platform
 * @description: swagger2自定义配置
 * @author: Mr.Gu
 * @create: 2019-02-27 12:27
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Autowired
    private TemplateConfig templateConfig;

    /**
     * @description: 加入自定义信息到swagger2中并指定扫描包
     * @return
     */
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(Boolean.parseBoolean(templateConfig.getEnableSwagger()))
                .select()
                .apis(RequestHandlerSelectors.basePackage(templateConfig.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @description: 自定义项目相关信息
     * @return
     */
    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("标题：" + templateConfig.getTitle())
                .description("描述：" + templateConfig.getDescription())
                .contact(new Contact(templateConfig.getName(), templateConfig.getUrl(), templateConfig.getEmail()))
                .version("版本号:" + templateConfig.getVersion())
                .build();
    }
}
