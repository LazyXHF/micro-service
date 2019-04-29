package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.ProjectApprovalService;
import com.portjs.base.service.ProjectPreservationService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gumingyang
 **/
@CrossOrigin
@RestController
@RequestMapping("/FProject")
public class ProjectApprovalController extends BaseController{
    static final String TAG = "FProject===>";
    @Resource
    private ProjectApprovalService projectApprovalService;
    @Resource
    private ProjectPreservationService projectPreservationService;
    
    @RequestMapping("/circulation-project")
    //项目立项过程中的审核流转
    public ResponseMessage insertProjectProcedures(@RequestBody String requestBody) {
        logger.debug("circulation-projectbegin......"+requestBody);
        try {
            return projectApprovalService.insertProjectProcedures(requestBody);
        } catch (Exception e) {
            logger.error("circulation-project()error.....",e);
            throw new RuntimeException();
        }
    }
    @RequestMapping("/circulation-project-registration")
    //项目注册过程中的审核流转
    public ResponseMessage insertProjectProcedureRegistration(@RequestBody String requestBody) {
        logger.debug("circulation-project-registration()......"+requestBody);
        try {
            return projectApprovalService.insertProjectProcedureRegistration(requestBody);
        } catch (Exception e) {
            logger.error("circulation-project-registrationt()error.....",e);
            throw new RuntimeException();
        }
    }
    @RequestMapping("/archive-project")
    //立项阶段的归档操作
    public ResponseMessage projectProceduresArchive(@RequestBody String requestBody) {
        logger.debug("archive-project()begin......"+requestBody);
        try {
            return projectApprovalService.projectProceduresArchive(requestBody);
        } catch (Exception e) {
            logger.error("archive-project()error.....",e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "立项暂存/提交",modelName = "立项保存模块")
    @RequestMapping("/insert-designs")
    @ResponseBody
    public ResponseMessage insertDesigns(@RequestBody String responseBody){
        try {
            logger.error(TAG+"insert-designs()begin....."+responseBody);
            return projectPreservationService.insertStorage(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"insert-designs()error.....",e);
            throw new RuntimeException();
        }
    }
    /**
     *  @api {post} /FProject/query-todos:查询当前登录人的待办事项
     *  @apiName 获取当前登录人的待办事项
     *  @apiGroup 待办模块
     *  @apiversion 1.0.0
     *
     *  @apiDescription 分页条件查询
     *  @apiParam (待办模块) {Object}[TTodo=>{"params":{"pageSize":1,"pageNo":10,"keyword":""},"userId":"","status":""}] (选传参数keyword status method)
     *
     *  @apiSuccessExample Success-Response:
     *  {"code":200,"message":"查询成功","data":{"pageNum":10,"totalCount":11,"totalPage":11,"pageCount":1,"rowNum":9,"isProcessor":null,"typeApply":null,"list":[{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{"returnStatus":"0","projectName":"sfh","type":"1","projectId":"155610364278103"},"id":"155610382778161","currentstepId":"beb3394a-18bd-4b6e-834a-5e4d5762f247","stepDesc":"sfh的立项批复流程等待您的处理","relateddomain":"项目立项","relateddomainId":"155610375053527","senderId":"陶凯","senderTime":"2019-04-24 19:03:48","receiverId":"de4a0a88-f2d3-44aa-8084-6331c059ca09","todoType":"流程审批","actiontime":null,"enable":"1","status":"0","sort":null,"backup3":null,"backUp7":"陶凯","backUp8":null,"backUp9":null}]}}
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 文件找不到
     *     HTTP/1.1 500 内部服务器错误
     *     ...
     *     {
     *       "error": "Exception"
     *     }
     */
    @LogInfo(methodName = "待办任务查询",modelName = "待办模块")
    @RequestMapping("/query-todos")
    @ResponseBody
    public ResponseMessage insertDesigs(@RequestBody String responseBody){
        try {
            logger.error(TAG+"query-todos()begin....."+responseBody);
            return projectApprovalService.queryTodos(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"query-todos()error.....",e);
            throw new RuntimeException();
        }
    }
    @LogInfo(methodName = "待办跳转",modelName = "待办模块")
    @RequestMapping("/todos-go")
    @ResponseBody
    public ResponseMessage todoGo(@RequestBody String responseBody){
        try {
            logger.error(TAG+"todos-go()begin....."+responseBody);
            return projectApprovalService.todoGo(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"todos-go()error.....",e);
            throw new RuntimeException();
        }
    }
    @LogInfo(methodName = "查询项目节点具体信息",modelName = "项目节点模块")
    @RequestMapping("/query-project-details")
    @ResponseBody
    public ResponseMessage queryProjectDetials(@RequestBody String responseBody){
        try {
            logger.error(TAG+"query-project-details()begin....."+responseBody);
            return projectApprovalService.queryProjectDetials(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"query-project-details()error.....",e);
            throw new RuntimeException();
        }
    }
    @LogInfo(methodName = "根据账户登录信息查询所有分管领导信息",modelName = "立项")
    @RequestMapping("/query-applicationer")
    @ResponseBody
    public ResponseMessage queryApplicationer(@RequestBody String responseBody){
        try {
            logger.error(TAG+"query-applicationer()begin....."+responseBody);
            return projectApprovalService.queryApplicationer(responseBody);
        } catch (Exception e) {
            logger.error(TAG+"query-applicationer()error.....",e);
            throw new RuntimeException();
        }
    }
}
