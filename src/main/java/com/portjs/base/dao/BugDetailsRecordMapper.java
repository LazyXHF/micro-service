package com.portjs.base.dao;

import com.portjs.base.entity.BugDetailsRecord;
import jdk.net.SocketFlow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugDetailsRecordMapper {
    /**
     * 根据id删除审批信息（可批量删除）
     * @param ids
     * @return
     */
    int deleteByPrimaryKey(@Param("id") List<String> ids);

    int insert(BugDetailsRecord record);

    /**
     * 根据bug ID查询bug审批意见
     * @param bugDetailsRecord
     * @return
     */
    List<BugDetailsRecord> queryBugRecordByBugId(BugDetailsRecord bugDetailsRecord);

    /**
     * 添加审批意见
     * @param record
     * @return
     */
    int insertSelective(BugDetailsRecord record);

    /**
     * 根据id查询审批意见
     * @param id
     * @return
     */
    BugDetailsRecord selectByPrimaryKey(String id);

    /**
     * 更新审批意见
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BugDetailsRecord record);

    int updateByPrimaryKey(BugDetailsRecord record);

    /**
     * 根据登录人id查询代办事项
     * @param owner_id
     * @return
     */
    List<BugDetailsRecord> selectByOwnerId(@Param("owner_id") String owner_id,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);
    /**
     * 根据登录人id查询代办事项总数
     * @param owner_id
     * @return
     */
    int selectByOwnerIdCount(String owner_id);

    @Update("UPDATE t_mgt_bug_record SET STATUS = #{status} WHERE  id = #{id}")
    int updateStatusByOwnerIDAndBugId(@Param("status") String status,@Param("id")String id);




/**
 * TODO  流程操作方法------------------分割线--------------------------------------------------------------------------------------------------------------------
 */
    /**
     * 进行流程操作--更新record表状态值（status）
     * @param status  Record表的状态值
     * @return
     */
    //int updateFlowOperation(@Param("bugId")String bugId,@Param("status")int status);
    /**
     * 进行流程操作--插入record状态
     * @param backup3  主表的指派人id与之对应 record表里为 backup3
     * @param ownerId  主表的当前登录人id record表里为 ownerId
     * @return
     */
    int insertFlowOperation(BugDetailsRecord bugDetailsRecord);

    /**
     * 根据状态和当前登录人ownerId 来查询bugId
     * @return
     */
   // @Select("Select * from t_mgt_bug_record where status = #{status} and owner_id = #{ownerId}")
    BugDetailsRecord queryBugIdByStatusAndOwnerId(@Param("status")int status,@Param("ownerId")String ownerId);



    int updateBugRecordInfoss(BugDetailsRecord bugDetailsRecord);

/**
 * TODO  流程操作方法------------------分割线--------------------------------------------------------------------------------------------------------------------
 */


   @Update("UPDATE  t_mgt_bug_record   SET `status` = #{status}  where owner_id = #{ownerId} and bug_id=#{bugId}")
   int updateRecordStatus(@Param("status")String status,@Param("ownerId")String ownerId, @Param("bugId")String bugId);

    int deleteByBugId(@Param("id") String id);

    List<BugDetailsRecord> selectByBugId(@Param("bugId") String bugId);

    int updateByBugId(@Param("bugId") String bugId);

  @Select("select * from t_mgt_bug_record m  where m.status = '3'  and m.bug_id = #{id} ")
  List<BugDetailsRecord> selectBugByBugIdAndStatus(@Param("id")String id);

    int updateById(@Param("id") String id);
}