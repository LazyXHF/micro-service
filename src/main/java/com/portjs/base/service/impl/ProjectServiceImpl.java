package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.service.ProjectService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/4/2.
 */
/*
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Override
    public ResponseMessage queryProjectAllInfo(JSONObject requestJson) {
        String projectCode=requestJson.getString("projectCode");
        String projectName=requestJson.getString("projectName");
        String organization=requestJson.getString("organization");
        String projectType=requestJson.getString("projectType");
        String project=requestJson.getString("projectMapper");
        String creator=requestJson.getString("creator");
        projectMapper.queryProjectAllInfo(projectCode,projectName,organization,projectType,)
        return null;
    }
}
*/
