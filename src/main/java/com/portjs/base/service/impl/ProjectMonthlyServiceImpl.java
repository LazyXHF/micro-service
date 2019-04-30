package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.ProjectMonthlyService;
import com.portjs.base.util.Code;
import com.portjs.base.util.DateUtils;
import com.portjs.base.util.IDUtils;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.unit.DataUnit;

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
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TDepartmentMapper departmentMapper;

    @Override
    public ResponseMessage insertProjectMonthly(List<ProjectMonthly> projectMonthlyList) {
        for (ProjectMonthly projectMonthly : projectMonthlyList) {
            if (projectMonthly.getId() != null && !projectMonthly.getId().equals("")) {
                int flag = projectMonthlyMapper.updateByPrimaryKeySelective(projectMonthly);
                if (flag == 0) {
                    return new ResponseMessage(Code.CODE_ERROR, "添加失败");
                }
            } else {
                projectMonthly.setId(String.valueOf(IDUtils.genItemId()));
                projectMonthly.setCreateTime(new Date());
                int flag = projectMonthlyMapper.insert(projectMonthly);
                if (flag == 0) {
                    return new ResponseMessage(Code.CODE_ERROR, "添加失败");
                }
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
            Long Dms1 = Long.valueOf(0);
            Long Dms2 = Long.valueOf(0);
            Long Ems1 = Long.valueOf(0);
            Long Ems2 = Long.valueOf(0);
            Long Fms1 = Long.valueOf(0);
            Long Fms2 = Long.valueOf(0);
            Map<String, ProjectVo> map1 = new LinkedHashMap<>();
            ProjectVo projectV1 = new ProjectVo();
            String content = "";
            List<ProjectMonthly> projectMonthlies = projectMonthlyMapper.selectByprojectManagerId(userId,createTime,
                    project.getId());

            if (projectMonthlies.size() != 0) {
                for (ProjectMonthly projectMonthly : projectMonthlies) {
                    ProjectVo projectVo = new ProjectVo();
                    projectVo.setProjectName(projectMonthly.getProjectName());
                    projectVo.setProjectId(projectMonthly.getProjectId());
                    projectVo.setProjectSchedule(projectMonthly.getProjectSchedule());
                    projectVo.setContent(projectMonthly.getContent());
                    projectVo.setPredictStarttime(projectMonthly.getPredictStarttime());
                    projectVo.setPridectEndtime(projectMonthly.getPridectEndtime());
                    projectVo.setProjectCode(projectMonthly.getProjectCode());
                    projectVo.setProjectType(projectMonthly.getProjectType());
                    projectVo.setLeval(projectMonthly.getLeval());
                    projectVo.setProjectManager(projectMonthly.getProjectManager());
                    projectVo.setStatus(projectMonthly.getStatus());
                    projectVo.setCurrentProgress(projectMonthly.getCurrentProgress());
                    projectVo.setPerformance(projectMonthly.getPerformance());
                    projectVo.setSchedule(projectMonthly.getSchedule());
                    projectVo.setRemark(projectMonthly.getRemark());
                    projectVo.setSituation(projectMonthly.getSituation());
                    projectVo.setProMonId(projectMonthly.getId());
                    projectVo.setProjectManagerId(projectMonthly.getProjectManagerId());
                    map1.put(projectMonthly.getProjectSchedule(), projectVo);
                }
                map.put(project.getProjectName(), map1);
            } else {
                List<BusinessConfiguration> businessConfigurations = businessConfigurationMapper.selectBySchedule(project.getId());
                for (BusinessConfiguration businessConfiguration : businessConfigurations) {
                    ProjectVo projectVo = new ProjectVo();


                    if ("D".equals(businessConfiguration.getProjectSchedule()) ||
                            "E".equals(businessConfiguration.getProjectSchedule()) ||
                            "F".equals(businessConfiguration.getProjectSchedule())) {

                        content += businessConfiguration.getContent();

                        BusinessConfiguration Dconfiguration = businessConfigurationMapper.queryBySchedule(project.getId(),
                                businessConfiguration.getProjectSchedule());
                        if ("D".equals(businessConfiguration.getProjectSchedule())){
                            Dms1=Dconfiguration.getPredictStarttime().getTime();
                            Dms2=Dconfiguration.getPridectEndtime().getTime();
                        }else if ("E".equals(businessConfiguration.getProjectSchedule())){
                            Ems1=Dconfiguration.getPredictStarttime().getTime();
                            Ems2=Dconfiguration.getPridectEndtime().getTime();
                        }else if ("F".equals(businessConfiguration.getProjectSchedule())){
                            Fms1=Dconfiguration.getPredictStarttime().getTime();
                            Fms2=Dconfiguration.getPridectEndtime().getTime();
                            long minTime = getMinTime(Dms1,Ems1,Fms1);
                            long maxTime = getMaxTime(Dms2,Ems2,Fms2);
                            projectV1.setPredictStarttime(new Date(minTime));
                            projectV1.setPridectEndtime(new Date(maxTime));
                        }


                        projectV1.setProjectName(project.getProjectName());
                        projectV1.setProjectId(project.getId());
                        projectV1.setProjectCode(project.getProjectCode());
                        projectV1.setProjectType(project.getProjectType());
                        projectV1.setLeval(project.getLeval());
                        projectV1.setProjectManager(project.getProjectManager());
                        projectV1.setStatus(project.getStatus());
                        projectV1.setProjectSchedule("项目建设");
                        projectV1.setContent(content);
                        projectV1.setProjectManagerId(project.getBackUp1());
                        map1.put("项目建设", projectV1);
                    } else {
                        projectVo.setProjectName(project.getProjectName());
                        projectVo.setProjectId(project.getId());
                        projectVo.setProjectSchedule(businessConfiguration.getProjectSchedule());
                        projectVo.setPredictStarttime(businessConfiguration.getPredictStarttime());
                        projectVo.setPridectEndtime(businessConfiguration.getPridectEndtime());
                        projectVo.setContent(businessConfiguration.getContent());
//                projectVo.setSchedule(schedule);
                        projectVo.setProjectCode(project.getProjectCode());
                        projectVo.setProjectType(project.getProjectType());
                        projectVo.setLeval(project.getLeval());
                        projectVo.setProjectManager(project.getProjectManager());
                        projectVo.setStatus(project.getStatus());
                        projectVo.setProjectManagerId(project.getBackUp1());
                        map1.put(businessConfiguration.getProjectSchedule(), projectVo);
                    }
                }
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
        String userId = requestMsg.getString("userId");
        if (monthNum == null) {
            return new ResponseMessage(Code.CODE_ERROR, "请选择月份");
        }
        TUser user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return new ResponseMessage(Code.CODE_ERROR, "用户不存在");
        }
        Map<String, List<ProjectMonthly>> map = new LinkedHashMap<>();

        TDepartmentExample departmentExample = new TDepartmentExample();
        TDepartmentExample.Criteria departmentExampleCriteria = departmentExample.createCriteria();
        departmentExampleCriteria.andReserved1EqualTo(userId);
        List<TDepartment> departments = departmentMapper.selectByExample(departmentExample);
        //判断是否为分管领导
        if (CollectionUtils.isEmpty(departments)) {
            //不是分管领导判断是否为部门负责人
            TDepartmentExample departmentExample1 = new TDepartmentExample();
            TDepartmentExample.Criteria criteria = departmentExample1.createCriteria();
            criteria.andLeaderIdEqualTo(userId);
            List<TDepartment> tDepartments = departmentMapper.selectByExample(departmentExample1);
            if (CollectionUtils.isEmpty(tDepartments)) {
                //不是分管领导,不是部门负责人查看自己项目
                List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                        projectManager, status, monthNum, null, userId);
                for (Project project : projects) {
                    List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                    if (map.get(project.getProjectName()) == null) {
                        map.put(project.getProjectName(), list);
                    }
                }
            } else {
                //不是分管领导,是部门负责人查看该部门除分管领导所有项目
                for (TDepartment department : tDepartments) {
                    TUserExample example = new TUserExample();
                    TUserExample.Criteria exampleCriteria = example.createCriteria();
                    exampleCriteria.andDepartmentidEqualTo(department.getId());
                    List<TUser> users = userMapper.selectByExample(example);
                    for (TUser tuser : users) {
                        List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                                projectManager, status, monthNum, null, tuser.getId());
                        for (Project project : projects) {
                            List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                            if (map.get(project.getProjectName()) == null) {
                                map.put(project.getProjectName(), list);
                            }
                        }
                    }
                }
            }
        } else {
            //是分管领导查看所在部门下项目
            for (TDepartment department : departments) {
                TUserExample example = new TUserExample();
                TUserExample.Criteria criteria = example.createCriteria();
                criteria.andDepartmentidEqualTo(department.getId());
                List<TUser> users = userMapper.selectByExample(example);
                for (TUser tuser : users) {
                    List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                            projectManager, status, monthNum, null, tuser.getId());
                    for (Project project : projects) {
                        List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                        if (map.get(project.getProjectName()) == null) {
                            map.put(project.getProjectName(), list);
                        }
                    }
                }
            }
        }
        if (map.size() == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", map);
    }

    @Override
    public ResponseMessage selectProjectMonthlyBymohu(String requestBody) {
        JSONObject requestMsg = JSONObject.parseObject(requestBody);
        String projectCode = requestMsg.getString("projectCode");
        String projectName = requestMsg.getString("projectName");
        String projectType = requestMsg.getString("projectType");
        String leval = requestMsg.getString("leval");
        String projectManager = requestMsg.getString("projectManager");
        String status = requestMsg.getString("status");
        String monthNum = requestMsg.getString("monthNum");
        String userId = requestMsg.getString("userId");
        if (monthNum == null) {
            return new ResponseMessage(Code.CODE_ERROR, "请选择月份");
        }
        TUser user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return new ResponseMessage(Code.CODE_ERROR, "用户不存在");
        }
        Map<String, Map<String, ProjectMonthly>> map = new LinkedHashMap<>();
        TDepartmentExample departmentExample = new TDepartmentExample();
        TDepartmentExample.Criteria departmentExampleCriteria = departmentExample.createCriteria();
        departmentExampleCriteria.andReserved1EqualTo(userId);
        List<TDepartment> departments = departmentMapper.selectByExample(departmentExample);
        //判断是否为分管领导
        if (CollectionUtils.isEmpty(departments)) {
            //不是分管领导判断是否为部门负责人
            TDepartmentExample departmentExample1 = new TDepartmentExample();
            TDepartmentExample.Criteria criteria = departmentExample1.createCriteria();
            criteria.andLeaderIdEqualTo(userId);
            List<TDepartment> tDepartments = departmentMapper.selectByExample(departmentExample1);
            if (CollectionUtils.isEmpty(tDepartments)) {
                //不是分管领导,不是部门负责人查看自己项目
                List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                        projectManager, status, monthNum, null, userId);
                for (Project project : projects) {
                    List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                    Map<String, ProjectMonthly> map1 = new LinkedHashMap<>();
                    for (ProjectMonthly projectMonthly : list) {
                        map1.put(projectMonthly.getProjectSchedule(), projectMonthly);
                    }
                    if (map.get(project.getProjectName()) == null) {
                        map.put(project.getProjectName(), map1);
                    }
                }
            } else {
                //不是分管领导,是部门负责人查看该部门除分管领导所有项目
                for (TDepartment department : tDepartments) {
                    TUserExample example = new TUserExample();
                    TUserExample.Criteria exampleCriteria = example.createCriteria();
                    exampleCriteria.andDepartmentidEqualTo(department.getId());
                    List<TUser> users = userMapper.selectByExample(example);
                    for (TUser tUser : users) {
                        List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                                projectManager, status, monthNum, null, tUser.getId());
                        for (Project project : projects) {
                            List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                            Map<String, ProjectMonthly> map1 = new LinkedHashMap<>();
                            for (ProjectMonthly projectMonthly : list) {
                                map1.put(projectMonthly.getProjectSchedule(), projectMonthly);
                            }
                            if (map.get(project.getProjectName()) == null) {
                                map.put(project.getProjectName(), map1);
                            }
                        }
                    }
                }
            }
        } else {
            //是分管领导查看所在部门下项目
            for (TDepartment department : departments) {
                TUserExample example = new TUserExample();
                TUserExample.Criteria exampleCriteria = example.createCriteria();
                exampleCriteria.andDepartmentidEqualTo(department.getId());
                List<TUser> users = userMapper.selectByExample(example);
                for (TUser tUser : users) {
                    List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                            projectManager, status, monthNum, null, tUser.getId());
                    for (Project project : projects) {
                        List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                        Map<String, ProjectMonthly> map1 = new LinkedHashMap<>();
                        for (ProjectMonthly projectMonthly : list) {
                            map1.put(projectMonthly.getProjectSchedule(), projectMonthly);
                        }
                        if (map.get(project.getProjectName()) == null) {
                            map.put(project.getProjectName(), map1);
                        }
                    }
                }
            }
        }
        if (map.size() == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", map);
    }



    public long getMaxTime(long t1,long t2,long t3){
        long max = t1;
        if (t1>=t2){
            max = t1;
        }else {
            max = t2;
        }
        if (max <=t3){
            max = t3;
        }
        return max;
    }

    public long getMinTime(long t1,long t2,long t3){
        long min = t1;
        if (t1<=t2){
            min = t1;
        }else {
            min = t2;
        }
        if (min >=t3){
            min = t3;
        }
        return min;
    }
}
