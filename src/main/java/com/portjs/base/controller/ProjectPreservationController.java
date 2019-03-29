package com.portjs.base.controller;

/**
 * Created by dengshuangzhen on 2019\3\28 0028
 * 立项保存
 */

import com.portjs.base.aop.LogInfo;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ProjectPreservationService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@CrossOrigin
@Controller
@RequestMapping("/projectPreservation")
public class ProjectPreservationController  extends BaseController {
    static final  String TAG = "ProjectController================>";
    @Resource
    private ProjectPreservationService projectPreservationService;
    @LogInfo(methodName = "立项暂存/提交",modelName = "立项保存模块")
    @RequestMapping("/insert-designs")
    @ResponseBody
    public ResponseMessage insertDesigns(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-designs==============================" + responseBody;
        return projectPreservationService.insertStorage(responseBody);
    }

    @LogInfo(methodName = "立项退回",modelName = "立项保存模块")
    @RequestMapping("/return-designs")
    @ResponseBody
    public ResponseMessage returnDesigns(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "insert-designs==============================" + responseBody;
        return projectPreservationService.returnStorage(responseBody);
    }

}
