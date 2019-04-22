package com.portjs.base.controller;

import com.portjs.base.service.BusinessConfigurationService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: daiyueyuan
 * @date: 2019/4/18 17:42
 * @description:
 */

@CrossOrigin
@RestController
@RequestMapping("/businessConfiguration")
public class BusinessConfigurationController extends BaseController {
    static final String tag = "ProjectProceduresService===>";

    @Autowired
    private BusinessConfigurationService businessConfigurationService;

    //根据项目ID查询概览
    @RequestMapping("/select_BusinessConfiguration_ById")
    public ResponseMessage selectBusinessConfigurationById(@RequestBody String requestBody) {
        logger.debug("select_BusinessConfiguration_ById()begin......" + requestBody);
//        try {
            return businessConfigurationService.selectBusinessConfigurationById(requestBody);
//        } catch (Exception e) {
//            logger.error("select_BusinessConfiguration_ById()error....", e);
//            throw new RuntimeException();
//        }

    }
}
