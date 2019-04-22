package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.ProjectService;
import com.portjs.base.util.Code;
import com.portjs.base.util.IDUtils;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Administrator on 2019/4/2.
 */

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    TUserMapper userMapper;
    @Autowired
    BusinessConfigurationMapper businessConfigurationMapper;
    @Autowired
    InvestmentPlanMapper investmentPlanMapper;
    @Autowired
    private BusinessDictionaryMapper businessDictionaryMapper;
    int i = 001;

    @Override
    public ResponseMessage queryProjectAllInfo(JSONObject requestJson) {
        String projectCode = requestJson.getString("projectCode");
        String projectName = requestJson.getString("projectName");
        String organization = requestJson.getString("organization");
        String projectType = requestJson.getString("projectType");
        String schedule = requestJson.getString("schedule");
        String pageNum = requestJson.getString("pageNum");
        String pageCount = requestJson.getString("pageCount");
        //新加字段
        String projectTime = requestJson.getString("projectTime");
        String invertor = requestJson.getString("investor");
        //如果type为nomal  为正常，如果type为exception 为异常
        String type = requestJson.getString("type");
        Page<Project> page = new Page<>();
        if (type.equals("nomal")) {
            int totalcount = projectMapper.queryProjectAllInfoCount(projectCode, projectName, projectTime, projectType, invertor, organization, schedule);
            page.init(totalcount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            List<Project> projectList = projectMapper.queryProjectAllInfo(projectCode, projectName, projectTime, projectType, invertor, organization, schedule, page.getRowNum(), page.getPageCount());
            for (Project project : projectList) {
                String creatorId = project.getCreator();
                String year = project.getCreateTime().toString();
                String creatorName2 = userMapper.queryUserNameByUserId(creatorId);
                project.setCreatorName(creatorName2);
                project.setYear(year.substring(year.length() - 4));
                List<BusinessConfiguration> businessConfigurations = businessConfigurationMapper.selectAll(project.getId());
                Map<String, String> map = new LinkedHashMap<>();
                List<BusinessDictionary> businessDictionaries = businessDictionaryMapper.selectAllProjectSchedule();
                for (BusinessDictionary businessDictionary : businessDictionaries) {
                    map.put(businessDictionary.getProjectSchedule(), null);
                }
                for (BusinessConfiguration businessConfiguration : businessConfigurations) {
                    if (!StringUtils.isEmpty(businessConfiguration.getProjectStatus())) {
                        String[] statuss = businessConfiguration.getProjectStatus().split(",");
                        for (String status : statuss) {
                            if (businessConfiguration.getProjectSchedule().contains(status.substring(0, 1))) {
                                map.put(businessConfiguration.getProjectSchedule(), status.substring(2, 3));
                            }
                        }
                    }
                }
                project.setStatusMap(map);
            }
            page.setList(projectList);
        } else if (type.equals("exception")) {
            int totalcount = projectMapper.queryProjectAllInfoExceptionCount(projectCode, projectName, projectTime, projectType, invertor, organization, schedule);
            page.init(totalcount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            List<Project> projectExceptionList = projectMapper.queryProjectAllExceptionInfo(projectCode, projectName, projectTime, projectType, invertor, organization, schedule, page.getRowNum(), page.getPageCount());
            for (Project project : projectExceptionList) {
                List<BusinessConfiguration> businessConfigurations = businessConfigurationMapper.selectAll(project.getId());
                Map<String, String> map = new LinkedHashMap<>();
                List<BusinessDictionary> businessDictionaries = businessDictionaryMapper.selectAllProjectSchedule();
                for (BusinessDictionary businessDictionary : businessDictionaries) {
                    map.put(businessDictionary.getProjectSchedule(), null);
                }
                for (BusinessConfiguration businessConfiguration : businessConfigurations) {
                    if (!StringUtils.isEmpty(businessConfiguration.getProjectStatus())) {
                        String[] statuss = businessConfiguration.getProjectStatus().split(",");
                        for (String status : statuss) {
                            if (businessConfiguration.getProjectSchedule().contains(status.substring(0, 1))) {
                                map.put(businessConfiguration.getProjectSchedule(), status.substring(2, 3));
                            }
                        }
                    }
                }
                project.setStatusMap(map);
            }
            page.setList(projectExceptionList);
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", page);
    }

    @Override
    public ResponseMessage queryProjectDetails(JSONObject requestJson) {
        String id = requestJson.getString("id");
        String projectType = requestJson.getString("projectType");
        List<String> typeList = businessConfigurationMapper.queryTypeList();
        Project project;
        if (typeList.contains(projectType)) {
            project = projectMapper.queryProjectDetails(id, projectType);
        } else {
            String Type = "其他";
            project = projectMapper.queryProjectById(id);
            BusinessConfiguration businessConfiguration = businessConfigurationMapper.querybusinessConfiguration(Type);
            project.setAllschedule(businessConfiguration.getSchedule());
            project.setNode(businessConfiguration.getNode());
        }
        String[] nodeArray = project.getNode().split(",");
        /* List<String>  nodeList=new ArrayList<>(nodeArray.length);*/
        String[] projectStatusArray = project.getProjectStatus().split(",");
        List<String> greenList = new LinkedList<>();
        List<String> yellowList = new LinkedList<>();
        List<String> redList = new LinkedList<>();
        for (String projectStatus : projectStatusArray) {
            if (projectStatus.contains("1")) {
                greenList.add(projectStatus.substring(0, 2));
            } else if (projectStatus.contains("2")) {
                yellowList.add(projectStatus.substring(0, 2));
            } else if (projectStatus.contains("3")) {
                redList.add(projectStatus.substring(0, 2));
            }
        }
        String[] allscheduleArray = project.getAllschedule().split(",");
        //1：定义一个集合 存放所有已经完成的阶段

        //存放所有已经完成的集合
        List<String> stageList = new ArrayList<>();
        for (String stage : allscheduleArray) {
            List<String> Alist = new ArrayList<>();
            List<String> A1list = new ArrayList<>();
            for (String node : nodeArray) {
                if (node.contains(stage)) {
                    Alist.add(node);
                    for (String status : projectStatusArray) {
                        if (status.contains(node) && status.contains("1")) {
                            A1list.add(status);
                        }
                    }
                }
            }
            if (Alist.size() == A1list.size()) {
                stageList.add(stage);
            }
        }
        project.setStageList(stageList);
        project.setNodeArray(nodeArray);
        project.setProjectStatusArray(projectStatusArray);
        project.setAllscheduleArray(allscheduleArray);
        project.setGreenArray(greenList);
        project.setRedArray(redList);
        project.setYellowArray(yellowList);
        return new ResponseMessage(Code.CODE_OK, "查询成功", project);
    }

    @Override
    public ResponseMessage queryYears() {
        List<String> yearsList = projectMapper.queryYears();
        return new ResponseMessage(Code.CODE_OK, "年份信息", yearsList);
    }

    @Override
    public ResponseMessage queryPlans() {
        List<String> planList = investmentPlanMapper.queryPlans();
        return new ResponseMessage(Code.CODE_OK, "投资计划下拉", planList);
    }

    @Override
    public ResponseMessage insertProject(JSONObject requestJson) {
        Project project = new Project();
        project.setId(String.valueOf(IDUtils.genItemId()));
        project.setInvestmentId(requestJson.getString("investmentId"));//投资计划id
        ProjectExample example = new ProjectExample();
        List<Project> projects = projectMapper.selectByExample(example);
        for (Project project1 : projects) {
            if (requestJson.getString("projectName").equals(project.getProjectName())) {
                return new ResponseMessage(Code.CODE_ERROR, "项目名已存在");
            }
        }
        project.setProjectName(requestJson.getString("projectName"));//项目名称
        project.setProjectType(requestJson.getString("projectType"));//项目类型
        project.setStatus("0");
        project.setLeval(requestJson.getString("leval"));//项目等级
        project.setOrganization(requestJson.getString("organization"));//业务单位
        project.setSchedule("A");
        project.setContractor(requestJson.getString("contractor"));//承建单位
        project.setProjectManager(requestJson.getString("projectManager"));//项目经理
        project.setManagerPhone(requestJson.getString("managerPhone"));//项目经理电话
        project.setCreateTime(new Date());
        project.setCreator(requestJson.getString("creator"));//创建人id
        project.setCreatorName(requestJson.getString("creatorName"));//创建人姓名
        int flag = projectMapper.insert(project);
        if (flag == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "添加失败");
        }
        return new ResponseMessage(Code.CODE_OK, "添加成功");
    }

    @Override
    public ResponseMessage queryProjectPlanByProject() {
        //筛选未选用的的投资计划方式
        List<InvestmentPlan> list = investmentPlanMapper.queryProjectPlanByProject();
        if (list.size() == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
        }
        return new ResponseMessage(Code.CODE_OK, "投资列表信息", list);
    }

    @Override
    public ResponseMessage queryNotInproject() {
        List<Project> list = projectMapper.queryNotInproject();
        if (list.size() == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
        }
        return new ResponseMessage(Code.CODE_OK, "项目名称下拉", list);
    }

}

