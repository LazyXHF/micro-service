package com.portjs.base.service;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.entity.Acceptance;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingyang
 **/

public interface ProjectApplicationService {

    ResponseMessage updateProject(JSONObject requestJson);

    ResponseMessage queryProject(JSONObject requestJson);

    ResponseMessage queryProjectBase(JSONObject requestJson) throws Exception;

    ResponseMessage queryProjectPersons(JSONObject requestJson);

    ResponseMessage queryProjectFiles(JSONObject requestJson);

    ResponseMessage queryProjectRecords(JSONObject requestJson);

    ResponseMessage deleteProject(JSONObject requestJson);

    ResponseMessage queryProjectPlan();

    ResponseMessage queryProjectPlanInfo(JSONObject requestJson);

    ResponseMessage toApprove(JSONObject requestJson);

    ResponseMessage abolishProject(JSONObject requestJson);
}
