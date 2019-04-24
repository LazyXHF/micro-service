package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.ProjectClarificaiton;
import com.portjs.base.entity.PurchaseList;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ProjectClarificaitonService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("projectClarificaiton")
@CrossOrigin
@RestController
public class ProjectClarificaitonController extends BaseController{

    ResponseMessage responseMessage=null;
    static final String TAG = "projectClarificaitonService===>";

    @Autowired
    ProjectClarificaitonService projectClarificaitonService;

    /**
     * 查询项目交底信息并分页且模糊查询
     * @param requestBody
     * @return
     */
    @RequestMapping("query-project-clarificaiton-info")
    @LogInfo(methodName = "查询项目交底信息并分页且模糊查询")
    public ResponseMessage queryByPage(@RequestBody String requestBody) {
        logger.debug(TAG+requestBody);
        UnifiedExceptionHandler.method = TAG + "queryByPage()==================================>" + requestBody;
        responseMessage = projectClarificaitonService.queryByPage(requestBody);
        return responseMessage;
    }

    /**
     * 新建项目交底信息并分页且模糊查询
     * @param record
     * @return
     */
    @RequestMapping("insert-project-clarificaiton-info")
    @LogInfo(methodName = "新建项目交底信息并分页且模糊查询")
    public ResponseMessage insertSelective(@RequestBody ProjectClarificaiton record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method = TAG + "insertSelective()==================================>" + record;
        responseMessage = projectClarificaitonService.insertSelective(record);
        return responseMessage;
    }
    /**
     * 根据id批量软删除项目交底信息
     * @param
     * @return
     */
    @RequestMapping("update-project-clarification-delete-time")
    @LogInfo(methodName = "根据id批量软删除项目交底信息")
    public ResponseMessage updateDeleteTimeByIds(@RequestBody ArrayVO arrayVO) {
        logger.debug(TAG+arrayVO);
        UnifiedExceptionHandler.method = TAG + "updateDeleteTimeByIds============================" +arrayVO;
        responseMessage = projectClarificaitonService.updateDeleteTimeByIds(arrayVO.getList());
        return responseMessage;
    }

    /**
     * 修改项目交底信息
     * @param record
     * @return
     */
    @RequestMapping("update-project-clarification")
    @LogInfo(methodName = "根据id更新修改项目交底信息")
    public ResponseMessage updateByPrimaryKeySelective(@RequestBody ProjectClarificaiton record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method = TAG + "updateByPrimaryKeySelective============================" +record;
        responseMessage = projectClarificaitonService.updateByPrimaryKeySelective(record);
        return responseMessage;
    }

}
