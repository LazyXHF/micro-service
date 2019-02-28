package com.mgt.common.utils.swagger;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: mgt-contrl-platform
 * @description: 读取swagger2配置
 * @author: Mr.Gu
 * @create: 2019-02-28 9:27
 **/
@Component
@PropertySource(value = "classpath:application-swagger2.yml", ignoreResourceNotFound = true,encoding = "UTF-8" )
@ConfigurationProperties(prefix = "template" ,ignoreInvalidFields = true)
@Data
public class TemplateConfig
{
    @Value("${name}")
    private String name;

    @Value("${version}")
    private String version;

    @Value("${copyright-year}")
    private String copyrightYear;

    @Value("${email}")
    private String email;

    @Value("${url}")
    private String url;

    @Value("${base-package}")
    private String basePackage;

    @Value("${title}")
    private  String title;

    @Value("${description}")
    private String description;

    @Value("${enable}")
    private String enableSwagger;
}
