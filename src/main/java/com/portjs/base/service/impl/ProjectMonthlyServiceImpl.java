package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.BusinessConfigurationMapper;
import com.portjs.base.dao.BusinessDictionaryMapper;
import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.dao.ProjectMonthlyMapper;
import com.portjs.base.entity.*;
import com.portjs.base.service.ProjectMonthlyService;
import com.portjs.base.util.Code;
import com.portjs.base.util.IDUtils;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author: daiyueyuan
 * @date: 2019/4/24 10:21
 * @description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectMonthlyServiceImpl implements ProjectMonthlyService {
    @Autowired
    private ProjectMonthlyMapper projectMonthlyMapper;
    @Autowired
    private BusinessConfigurationMapper businessConfigurationMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private BusinessDictionaryMapper businessDictionaryMapper;

    @Override
    public ResponseMessage insertProjectMonthly(List<ProjectMonthly> projectMonthlyList) {
        for (ProjectMonthly projectMonthly : projectMonthlyList) {
            projectMonthly.setId(String.valueOf(IDUtils.genItemId()));
            projectMonthly.setCreateTime(new Date());
            int flag = projectMonthlyMapper.insert(projectMonthly);
            if (flag == 0) {
                return new ResponseMessage(Code.CODE_ERROR, "添加失败");
            }
        }
        return new ResponseMessage(Code.CODE_OK, "添加成功");
    }

    @Override
    public ResponseMessage selectBusinessConfiguration(String requestBody) {
        JSONObject requestMsg = JSONObject.parseObject(requestBody);
        String userId = requestMsg.getString("userId");
        String createTime = requestMsg.getString("createTime");
        List<Project> projects = projectMapper.selectByCreateMonth(userId, createTime);
        Map<String, Map<String, ProjectVo>> map = new LinkedHashMap<>();
        for (Project project : projects) {
            Map<String, ProjectVo> map1 = new LinkedHashMap<>();
            ProjectVo projectV1 = new ProjectVo();
            String content = "";
            List<BusinessConfiguration> businessConfigurations = businessConfigurationMapper.selectBySchedule(project.getId());
            for (BusinessConfiguration businessConfiguration : businessConfigurations) {
                ProjectVo projectVo = new ProjectVo();
                projectVo.setProjectName(project.getProjectName());
                projectVo.setProjectId(project.getId());

                if ("D".equals(businessConfiguration.getProjectSchedule()) ||
                        "E".equals(businessConfiguration.getProjectSchedule()) ||
                        "F".equals(businessConfiguration.getProjectSchedule())) {

                    content += businessConfiguration.getContent();
                    if ("D".equals(businessConfiguration.getProjectSchedule())) {
                        projectV1.setPredictStarttime(businessConfiguration.getPredictStarttime());
                    }
                    if ("F".equals(businessConfiguration.getProjectSchedule())) {

                        projectV1.setPredictEndtime(businessConfiguration.getPridectEndtime());
                    }
                    projectV1.setProjectName(project.getProjectName());
                    projectV1.setProjectId(project.getId());
                    projectV1.setProjectCode(project.getProjectCode());
                    projectV1.setProjectType(project.getProjectType());
                    projectV1.setLeval(project.getLeval());
                    projectV1.setProjectManager(project.getProjectManager());
                    projectV1.setStatus(project.getStatus());

                } else {
                    projectVo.setProjectSchedule(businessConfiguration.getProjectSchedule());
                    projectVo.setPredictStarttime(businessConfiguration.getPredictStarttime());
                    projectVo.setPredictEndtime(businessConfiguration.getPridectEndtime());
                    projectVo.setContent(businessConfiguration.getContent());
//                projectVo.setSchedule(schedule);
                    projectVo.setProjectCode(project.getProjectCode());
                    projectVo.setProjectType(project.getProjectType());
                    projectVo.setLeval(project.getLeval());
                    projectVo.setProjectManager(project.getProjectManager());
                    projectVo.setStatus(project.getStatus());
                    map1.put(businessConfiguration.getProjectSchedule(), projectVo);
                }
                projectV1.setProjectSchedule("项目建设");
                projectV1.setContent(content);
                map1.put("项目建设", projectV1);
                map.put(project.getProjectName(), map1);
            }
        }
        if (map.size() == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", map);
    }

    @Override
    public ResponseMessage selectProjectMonthly(String requestBody) {
        JSONObject requestMsg = JSONObject.parseObject(requestBody);
        String projectCode = requestMsg.getString("projectCode");
        String projectName = requestMsg.getString("projectName");
        String projectType = requestMsg.getString("projectType");
        String leval = requestMsg.getString("leval");
        String projectManager = requestMsg.getString("projectManager");
        String status = requestMsg.getString("status");
        String monthNum = requestMsg.getString("monthNum");
        List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                projectManager, status, monthNum);
        Map<String, List<ProjectMonthly>> map = new LinkedHashMap<>();
        for (Project project : projects) {
            List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
            map.put(project.getProjectName(), list);
        }
        if (map.size() == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", map);
    }
}