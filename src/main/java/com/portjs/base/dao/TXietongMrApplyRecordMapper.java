package com.portjs.base.dao;

import com.portjs.base.entity.TXietongMrApplyRecord;
import com.portjs.base.entity.TXietongMrApplyRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongMrApplyRecordMapper {
    int countByExample(TXietongMrApplyRecordExample example);

    int deleteByExample(TXietongMrApplyRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongMrApplyRecord record);

    int insertSelective(TXietongMrApplyRecord record);

    List<TXietongMrApplyRecord> selectByExample(TXietongMrApplyRecordExample example);

    TXietongMrApplyRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongMrApplyRecord record, @Param("example") TXietongMrApplyRecordExample example);

    int updateByExample(@Param("record") TXietongMrApplyRecord record, @Param("example") TXietongMrApplyRecordExample example);

    int updateByPrimaryKeySelective(TXietongMrApplyRecord record);

    int updateByPrimaryKey(TXietongMrApplyRecord record);
    //审批人审批会议室
	int updateAfterCheckConferenceRoom(@Param("opinion") String opinion, @Param("rec_comment") String rec_comment, @Param("mrRecordId") String mrRecordId);
    //查询审批人审批信息
	List<TXietongMrApplyRecord> selectMrApplyByMrApplyId(@Param("apply_id") String applyId);
}