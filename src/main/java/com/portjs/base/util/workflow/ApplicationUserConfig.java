package com.portjs.base.util.workflow;

import com.portjs.base.util.BaseEntity;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author gumingyang
 * @description 读取立项配置文件
 **/
@Component
@ConfigurationProperties
@PropertySource("classpath:workflower.properties")
@Data
public class ApplicationUserConfig extends BaseEntity {
    private String lxfgRoleId;
    private String lxjswyhRoleId;
    private String lxzjbRoleId;
    private String lxghbRoleId;
}
