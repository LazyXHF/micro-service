package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.BusinessConfigurationMapper;
import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.dao.TUserMapper;
import com.portjs.base.entity.BusinessConfiguration;
import com.portjs.base.entity.Project;
import com.portjs.base.service.ProjectService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    @Override
    public ResponseMessage queryProjectAllInfo(JSONObject requestJson) {
        String projectCode=requestJson.getString("projectCode");
        String projectName=requestJson.getString("projectName");
        String organization=requestJson.getString("organization");
        String projectType=requestJson.getString("projectType");
        String creatorName=requestJson.getString("creatorName");
        String schedule=requestJson.getString("schedule");
        String pageNum = requestJson.getString("pageNum");
        String pageCount = requestJson.getString("pageCount");
        Page<Project> page = new Page<>();
        int totalcount=projectMapper.queryProjectAllInfoCount(projectCode,projectName,organization,projectType,creatorName,schedule);
        page.init(totalcount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
        List<Project> projectList=projectMapper.queryProjectAllInfo(projectCode,projectName,organization,projectType,creatorName,schedule,page.getRowNum(),page.getPageCount());
        for(Project project:projectList){
            String creatorId=project.getCreator();
            String creatorName2=userMapper.queryUserNameByUserId(creatorId);
            project.setCreatorName(creatorName2);
        }
        page.setList(projectList);
        return   new ResponseMessage(Code.CODE_OK, "查询成功",page);
    }

    @Override
    public ResponseMessage queryProjectDetails(JSONObject requestJson) {
        String id=requestJson.getString("id");
        String projectType=requestJson.getString("projectType");
        List<String>   typeList=businessConfigurationMapper.queryTypeList();
        Project project;
       if(typeList.contains(projectType)){
            project=projectMapper.queryProjectDetails(id,projectType);
       }else {
            String Type="其他";
            project=projectMapper.queryProjectById(id);
           BusinessConfiguration businessConfiguration=businessConfigurationMapper.querybusinessConfiguration(Type);
           project.setAllschedule(businessConfiguration.getSchedule());
           project.setNode(businessConfiguration.getNode());
       }
        String[] nodeArray=project.getNode().split(",");
       /* List<String>  nodeList=new ArrayList<>(nodeArray.length);*/
        String[] projectStatusArray=project.getProjectStatus().split(",");
        List<String>  greenList=new LinkedList<>();
        List<String>  yellowList=new LinkedList<>();
        List<String>  redList=new LinkedList<>();
         for(String projectStatus :projectStatusArray) {
             if (projectStatus.contains("1")) {
                 greenList.add(projectStatus.substring(0, 2));
             } else if (projectStatus.contains("2")) {
                 yellowList.add(projectStatus.substring(0, 2));
             } else if(projectStatus.contains("3")){
                 redList.add(projectStatus.substring(0, 2));
             }
         }
        String[] allscheduleArray=project.getAllschedule().split(",");
         //1：定义一个集合 存放所有已经完成的阶段

         //存放所有已经完成的集合
        List<String>  stageList=new ArrayList<>();
        for(String stage:allscheduleArray) {
            List<String> Alist = new ArrayList<>();
            List<String> A1list = new ArrayList<>();
            for (String node : nodeArray) {
                if (node.contains(stage)){
                    Alist.add(node);
                    for(String status : projectStatusArray) {
                        if (status.contains(node)&&status.contains("1")) {
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
        return   new ResponseMessage(Code.CODE_OK, "查询成功",project);
    }
}

