package com.portjs.base.service;

import com.portjs.base.entity.CommunicationLog;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommunicationLogService {

    //ResponseMessage deleteByPrimaryKey(String id);

    //int insert(CommunicationLog record);

    //ResponseMessage insertSelective(CommunicationLog record);

    //CommunicationLog selectByPrimaryKey(String id);

    /**
     * 批量删除记录信息
     * @param ids
     * @return
     */
    //ResponseMessage deleteCommunicationLogs(List<String> ids);\

    /**
     * 查询留言的回复信息,id还是数据里面的id
     * @param id
     * @return
     */
    ResponseMessage queryCommunicationLogs(String id);
    /**
     * 根据项目问题id查询沟通记录信息
     * @param communicationId
     * @return
     */
    ResponseMessage queryCommunicationLog(@Param("communicationId") String communicationId);

    ResponseMessage updateByPrimaryKeySelective(CommunicationLog record);

    ResponseMessage insertCommunicationLogSelective(CommunicationLog record);

    //int updateByPrimaryKey(CommunicationLog record);
}
