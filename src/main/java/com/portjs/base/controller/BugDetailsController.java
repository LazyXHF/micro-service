package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.BugDetails;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.BugDetailsService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * bug模块
 */
@RequestMapping("bug-details")
@CrossOrigin
@RestController
public class BugDetailsController extends BaseController{
    static final String TAG = "InternalProjectService===>";
    ResponseMessage responseMessage;

    @Autowired
    BugDetailsService bugDetailsService;


    /**
     * TODO 查询项目相关Bug信息并分页
     * @param
     * @return
     */
    @LogInfo(methodName = "查询Bug信息",modelName = "缺陷模块")
    @RequestMapping("query-all-bug-info")
    @ResponseBody
    public ResponseMessage queryAllBugInfo(@RequestBody String requestBody){
        logger.debug(TAG+requestBody);
        /*int pageNo = pageVo.getPageNo();
        int pageSize = pageVo.getPageSize();*/
        UnifiedExceptionHandler.method= TAG+"queryAllBugInfo=============================="+requestBody;
        responseMessage = bugDetailsService.queryAllBugInfo(requestBody);
        return responseMessage;
    }
    /**
     *  TODO 更新Bug信息
     * @param record
     * @return
     */
    @RequestMapping("update-bug-info")
    @LogInfo(methodName = "添加Bug信息")
    @ResponseBody
    public ResponseMessage updateByPrimaryKeySelective(@RequestBody BugDetails record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method= record + "update-bug-info==============================" + record;
        return bugDetailsService.updateByPrimaryKeySelective(record);
    }

    /**
     *  TODO 根据自身id查询Bug信息
     * @param id
     * @return
     */
    @RequestMapping("select-bug-info")
    @LogInfo(methodName = "根据自身id查询Bug信息")
    @ResponseBody
    public ResponseMessage selectBugInfo(@RequestBody String id) {
        logger.debug(TAG+id);
        JSONObject jsonObject = JSONObject.parseObject(id);
        String ids = jsonObject.getString("id");
        UnifiedExceptionHandler.method= ids + "select-bug-info==============================" + ids;
        return bugDetailsService.selectByPrimaryKey(ids);
    }
    /**
     * TODO 添加项目相关Bug信息
     * @param record
     * @return
     */
    @RequestMapping("insert-bug-info")
    @LogInfo(methodName = "添加Bug信息")
    public ResponseMessage insertBugInfo(@RequestBody BugDetails record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method= record + "update-bug-info==============================" + record;
        responseMessage = bugDetailsService.insertSelective(record);
        return responseMessage;
    }
    /**
     * TODO 根据id批量删除Bug信息
     * @param
     * @return
     */
    @RequestMapping("delete-bug-info")
    @LogInfo(methodName = "根据id删除Bug信息")
    public ResponseMessage deleteBugInfo(@RequestBody ArrayVO arrayVO) {
        logger.debug(TAG+arrayVO);
        UnifiedExceptionHandler.method = TAG + "deleteBugInfo============================" +arrayVO;
        responseMessage = bugDetailsService.deleteByPrimaryKey(arrayVO.getList());
        return responseMessage;
    }

    /**
     * TODO 查询所有Bug信息
     * @return
     */
    @RequestMapping("query-bug-infos")
    @LogInfo(methodName = "查询Bug信息")
    public ResponseMessage queryBugInfos() {
        logger.debug(TAG);
        UnifiedExceptionHandler.method= "query-bug-infos==============================";
        responseMessage = bugDetailsService.queryAllBugInfos();
        return responseMessage;
    }

}
