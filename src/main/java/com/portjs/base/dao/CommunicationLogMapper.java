package com.portjs.base.dao;

import com.portjs.base.entity.CommunicationLog;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.CommunicationLogRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommunicationLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommunicationLog record);

    int insertSelective(CommunicationLog record);

    CommunicationLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommunicationLog record);

    int updateByPrimaryKey(CommunicationLog record);

    List<CommunicationLogRecord> selectBypreMessage(String id);

    /**
     * 根据项目问题id查询沟通记录信息
     * @param communicationId
     * @return
     */
    List<CommunicationLog> queryCommunicationLog(@Param("communicationId") String communicationId);

    /**
     * 批量删除记录信息
     * @param ids
     * @return
     */
    int deleteCommunicationLogs(@Param("id") List<String> ids);

    int insertCommunicationLogSelective(CommunicationLog record);


    /**
     * 查询留言的回复信息,id还是数据里面的id
     * @param id
     * @return
     */
    List<CommunicationLog> queryCommunicationLogs(String id);

    /**
     * 根据preMessage删除留言信息
     * @param preMessage
     * @return
     */
    int deleteCommunicationLogPreMessage(@Param("preMessage") String preMessage);

    List<CommunicationLog> selectDendrogram(@Param("communicationId") String communicationId);

    List<CommunicationLog> selectByPreMessage(@Param("id") String id);
}