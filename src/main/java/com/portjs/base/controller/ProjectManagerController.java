/*
package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.ProjectManagerService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

*/
/**
 * 根据当前项目id获取所有项目生命周期节点时间，并且
 * 处理项目生命周期时间（计划时间和实际时间的对比处理）
 *
 * 根据项目id来查询当前项目处于哪个节点位置
 *//*

@RequestMapping("project-manager")
@CrossOrigin
@RestController
public class ProjectManagerController extends BaseController{

    static final String tag = "InternalPactService===>";

    ResponseMessage responseMessage = null;

    @Autowired
    ProjectManagerService projectManagerService;

    @RequestMapping("deal-project-time")
    @LogInfo(methodName = "判断当前项目处于哪个节点")
    @ResponseBody
    public ResponseMessage dealProjectTime(@RequestBody String id){
        logger.debug("dealProjectTime() begin...");
        try{
            responseMessage = projectManagerService.dealProjectTime(id);
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"服务器异常"+e);
            logger.error("dealProjectTime() error...",e);
        }
        */
/*logger.debug(tag+id);
        UnifiedExceptionHandler.method= tag+"selectUser=============================="+id;
        responseMessage = projectManagerService.dealProjectTime(id);*//*

        return responseMessage;
    }

}
*/
