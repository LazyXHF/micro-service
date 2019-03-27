package com.portjs.base.dao;

import com.portjs.base.entity.BugDetailsRecord;
import org.apache.ibatis.annotations.Param;
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
}