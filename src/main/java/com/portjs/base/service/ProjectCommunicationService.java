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
    ResponseMessage queryProjectCommunicationById(String id);

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
    ResponseMessage updateDeleteTime(List<String> ids);

    /**
     * 项目问题沟通下拉框条件
     * @return
     */
/*    ResponseMessage queryProjectCommunicationSearch();*/

    //int updateByPrimaryKey(ProjectCommunication record);

}
