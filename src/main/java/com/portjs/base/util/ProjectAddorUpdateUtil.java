package com.portjs.base.util;

import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.dao.TUserMapper;
import com.portjs.base.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrator on 2019/4/2.
 */
@Component
@Transactional
public class ProjectAddorUpdateUtil {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private TUserMapper tUserMapper;
    int i = 001;

    public void projectMethod(String projectId, String projectCode, String projectName, String projectType, String schedule,
                              String creator, String organization, String projectMoney, String projectStatus, String investor) throws Exception {
        Project project = new Project();
        project.setId(projectId);
        //这里将创建人姓名添加进入数据库，传入进来的creator为Id
        String creatorName = tUserMapper.queryUserNameByUserId(creator);
        if (projectCode == null || projectCode.length() == 0) {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DATE);//获取日
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);
            i = i++;
            String time2 = "PR" + year + "" + month + day + hour + minute + second + i;
            project.setProjectCode(time2);
        } else {
            project.setProjectCode(projectCode);
        }
        Date ApplicationEndTime;
        if (projectStatus.equals("Aa1")) {
            ApplicationEndTime = new Date();
            project.setApplicationEndTime(ApplicationEndTime);
        } else {
            ApplicationEndTime = null;
            project.setApplicationEndTime(ApplicationEndTime);
        }
        project.setProjectName(projectName);
        project.setProjectType(projectType);
        project.setSchedule(schedule);
        project.setCreatorName(creatorName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date time = null;
        time = sdf.parse(sdf.format(new Date()));
        project.setCreateTime(time);
        project.setCreator(creator);
        project.setOrganization(organization);
        project.setProjectMoney(projectMoney);
        project.setProjectStage(schedule);
        project.setProjectStatus(projectStatus);
        project.setInvestor(investor);
        int f = projectMapper.isHaveProject(projectId);
        //如果为0  说明记录不存在  进行添加
        if (f == 0) {
            projectMapper.addProject(project);
        }
        //其他情况，将对应的状态进行更改
        else {
            Project project1 = projectMapper.queryProjectById(projectId);
            String stage = project1.getSchedule();
            String status = project1.getProjectStatus();
            //这个存放第一种情况
            StringBuffer buffer = new StringBuffer();
            //这个存放第二种情况
            StringBuffer buffer2 = new StringBuffer();
            String[] statusArray = status.split(",");
            for (int i = 0; i < statusArray.length; i++) {
                //如果有就替换，没有就在尾部添加
                String astatus = statusArray[i].substring(0, 2);
                if (projectStatus.substring(0, 2).equals(astatus)) {
                    String replaceStatus = statusArray[i].substring(0);
                    String status2 = status.replace(replaceStatus, projectStatus);
                    buffer.append(status2);
                    break;
                }
                //如果没有就一只添加，直到最后一个也没有就追加
                else {
                    buffer2.append(statusArray[i]).append(",");
                    if (i == (statusArray.length - 1)) {
                        buffer2.append(projectStatus);
                    }
                }
            }
            //如果状态的长度没有发生变化了   说明替换了  用buffer
            if (status.length() == buffer.toString().length()) {
                projectMapper.updateProjectById(projectId, projectCode, ApplicationEndTime, creator, schedule, buffer.toString());
            }
            //如果变了，说明追加了用新的
            else {
                String newStatus = buffer2.toString();
                projectMapper.updateProjectById(projectId, projectCode, ApplicationEndTime, creator, schedule, newStatus);
            }
        }

    }
}
