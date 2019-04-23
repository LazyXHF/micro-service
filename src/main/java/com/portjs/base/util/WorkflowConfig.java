package com.portjs.base.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by dengshuangzhen on 2019\4\23 0023
 */
@Component
/*@ConfigurationProperties("workflower.properties")*/
public class WorkflowConfig {
    @Value("${lxfgRoleId}")
    public String lxFgRoleId;

    @Value("${lxjswyhRoleId}")
    public String lxjswyhRoleId;

    @Value("${lxzjbRoleId}")
    public String lxzjbRoleId;

    @Value("${lxghbRoleId}")
    public String lxghbRoleId;
}
