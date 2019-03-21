package com.portjs.base.dao;

import com.portjs.base.entity.TXietongMeetingroom;
import com.portjs.base.entity.TXietongMeetingroomExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongMeetingroomMapper {
    int countByExample(TXietongMeetingroomExample example);

    int deleteByExample(TXietongMeetingroomExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongMeetingroom record);

    int insertSelective(TXietongMeetingroom record);

    List<TXietongMeetingroom> selectByExample(TXietongMeetingroomExample example);

    TXietongMeetingroom selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongMeetingroom record, @Param("example") TXietongMeetingroomExample example);

    int updateByExample(@Param("record") TXietongMeetingroom record, @Param("example") TXietongMeetingroomExample example);

    int updateByPrimaryKeySelective(TXietongMeetingroom record);

    int updateByPrimaryKey(TXietongMeetingroom record);
    //根据登陆人的部门id获取可查看的会议室
	List<TXietongMeetingroom> selectMeetingRoomByDepartmentId(@Param("deptName") String departmentName, @Param("deptId") String departmentId, @Param("status") String status, @Param("room_id") String room_id);
    //根据id获取会议室信息
	TXietongMeetingroom selectMeetingRoomById(String id);
    //修改会议室信息
	int updateTXietongMeetingroom(TXietongMeetingroom room);
    //查询有无重复会议名
	List<TXietongMeetingroom> selectMeetingroomById(String id);
}