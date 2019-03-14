package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dengshuangzhen on 2019\3\14 0014
 */
@Transactional
public interface UnifiedConfigurationService {

    /**
     *统一模块新增项目等级
     * @param requestBody
     * @return
     */
    ResponseMessage insertProjectLevel(String requestBody);

    /**
     *统一模块查询项目等级
     * @return
     */
    ResponseMessage selectProjectLevel();

    /**
     *统一模块配置设置项目等级
     * @param requestBody
     * @return
     */
    ResponseMessage updateProjectLevel(String requestBody);


    /**
     *统一模块删除项目等级
     * @param requestBody
     * @return
     */
    ResponseMessage deleteProjectLevel(String requestBody);

    /**
     *统一模块新增项目类型
     * @param requestBody
     * @return
     */
    ResponseMessage insertProjectType(String requestBody);

    /**
     *统一模块查询项目类型
     * @return
     */
    ResponseMessage selectProjectType();

    /**
     *统一模块设置项目类型
     * @param requestBody
     * @return
     */
    ResponseMessage updateProjectType(String requestBody);

    /**
     *统一模块删除项目类型
     * @param requestBody
     * @return
     */
    ResponseMessage deleteProjectType(String requestBody);
}
