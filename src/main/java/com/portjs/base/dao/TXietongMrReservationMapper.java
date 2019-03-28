package com.portjs.base.dao;

import com.portjs.base.entity.TXietongMrReservation;
import com.portjs.base.entity.TXietongMrReservationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongMrReservationMapper {
    int countByExample(TXietongMrReservationExample example);

    int deleteByExample(TXietongMrReservationExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongMrReservation record);

    int insertSelective(TXietongMrReservation record);

    List<TXietongMrReservation> selectByExample(TXietongMrReservationExample example);

    TXietongMrReservation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongMrReservation record, @Param("example") TXietongMrReservationExample example);

    int updateByExample(@Param("record") TXietongMrReservation record, @Param("example") TXietongMrReservationExample example);

    int updateByPrimaryKeySelective(TXietongMrReservation record);

    int updateByPrimaryKey(TXietongMrReservation record);
    //会议查询
	List<TXietongMrReservation> selectTXietongMrReservation(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("res_id") String res_id);
    //会议室删除
	int deleteTXietongMrReservation(@Param("ids") String ids);
    //待开会议查询
	List<TXietongMrReservation> selectWaitingTXietongMrReservation(@Param("res_id") String res_id);
    //已开会议的查询
	List<TXietongMrReservation> txietongMrReservationIsOver(@Param("meeting_subject") String meeting_subject, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("res_id") String res_id);
   
}