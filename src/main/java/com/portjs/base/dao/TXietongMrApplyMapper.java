package com.portjs.base.dao;

import com.portjs.base.entity.TXietongMrApply;
import com.portjs.base.entity.TXietongMrApplyExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongMrApplyMapper {
    int countByExample(TXietongMrApplyExample example);

    int deleteByExample(TXietongMrApplyExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongMrApply record);

    int insertSelective(TXietongMrApply record);

    List<TXietongMrApply> selectByExample(TXietongMrApplyExample example);

    TXietongMrApply selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongMrApply record, @Param("example") TXietongMrApplyExample example);

    int updateByExample(@Param("record") TXietongMrApply record, @Param("example") TXietongMrApplyExample example);

    int updateByPrimaryKeySelective(TXietongMrApply record);

    int updateByPrimaryKey(TXietongMrApply record);

    int count(@Param("applyId") String applyId, @Param("applyDepId") String applyDepId, @Param("ownerId") String ownerId);

    List<TXietongMrApply> selectByPage(@Param("applyId") String applyId, @Param("applyDepId") String applyDepId,
                                       @Param("ownerId") String ownerId, @Param("rowNum") Integer rowNum,
                                       @Param("pageCount") Integer pageCount);
    //
	List<TXietongMrApply> selectConferenceRoomByMsg(@Param("roomName") String roomName, @Param("beginTime") String beginTime, @Param("endTime") String endTime);
    //会议室预订
	int insertConferenceRoom(TXietongMrApply mrApply);
    //根据会议室id获取
	List<TXietongMrApply> selectMrApplyMapperByMeetingId(@Param("meeting_id") String id, @Param("date") String date);
    //登录人的审批信息
	List<TXietongMrApply> selectConferenceRoomByStatusIsOne(@Param("apply_dep_id") String apply_dep_id, @Param("apply_id") String apply_id, @Param("owner_id") String owner_id, @Param("rowNum") Integer rowNum, @Param("pageCount") Integer pageCount);
    //根据预定人的id查询其预定的会议室
	List<TXietongMrApply> selectMrApplyByApplyId(@Param("apply_id") String apply_id);
    //修改会议室状态
	int updateMrApplyStatus(TXietongMrApply mrApply);
    //根据id获取会议室使用情况
	TXietongMrApply selectMrApplyById(@Param("id") String id);
    //获得会议室审批总条数
	int selectConferenceRoomCount(@Param("apply_dep_id") String apply_dep_id, @Param("apply_id") String apply_id, @Param("owner_id") String owner_id);

	//根据id分页查询
    List<TXietongMrApply> selectMrApplyByPage(@Param("apply_id") String apply_id, @Param("rowNum")Integer rowNum,@Param("pageCount") Integer pageCount);
}