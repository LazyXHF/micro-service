package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.dao.ProjectWeeklyMapper;
import com.portjs.base.dao.TUserMapper;
import com.portjs.base.entity.*;
import com.portjs.base.service.WeeklyAndMonthlyReportManagementService;
import com.portjs.base.util.Code;
import com.portjs.base.util.IDUtils;
import com.portjs.base.util.ResponseMessage;
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
    private ProjectMapper projectMapper;
    @Autowired
    private ProjectWeeklyMapper weeklyMapper;
    /**
     * 周报详情查询
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectWeeklyDetails(String requestBody) throws Exception{
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String UserId = jsonObject.getString("UserId");//当前登录人id
        String weekNum = jsonObject.getString("weekNum");//周数
        TUser user = userMapper.selectByPrimaryKey(UserId);
        if(user==null){
            throw new Exception("当前用户不存在");
        }
        if(user.getDuty().equals("项目组长")){
            ProjectExample projectExample = new ProjectExample();
            projectExample.setOrderByClause("create_time");
            ProjectExample.Criteria projectCriteria = projectExample.createCriteria();
            projectCriteria.andBackUp1EqualTo(UserId);
            List<Project> projectList = projectMapper.selectByExample(projectExample);
            LinkedList list = new LinkedList();
            if(!CollectionUtils.isEmpty(projectList)){
                for(int i=0;i<projectList.size();i++){
                    LinkedHashMap map = new LinkedHashMap();
                    Project project = projectList.get(i);
                    //一周完成情况
                    ProjectWeeklyExample weeklyExample = new ProjectWeeklyExample();
                    ProjectWeeklyExample.Criteria weeklyCriteria = weeklyExample.createCriteria();
                    weeklyCriteria.andProjectIdEqualTo(project.getId());
                    weeklyCriteria.andWeekNumEqualTo(weekNum);
                    List<ProjectWeekly> weeklies = weeklyMapper.selectByExample(weeklyExample);

                    map.put("project",project);
                    if(!CollectionUtils.isEmpty(weeklies)){
                        map.put("weekly",weeklies.get(0));
                    }else {
                        map.put("weekly",null);
                    }

                    list.add(map);
                }
                return new ResponseMessage(Code.CODE_OK,"查询成功",list);
            }
        }
        return new ResponseMessage(Code.CODE_ERROR,"当前登录人不是项目经理");
    }

    /**
     * 提交保存周报详情
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage submissionWeeklyDetails(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        JSONArray weeklyJSON = jsonObject.getJSONArray("WeeklyJSON");
        if(!CollectionUtils.isEmpty(weeklyJSON)){
            for (Object weekly : weeklyJSON) {
                ProjectWeekly projectWeekly = JSONObject.toJavaObject((JSONObject)weekly, ProjectWeekly.class);
                //判断是否是更新还是新增
                if(StringUtils.isEmpty(projectWeekly.getId())){
                    projectWeekly.setId(String.valueOf(IDUtils.genItemId()));
                    projectWeekly.setCreateTime(new Date());

                    int i = weeklyMapper.insertSelective(projectWeekly);
                    if(i!=1){
                        return new ResponseMessage(Code.CODE_ERROR,"新增失败");
                    }
                    return new ResponseMessage(Code.CODE_OK,"新增成功");
                }else {
                    projectWeekly.setUpdateTime(new Date());

                    int i = weeklyMapper.updateByPrimaryKeySelective(projectWeekly);
                    if(i!=1){
                        return new ResponseMessage(Code.CODE_ERROR,"修改失败");
                    }
                    return new ResponseMessage(Code.CODE_OK,"修改成功");
                }
            }
        }
        return new ResponseMessage(Code.CODE_ERROR,"请输入数据");
    }

    /**
     * 周报查询
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectWeekly(String requestBody)throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String UserId = jsonObject.getString("UserId");//当前登录人id
        JSONObject weekly = jsonObject.getJSONObject("Weekly");
        ProjectWeekly projectWeekly = JSONObject.toJavaObject(weekly,ProjectWeekly.class);
        TUser user = userMapper.selectByPrimaryKey(UserId);
        if(user==null){
            throw new Exception("当前用户不存在");
        }
        ProjectWeeklyExample weeklyExample = new ProjectWeeklyExample();
        ProjectWeeklyExample.Criteria weeklyCriteria = weeklyExample.createCriteria();
        if(user.getDuty().equals("项目组长")){
            /*weeklyCriteria.andProjectManagerEqualTo(UserId);*/
            weeklyCriteria.andModifierEqualTo(UserId);
            if(!StringUtils.isEmpty(projectWeekly.getProjectManager())){
                weeklyCriteria.andProjectManagerLike("%"+projectWeekly.getProjectManager()+"%");
            }

        }else if(user.getDuty().equals("分管领导")){
            if(!StringUtils.isEmpty(projectWeekly.getProjectManager())){
                weeklyCriteria.andProjectManagerLike("%"+projectWeekly.getProjectManager()+"%");
            }
        }
        if(!StringUtils.isEmpty(projectWeekly.getProjectCode())){
            weeklyCriteria.andProjectCodeEqualTo("%"+projectWeekly.getProjectCode()+"%");

        }
        if(!StringUtils.isEmpty(projectWeekly.getProjectName())){
            weeklyCriteria.andProjectNameLike("%"+projectWeekly.getProjectName()+"%");

        }
        if(!StringUtils.isEmpty(projectWeekly.getProjectType())){
            weeklyCriteria.andProjectTypeEqualTo(projectWeekly.getProjectType());

        }
        if(!StringUtils.isEmpty(projectWeekly.getLeval())){
            weeklyCriteria.andLevalEqualTo(projectWeekly.getLeval());

        }
        if(!StringUtils.isEmpty(projectWeekly.getStatus())){
            weeklyCriteria.andStatusEqualTo(projectWeekly.getStatus());

        }
        weeklyCriteria.andWeekNumEqualTo(projectWeekly.getWeekNum());
        List<ProjectWeekly> weeklies = weeklyMapper.selectByExample(weeklyExample);
        if(!CollectionUtils.isEmpty(weeklies)){
            return new ResponseMessage(Code.CODE_OK,"查询成功",weeklies);
        }
        return new ResponseMessage(Code.CODE_ERROR,"查询失败");
    }
}
