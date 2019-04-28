package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.WeeklyAndMonthlyReportManagementService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.UUID.UuidPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by dengshuangzhen on 2019\4\23 0023
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WeeklyAndMonthlyReportManagementImpl  implements WeeklyAndMonthlyReportManagementService {
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TRoleMapper roleMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ProjectWeeklyMapper weeklyMapper;
    @Autowired
    private TUserDepartmentMapper tdMapper;
    @Autowired
    private TDepartmentMapper departmentMapper;
    /**
     * 周报详情查询
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectWeeklyDetails(String requestBody){
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String UserId = jsonObject.getString("UserId");//当前登录人id
        String weekNum = jsonObject.getString("weekNum");//周数
        TUser user = userMapper.selectByPrimaryKey(UserId);
        if(user==null){
            return new ResponseMessage(Code.CODE_ERROR,"用户不存在");
        }
        List<TRole> roles = roleMapper.selectRoleByUserId(user.getId());
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周的第一天
        cal.setTime(date);
        int num = cal.get(Calendar.WEEK_OF_YEAR);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        //得到当前年和周数
        String flag = year+"-"+num;
        for (TRole role : roles) {
            if(role.getRoleName().equals("项目经理")){
                //判断传入时间是不是当前周
                /*if(weekNum.equals(flag)){*/
                    //则取project中数据
                    ProjectExample projectExample = new ProjectExample();
                    projectExample.setOrderByClause("create_time");
                    ProjectExample.Criteria projectCriteria = projectExample.createCriteria();
                    projectCriteria.andBackUp1EqualTo(UserId);
                    projectCriteria.andStatusNotEqualTo("1");
                    //查询当前项目经理对应的所有不是已完成的项目
                    List<Project> projectList = projectMapper.selectByExample(projectExample);
                    LinkedList list = new LinkedList();
                    if(!CollectionUtils.isEmpty(projectList)){
                        for(int i=0;i<projectList.size();i++){
                            Project project = projectList.get(i);
                            //一周完成情况
                            ProjectWeeklyExample weeklyExample = new ProjectWeeklyExample();
                            ProjectWeeklyExample.Criteria weeklyCriteria = weeklyExample.createCriteria();
                            weeklyCriteria.andProjectIdEqualTo(project.getId());
                            weeklyCriteria.andWeekNumEqualTo(weekNum);
                            List<ProjectWeekly> weeklies = weeklyMapper.selectByExample(weeklyExample);
                            if(!CollectionUtils.isEmpty(weeklies)){
                                list.add(weeklies.get(0));
                            }else {
                                ProjectWeekly projectWeekly = new ProjectWeekly();
                                projectWeekly.setProjectId(project.getId());
                                projectWeekly.setProjectType(project.getProjectType());
                                projectWeekly.setProjectCode(project.getProjectCode());
                                projectWeekly.setProjectName(project.getProjectName());
                                projectWeekly.setStatus(project.getStatus());
                                projectWeekly.setProjectManager(project.getProjectManager());
                                projectWeekly.setManagerPhone(project.getManagerPhone());
                                projectWeekly.setModifier(project.getBackUp1());
                                projectWeekly.setLeval(project.getLeval());


                                list.add(projectWeekly);
                            }
                        }
                        return new ResponseMessage(Code.CODE_OK,"查询成功",list);
                    }
                    return new ResponseMessage(Code.CODE_ERROR,"暂无数据");
                /*}else {
                    //如果不是当前周则取weekly中数据
                    ProjectWeeklyExample weeklyExample = new ProjectWeeklyExample();
                    ProjectWeeklyExample.Criteria criteria = weeklyExample.createCriteria();
                    criteria.andWeekNumEqualTo(weekNum);
                    List<ProjectWeekly> projectWeeklies = weeklyMapper.selectByExample(weeklyExample);
                    return new ResponseMessage(Code.CODE_OK,"查询成功",projectWeeklies);
                }*/
            }
        }
        return new ResponseMessage(Code.CODE_ERROR,"当前登录人无权限");




    }

    /**
     * 提交保存周报详情
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage submissionWeeklyDetails(String requestBody)throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        JSONArray weeklyJSON = jsonObject.getJSONArray("WeeklyJSON");
        if(!CollectionUtils.isEmpty(weeklyJSON)){
            for (int i =0;i<weeklyJSON.size();i++) {
                JSONObject object = weeklyJSON.getJSONObject(i);
                ProjectWeekly projectWeekly = JSONObject.toJavaObject(object, ProjectWeekly.class);
                //判断是否是更新还是新增
                if(StringUtils.isEmpty(projectWeekly.getId())){
                    projectWeekly.setId(UuidPlus.getUUIDPlus());
                    projectWeekly.setCreateTime(new Date());

                    int p = weeklyMapper.insertSelective(projectWeekly);
                    if(p!=1){
                        throw new Exception("保存失败");
                    }
                }else {
                    projectWeekly.setUpdateTime(new Date());
                    int k = weeklyMapper.updateByPrimaryKeySelective(projectWeekly);
                    if(k!=1){
                        throw new Exception("保存失败");
                    }

                }
            }
            return new ResponseMessage(Code.CODE_OK,"保存成功");
        }
        return new ResponseMessage(Code.CODE_ERROR,"请输入数据");
    }

    /**
     * 周报查询
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectWeekly(String requestBody) throws Exception{
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String UserId = jsonObject.getString("UserId");//当前登录人id
        JSONObject weekly = jsonObject.getJSONObject("Weekly");
        ProjectWeekly projectWeekly = JSONObject.toJavaObject(weekly,ProjectWeekly.class);
        TUser user = userMapper.selectByPrimaryKey(UserId);
        if(user==null){
            return new ResponseMessage(Code.CODE_ERROR,"用户不存在");
        }
        //根据id查询对应职务和部门id
        TUserDepartmentExample example = new TUserDepartmentExample();
        TUserDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andUIdEqualTo(user.getId());
        List<TUserDepartment> tUserDepartments = tdMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(tUserDepartments)){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败");
        }
        LinkedList list = new LinkedList();
        for (TUserDepartment userDepartment : tUserDepartments) {
            TDepartment tDepartment = departmentMapper.selectByPrimaryKey(userDepartment.getdId());
            if(CollectionUtils.isEmpty(tUserDepartments)){
                throw  new Exception("查询失败");
            }

            if(user.getId().equals(tDepartment.getReserved1()) || user.getId().equals(tDepartment.getLeaderId())){
                //当前登录人是分管领导或者部门负责人时查询当前部门下所有人
                List<TUser> users = userMapper.selectByDid(userDepartment.getdId());
                if(!CollectionUtils.isEmpty(users)){
                    for (TUser tUser :users ) {
                        List<ProjectWeekly> weeklies = selectProjectWeekly(tUser, projectWeekly);
                        if(!CollectionUtils.isEmpty(weeklies)){
                            list.addAll(weeklies);
                        }
                    }
                }
            }else {
                //当前登录人不是分管领导也不是部门负责人就查询自己
                List<ProjectWeekly> weeklies = selectProjectWeekly(user, projectWeekly);
                if(!CollectionUtils.isEmpty(weeklies)){
                    list.addAll(weeklies);
                }
            }
        }

        return new ResponseMessage(Code.CODE_OK,"查询成功",list);









        /*if(user.getDuty().equals("项目组长")){
            //根据项目组长id查询对应部门的所有项目经理和项目组长
            List<TUser> users = userMapper.selectUserByUserId(user.getId(),"分管领导");
            LinkedList list = new LinkedList();
            for (TUser tUser :users ) {
                *//*ProjectWeeklyExample weeklyExample = new ProjectWeeklyExample();
                weeklyExample.setOrderByClause("create_time");
                ProjectWeeklyExample.Criteria weeklyCriteria = weeklyExample.createCriteria();
                //项目经理id
                weeklyCriteria.andModifierEqualTo(tUser.getId());
                //项目经理名称
                if(!StringUtils.isEmpty(projectWeekly.getProjectManager())){
                    weeklyCriteria.andProjectManagerLike("%"+projectWeekly.getProjectManager()+"%");
                }
                //项目编码
                if(!StringUtils.isEmpty(projectWeekly.getProjectCode())){
                    weeklyCriteria.andProjectCodeLike("%"+projectWeekly.getProjectCode()+"%");

                }
                //项目名称
                if(!StringUtils.isEmpty(projectWeekly.getProjectName())){
                    weeklyCriteria.andProjectNameLike("%"+projectWeekly.getProjectName()+"%");

                }
                //项目类型
                if(!StringUtils.isEmpty(projectWeekly.getProjectType())){
                    weeklyCriteria.andProjectTypeEqualTo(projectWeekly.getProjectType());

                }
                //项目等级
                if(!StringUtils.isEmpty(projectWeekly.getLeval())){
                    weeklyCriteria.andLevalEqualTo(projectWeekly.getLeval());

                }
                //项目状态
                if(!StringUtils.isEmpty(projectWeekly.getStatus())){
                    weeklyCriteria.andStatusEqualTo(projectWeekly.getStatus());

                }
                //周数
                weeklyCriteria.andWeekNumEqualTo(projectWeekly.getWeekNum());
                List<ProjectWeekly> weeklies = weeklyMapper.selectByExample(weeklyExample);*//*
                List<ProjectWeekly> weeklies = selectProjectWeekly(tUser, projectWeekly);
                if(!CollectionUtils.isEmpty(weeklies)){
                    list.addAll(weeklies);
                }
            }
            if(CollectionUtils.isEmpty(list)){
                return new ResponseMessage(Code.CODE_ERROR,"暂无数据");
            }
            return new ResponseMessage(Code.CODE_OK,"查询成功",list);


        }else if(user.getDuty().equals("分管领导")){
            //查询所有对应的项目经理和项目组长的
            //根据分管领导id查询分管领导对应所有部门的所有项目经理和项目组长
            List<TUser> users = userMapper.selectUserByUserId(user.getId(),null);
            LinkedList list = new LinkedList();
            for (TUser tUser :users ) {
                *//*ProjectWeeklyExample weeklyExample = new ProjectWeeklyExample();
                weeklyExample.setOrderByClause("create_time");
                ProjectWeeklyExample.Criteria weeklyCriteria = weeklyExample.createCriteria();
                //项目经理id
                weeklyCriteria.andModifierEqualTo(tUser.getId());
                //项目经理名称
                if(!StringUtils.isEmpty(projectWeekly.getProjectManager())){
                    weeklyCriteria.andProjectManagerLike("%"+projectWeekly.getProjectManager()+"%");
                }
                //项目编码
                if(!StringUtils.isEmpty(projectWeekly.getProjectCode())){
                    weeklyCriteria.andProjectCodeEqualTo("%"+projectWeekly.getProjectCode()+"%");

                }
                //项目名称
                if(!StringUtils.isEmpty(projectWeekly.getProjectName())){
                    weeklyCriteria.andProjectNameLike("%"+projectWeekly.getProjectName()+"%");

                }
                //项目类型
                if(!StringUtils.isEmpty(projectWeekly.getProjectType())){
                    weeklyCriteria.andProjectTypeEqualTo(projectWeekly.getProjectType());

                }
                //项目等级
                if(!StringUtils.isEmpty(projectWeekly.getLeval())){
                    weeklyCriteria.andLevalEqualTo(projectWeekly.getLeval());

                }
                //项目状态
                if(!StringUtils.isEmpty(projectWeekly.getStatus())){
                    weeklyCriteria.andStatusEqualTo(projectWeekly.getStatus());

                }*//*
                //周数
                *//*weeklyCriteria.andWeekNumEqualTo(projectWeekly.getWeekNum());
                List<ProjectWeekly> weeklies = weeklyMapper.selectByExample(weeklyExample);*//*
                List<ProjectWeekly> weeklies = selectProjectWeekly(tUser, projectWeekly);
                if(!CollectionUtils.isEmpty(weeklies)){
                    list.addAll(weeklies);
                }
            }
            if(CollectionUtils.isEmpty(list)){
                return new ResponseMessage(Code.CODE_ERROR,"暂无数据");
            }
            return new ResponseMessage(Code.CODE_OK,"查询成功",list);
        }else  if(user.getDuty().equals("组员")){
            //查询所有对应的项目经理和项目组长的
            //根据分管领导id查询分管领导对应所有部门的所有项目经理和项目组长

            TUser tUser = userMapper.selectByPrimaryKey(user.getId());

            *//*ProjectWeeklyExample weeklyExample = new ProjectWeeklyExample();
            weeklyExample.setOrderByClause("create_time");
            ProjectWeeklyExample.Criteria weeklyCriteria = weeklyExample.createCriteria();
            //项目经理id
            weeklyCriteria.andModifierEqualTo(tUser.getId());
            //项目经理名称
            if(!StringUtils.isEmpty(projectWeekly.getProjectManager())){
                weeklyCriteria.andProjectManagerLike("%"+projectWeekly.getProjectManager()+"%");
            }
            //项目编码
            if(!StringUtils.isEmpty(projectWeekly.getProjectCode())){
                weeklyCriteria.andProjectCodeEqualTo("%"+projectWeekly.getProjectCode()+"%");

            }
            //项目名称
            if(!StringUtils.isEmpty(projectWeekly.getProjectName())){
                weeklyCriteria.andProjectNameLike("%"+projectWeekly.getProjectName()+"%");

            }
            //项目类型
            if(!StringUtils.isEmpty(projectWeekly.getProjectType())){
                weeklyCriteria.andProjectTypeEqualTo(projectWeekly.getProjectType());

            }
            //项目等级
            if(!StringUtils.isEmpty(projectWeekly.getLeval())){
                weeklyCriteria.andLevalEqualTo(projectWeekly.getLeval());

            }
            //项目状态
            if(!StringUtils.isEmpty(projectWeekly.getStatus())){
                weeklyCriteria.andStatusEqualTo(projectWeekly.getStatus());

            }
            //周数
            weeklyCriteria.andWeekNumEqualTo(projectWeekly.getWeekNum());
            List<ProjectWeekly> weeklies = weeklyMapper.selectByExample(weeklyExample);*//*
            List<ProjectWeekly> weeklies = selectProjectWeekly(tUser, projectWeekly);
            if(!CollectionUtils.isEmpty(weeklies)){
                return new ResponseMessage(Code.CODE_OK,"查询成功",weeklies);
            }
            return new ResponseMessage(Code.CODE_ERROR,"暂无数据");
        }*/


    }

    //统一周报信息查询
    private  List<ProjectWeekly> selectProjectWeekly(TUser tUser,ProjectWeekly projectWeekly){
        ProjectWeeklyExample weeklyExample = new ProjectWeeklyExample();
        weeklyExample.setOrderByClause("create_time");
        ProjectWeeklyExample.Criteria weeklyCriteria = weeklyExample.createCriteria();
        //项目经理id
        weeklyCriteria.andModifierEqualTo(tUser.getId());
        //项目经理名称
        if(!StringUtils.isEmpty(projectWeekly.getProjectManager())){
            weeklyCriteria.andProjectManagerLike("%"+projectWeekly.getProjectManager()+"%");
        }
        //项目编码
        if(!StringUtils.isEmpty(projectWeekly.getProjectCode())){
            weeklyCriteria.andProjectCodeEqualTo("%"+projectWeekly.getProjectCode()+"%");

        }
        //项目名称
        if(!StringUtils.isEmpty(projectWeekly.getProjectName())){
            weeklyCriteria.andProjectNameLike("%"+projectWeekly.getProjectName()+"%");

        }
        //项目类型
        if(!StringUtils.isEmpty(projectWeekly.getProjectType())){
            weeklyCriteria.andProjectTypeEqualTo(projectWeekly.getProjectType());

        }
        //项目等级
        if(!StringUtils.isEmpty(projectWeekly.getLeval())){
            weeklyCriteria.andLevalEqualTo(projectWeekly.getLeval());

        }
        //项目状态
        if(!StringUtils.isEmpty(projectWeekly.getStatus())){
            weeklyCriteria.andStatusEqualTo(projectWeekly.getStatus());

        }
        //周数
        weeklyCriteria.andWeekNumEqualTo(projectWeekly.getWeekNum());
        List<ProjectWeekly> weeklies = weeklyMapper.selectByExample(weeklyExample);
        return weeklies;
    }
}
