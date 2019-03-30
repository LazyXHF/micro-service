package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.UnifiedConfigurationService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengshuangzhen on 2019\3\14 0014
 */
@RestController
@CrossOrigin
@RequestMapping("/unifiedConfiguration")
public class UnifiedConfigurationController extends BaseController {
    private String tag = "DepartmentController=======>";
    @Autowired
    private UnifiedConfigurationService unifiedConfigurationService;


    /**
     *统一模块新增项目等级
     * @param requestBody
     * @return
     */
    /*@LogInfo(methodName = "统一模块新增项目等级")
    @RequestMapping("insert-project-level")
    public ResponseMessage insertProjectLevel (@RequestBody String requestBody)  {
        logger.debug("insertProjectLevel() begin body={}",requestBody);
        UnifiedExceptionHandler.method= tag+"insertProjectLevel=============================="+requestBody;
        ResponseMessage responseMessage=  unifiedConfigurationService.insertProjectLevel(requestBody);
        return responseMessage;
    }*/

    /**
     *统一模块查询项目等级
     * @return
     */
    @LogInfo(methodName = "统一模块查询项目等级")
    @RequestMapping("select-project-level")
    public ResponseMessage selectProjectLevel ()  {
        logger.debug("selectProjectLevel() begin body={}");
        UnifiedExceptionHandler.method= tag+"selectProjectLevel==============================";
        ResponseMessage responseMessage=  unifiedConfigurationService.selectProjectLevel();
        return responseMessage;
    }

    /**
     *统一模块设置项目等级
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "统一模块配置设置项目等级")
    @RequestMapping("update-project-level")
    public ResponseMessage updateProjectLevel (@RequestBody String requestBody)  {
        logger.debug("updateProjectLevel() begin body={}",requestBody);
        UnifiedExceptionHandler.method= tag+"updateProjectLevel=============================="+requestBody;
        ResponseMessage responseMessage=  unifiedConfigurationService.updateProjectLevel(requestBody);
        return responseMessage;
    }

    /**
     *统一模块删除项目等级
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "统一模块删除项目等级")
    @RequestMapping("delete-project-level")
    public ResponseMessage deleteProjectLevel (@RequestBody String requestBody)  {
        logger.debug("deleteProjectLevel() begin body={}",requestBody);
        UnifiedExceptionHandler.method= tag+"deleteProjectLevel=============================="+requestBody;
        ResponseMessage responseMessage=  unifiedConfigurationService.deleteProjectLevel(requestBody);
        return responseMessage;
    }




    /**
     *统一模块新增项目类型
     * @param requestBody
     * @return
     */
    /*@LogInfo(methodName = "统一模块新增项目类型")
    @RequestMapping("insert-project-type")
    public ResponseMessage insertProjectType (@RequestBody String requestBody)  {
        logger.debug("insertProjectType() begin body={}",requestBody);
        UnifiedExceptionHandler.method= tag+"insertProjectType=============================="+requestBody;
        ResponseMessage responseMessage=  unifiedConfigurationService.insertProjectType(requestBody);
        return responseMessage;
    }*/

    /**
     *统一模块查询项目类型
     * @return
     */
    @LogInfo(methodName = "统一模块查询项目类型")
    @RequestMapping("select-project-type")
    public ResponseMessage selectProjectType ()  {
        logger.debug("selectProjectType() begin body={}");
        UnifiedExceptionHandler.method= tag+"selectProjectType==============================";
        ResponseMessage responseMessage=  unifiedConfigurationService.selectProjectType();
        return responseMessage;
    }

    /**
     *统一模块设置项目类型
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "统一模块设置项目类型")
    @RequestMapping("update-project-type")
    public ResponseMessage updateProjectType (@RequestBody String requestBody)  {
        logger.debug("updateProjectType() begin body={}",requestBody);
        UnifiedExceptionHandler.method= tag+"updateProjectType=============================="+requestBody;
        ResponseMessage responseMessage=  unifiedConfigurationService.updateProjectType(requestBody);
        return responseMessage;
    }

    /**
     *统一模块删除项目类型
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "统一模块删除项目类型")
    @RequestMapping("delete-project-type")
    public ResponseMessage deleteProjectType (@RequestBody String requestBody)  {
        logger.debug("deleteProjectType() begin body={}",requestBody);
        UnifiedExceptionHandler.method= tag+"deleteProjectType=============================="+requestBody;
        ResponseMessage responseMessage=  unifiedConfigurationService.deleteProjectType(requestBody);
        return responseMessage;
    }


}
