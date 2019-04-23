package com.portjs.base.util;

import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: daiyueyuan
 * @date: 2019/4/22 20:08
 * @description:
 */
@Component
@Transactional
public class ProjectUtils {
    @Autowired
    private ProjectMapper projectMapper;

    public void projectMethod(String projectId, String projectCode, String schedule, String projectStatus) {

        Project project = projectMapper.selectByPrimaryKey(projectId);
        if (project.getProjectStatus() == null) {
            project.setProjectStatus(projectStatus);
        }
        String status = project.getProjectStatus();
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
        for (String prostatus : statusArray) {
            if ("3".equals(prostatus.substring(2, 3))) {
                project.setStatus("3");
                break;
            } else if ("0".equals(prostatus.substring(2, 3))) {
                project.setStatus("0");
                break;
            } else if ("2".equals(prostatus.substring(2, 3))) {
                project.setStatus("2");
            } else {
                project.setStatus("1");
            }
        }
        //如果状态的长度没有发生变化了   说明替换了  用buffer
        if (status.length() == buffer.toString().length()) {
            project.setProjectCode(projectCode);
            project.setSchedule(schedule);
            project.setProjectStatus(buffer.toString());
            projectMapper.updateByPrimaryKeySelective(project);
        }
        //如果变了，说明追加了用新的
        else {
            project.setProjectCode(projectCode);
            project.setSchedule(schedule);
            project.setProjectStatus(buffer2.toString());
            projectMapper.updateByPrimaryKeySelective(project);
        }
    }
}
