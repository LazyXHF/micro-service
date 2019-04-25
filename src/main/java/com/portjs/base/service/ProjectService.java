package com.portjs.base.service;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.util.ResponseMessage;

/**
 * Created by Administrator on 2019/4/2.
 */

public interface ProjectService {
    ResponseMessage queryProjectAllInfo(JSONObject requestJson);

    ResponseMessage queryProjectDetails(JSONObject requestJson);

    ResponseMessage queryYears();

    ResponseMessage queryPlans();

    ResponseMessage insertProject(JSONObject requestJson);

    ResponseMessage queryProjectPlanByProject();

    ResponseMessage queryNotInproject();


    ResponseMessage selectByNameCn(JSONObject requestJson);
}
