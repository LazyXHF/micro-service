package com.portjs.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Problem;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ProblemService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gumingyang
 **/
@CrossOrigin
@Controller
@RequestMapping("/problem")
public class ProblemController extends BaseController {
    static final  String TAG = "ProblemController================>";
    @Resource
    private ProblemService problemService;

    @LogInfo(methodName = "批量添加问题",modelName = "问题模块")
    @RequestMapping("/insert-problems")
    @ResponseBody
    public ResponseMessage insertDesigns(@RequestBody String responseBody){
        //node 1:开发2:设计3:试点实施4:立项
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-problems==============================" + responseBody;
        JSONArray requestJson = JSON.parseArray(responseBody);
        return problemService.insertSelective(requestJson);
    }

    @LogInfo(methodName = "单条添加问题",modelName = "问题模块")
    @RequestMapping("/insert-problem")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-problem==============================" + responseBody;
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        Problem problem = JSONObject.toJavaObject(jsonObject,Problem.class);
        return problemService.insertProblem(problem);
    }

    @LogInfo(methodName = "修改问题",modelName = "问题模块")
    @RequestMapping("/update-problem")
    @ResponseBody
    public ResponseMessage updateDesign(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "update-problem==============================" + responseBody;
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        Problem problem = JSONObject.toJavaObject(jsonObject,Problem.class);
        return problemService.updateByPrimaryKeySelective(problem);
    }

    @LogInfo(methodName = "查询所有问题",modelName = "问题模块")
    @RequestMapping("/select-problem")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        return problemService.selectByPrimaryKey(responseBody);
    }
    @LogInfo(methodName = "删除问题",modelName = "问题模块")
    @RequestMapping("/delete-problem")
    @ResponseBody
    public ResponseMessage deleteDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONArray requestJson = JSON.parseArray(responseBody);
        List<String> record = JSONObject.parseArray(requestJson.toJSONString(), String.class);
        return problemService.deleteByPrimaryKey(record);
    }
}
