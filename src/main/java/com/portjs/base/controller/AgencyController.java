package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.AgencyService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by dengshuangzhen on 2019\3\28 0028
 */
@Controller
@CrossOrigin
@RequestMapping("/agency")
public class AgencyController  extends BaseController  {
    @Autowired
    private AgencyService agencyService;
    static final  String TAG = "AcceptanceController================>";

    @LogInfo(methodName = "代办查询",modelName = "代办模块")
    @RequestMapping("/select-agency")
    @ResponseBody
    public ResponseMessage selectAgency(@RequestBody String requestBody){
        logger.debug(TAG+requestBody);
        return agencyService.selectAgency(requestBody);
    }

    @LogInfo(methodName = "代办类型查询",modelName = "代办模块")
    @RequestMapping("/select-agency-type")
    @ResponseBody
    public ResponseMessage selectAgencyType(){
        logger.debug(TAG);
        return agencyService.selectAgencyType();
    }
}
