package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
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
            Map<String, ProjectVo> map1 = new LinkedHashMap<>();
            ProjectVo projectV1 = new ProjectVo();
            String content = "";
            ProjectMonthlyExample example = new ProjectMonthlyExample();
            ProjectMonthlyExample.Criteria criteria = example.createCriteria();
            criteria.andCreatorEqualTo(userId);
            criteria.andMonthNumEqualTo(createTime);
            criteria.andProjectIdEqualTo(project.getId());
            List<ProjectMonthly> projectMonthlies = projectMonthlyMapper.selectByExample(example);
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
                        if ("D".equals(businessConfiguration.getProjectSchedule())) {
                            projectV1.setPredictStarttime(businessConfiguration.getPredictStarttime());
                        }
                        BusinessConfiguration Dconfiguration = businessConfigurationMapper.queryBySchedule(project.getId(),
                                "D");
                        BusinessConfiguration Econfiguration = businessConfigurationMapper.queryBySchedule(project.getId(),
                                "E");
                        BusinessConfiguration Fconfiguration = businessConfigurationMapper.queryBySchedule(project.getId(),
                                "F");

                        if (Econfiguration == null && Fconfiguration == null) {
                            projectV1.setPridectEndtime(Dconfiguration.getPridectEndtime());
                        } else if (Econfiguration != null && Fconfiguration == null) {
                            projectV1.setPridectEndtime(Econfiguration.getPridectEndtime());
                        } else if (Fconfiguration != null) {
                            projectV1.setPridectEndtime(Fconfiguration.getPridectEndtime());
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
        TDepartment department = departmentMapper.selectByPrimaryKey(user.getDepartmentId());
        if (department == null) {
            return new ResponseMessage(Code.CODE_ERROR, "部门不存在");
        }

        Map<String, List<ProjectMonthly>> map = new LinkedHashMap<>();
        //如果当前登录人是部门负责人
        if (department.getLeaderId() != null) {
            if (department.getLeaderId().equals(userId)) {
                TUserExample example = new TUserExample();
                TUserExample.Criteria criteria = example.createCriteria();
                criteria.andDepartmentidEqualTo(department.getId());
                List<TUser> users = userMapper.selectByExample(example);
                for (TUser tuser : users) {
                    if (department.getReserved1() != null) {
                        String departmentFDL = department.getReserved1();
                        if (!departmentFDL.equals(user.getId())) {
                            List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                                    projectManager, status, monthNum, null, tuser.getId());
                            for (Project project : projects) {
                                List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                                if (map.get(project.getProjectName()) == null) {
                                    map.put(project.getProjectName(), list);
                                }
                            }
                        }
                    } else {
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
            } else {
                List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                        projectManager, status, monthNum, null, userId);
                for (Project project : projects) {
                    List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                    if (map.get(project.getProjectName()) == null) {
                        map.put(project.getProjectName(), list);
                    }
                }
            }
        } else if (department.getReserved1() != null) {
            if (department.getReserved1().equals(userId)) {
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
            } else {
                List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                        projectManager, status, monthNum, null, userId);
                for (Project project : projects) {
                    List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                    if (map.get(project.getProjectName()) == null) {
                        map.put(project.getProjectName(), list);
                    }
                }
            }
        } else {
            List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                    projectManager, status, monthNum, null, userId);
            for (Project project : projects) {
                List<ProjectMonthly> list = projectMonthlyMapper.queryProjectMonthByProjectId(project.getId());
                if (map.get(project.getProjectName()) == null) {
                    map.put(project.getProjectName(), list);
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
        TDepartment department = departmentMapper.selectByPrimaryKey(user.getDepartmentId());
        if (department == null) {
            return new ResponseMessage(Code.CODE_ERROR, "部门不存在");
        }
        Map<String, Map<String, ProjectMonthly>> map = new LinkedHashMap<>();
        //如果当前登录人是部门负责人
        if (department.getLeaderId() != null) {
            if (department.getLeaderId().equals(userId)) {
                TUserExample example = new TUserExample();
                TUserExample.Criteria criteria = example.createCriteria();
                criteria.andDepartmentidEqualTo(department.getId());
                List<TUser> users = userMapper.selectByExample(example);
                for (TUser tuser : users) {
                    //部门负责人无法查看分管领导项目
                    if (department.getReserved1() != null) {
                        String departmentFLD = department.getReserved1();
                        if (!departmentFLD.equals(user.getId())) {
                            List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                                    projectManager, status, monthNum, null, tuser.getId());
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
                    } else {
                        List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                                projectManager, status, monthNum, null, tuser.getId());
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
            } else {
                //不是负责人
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
            }
        } else if (department.getReserved1() != null) {
            //如果当前登录人为分管领导
            if (department.getReserved1().equals(userId)) {
                TUserExample example = new TUserExample();
                TUserExample.Criteria criteria = example.createCriteria();
                criteria.andDepartmentidEqualTo(department.getId());
                List<TUser> users = userMapper.selectByExample(example);
                for (TUser tuser : users) {
                    List<Project> projects = projectMapper.queryProjectByMonth(projectCode, projectName, projectType, leval,
                            projectManager, status, monthNum, null, tuser.getId());
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
            } else {
                //不是负责人或
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
            }

        } else {
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
        }
        if (map.size() == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", map);
    }
}
