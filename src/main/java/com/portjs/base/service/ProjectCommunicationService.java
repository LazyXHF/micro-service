package com.portjs.base.service;

import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.util.ResponseMessage;

import java.util.List;

public interface ProjectCommunicationService {

    ResponseMessage deleteByPrimaryKey(String id);

    //int insert(ProjectCommunication record);

   // ResponseMessage insertSelective(ProjectCommunication record);
    ResponseMessage insertProjectCommunicationSelective(ProjectCommunication record);

    //ResponseMessage selectByPrimaryKey(String id);

    ResponseMessage updateByPrimaryKeySelective(ProjectCommunication record);

    /**
     * 对项目问题的分页并模糊查询
     * @param requestBody
     * @return
     */
    ResponseMessage queryProjectCommunicationInfo(String requestBody);

    /**
     * 批量软删除
     * @param ids
     * @return
     */
    ResponseMessage insertDeleteTime(List<String> ids);


    //int updateByPrimaryKey(ProjectCommunication record);

}
