package com.portjs.base.controller;

import com.portjs.base.entity.ProjectMonthly;
import com.portjs.base.service.ProjectMonthlyService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: daiyueyuan
 * @date: 2019/4/24 10:18
 * @description:
 */


@CrossOrigin
@RestController
@RequestMapping("/projectMonthly")
public class ProjectMonthlyController extends BaseController {
    static final String tag = "ProjectProceduresService===>";
    @Autowired
    private ProjectMonthlyService projectMonthlyService;

    //项目月报新增
    @RequestMapping("/insert_projectMonthly")
    public ResponseMessage insertProjectMonthly(@RequestBody List<ProjectMonthly> projectMonthlyList) {
        logger.debug("insertProjectMonthly()begin......" + projectMonthlyList);
        try {
            return projectMonthlyService.insertProjectMonthly(projectMonthlyList);
        } catch (Exception e) {
            logger.error("select_BusinessConfiguration_ById()error....", e);
            throw new RuntimeException();
        }
    }

    //根据项目id查询里程碑
    @RequestMapping("/select_businessConfiguration")
    public ResponseMessage selectBusinessConfiguration(@RequestBody String requestBody) {
        logger.debug("selectBusinessConfiguration()begin......" + requestBody);
//        try {
            return projectMonthlyService.selectBusinessConfiguration(requestBody);
//        } catch (Exception e) {
//            logger.error("select_BusinessConfiguration_ById()error....", e);
//            throw new RuntimeException();
//        }
    }

    //月报查询
    @RequestMapping("/select_projectMonthly")
    public ResponseMessage selectProjectMonthly(@RequestBody String requestBody) {
        logger.debug("selectProjectMonthly()begin......" + requestBody);
        try {
            return projectMonthlyService.selectProjectMonthly(requestBody);
        } catch (Exception e) {
            logger.error("selectProjectMonthly()error....", e);
            throw new RuntimeException();
        }
    }
}
