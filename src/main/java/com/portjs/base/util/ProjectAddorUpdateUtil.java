package com.portjs.base.util;

import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrator on 2019/4/2.
 */
@Component
public class ProjectAddorUpdateUtil {
    @Autowired
    private ProjectMapper projectMapper;
    public  void projectMethod(String projectId, String projectCode, String projectName, String projectType, String schedule, String creator, String organization, String projectMoney, String projectStatus){
         Project project=new Project();
         project.setId(projectId);
         project.setProjectCode(projectCode);
         project.setProjectName(projectName);
         project.setProjectType(projectType);
         project.setSchedule(schedule);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date time = null;
        try {
            time = sdf.parse(sdf.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
         project.setCreateTime(time);
         project.setCreator(creator);
         project.setOrganization(organization);
         project.setProjectMoney(projectMoney);
         project.setProjectStage(schedule);
         project.setProjectStatus(projectStatus);
          int f=projectMapper.isHaveProject(projectId);
          //如果为0  说明记录不存在  进行添加
          if(f==0){
              projectMapper.addProject(project);
          }
          //其他情况，将对应的状态进行更改
          else {
            Project project1=projectMapper.queryProjectById(projectId);
            String stage=project1.getSchedule();
            String status=project1.getProjectStatus();
            StringBuffer buffer = new StringBuffer();
            String[] statusArray=status.split(",");
            for(int i=1;i<=statusArray.length;i++){
                //如果有就替换，没有就在尾部添加
                if(projectStatus.substring(0,2).equals(statusArray[i].substring(0,2))){
                    status.replace(statusArray[i],projectStatus);
                    break;
                }
                //如果没有就一只添加，直到最后一个也没有就追加
                else {
                    buffer.append(statusArray[i]).append(",");
                    if(i==statusArray.length){
                        buffer.append(projectStatus);
                    }
                }
            }
            //如果状态的长度没有发生变化  说明是替换了  用原来的，如果变了，说明追加了  用新的
          if(status.length()==buffer.toString().length()){
                projectMapper.updateProjectById(projectId,schedule,status);
          }else {
             String newStatus=buffer.toString();
                projectMapper.updateProjectById(projectId,schedule,newStatus);
          }
          }
    }
}
