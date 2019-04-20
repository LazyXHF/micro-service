package com.portjs.base.dao;

import com.portjs.base.entity.Approval;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalMapper {
    /**
     * 删除 支持多条删除
     * @param ids
     * @return
     */
    int deleteByPrimaryKey(String[] ids);

    /**
     * 批量软删除
     * @param id
     * @return
     */
    int updateApprovals(@Param("id") List<String> id);
    /**
     *  插入
     * @param record
     * @return
     */
    int insert(Approval record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    int insertSelective(Approval record);
    /**
     * 根据record条件查询
     * @param record
     * @return
     */
    List<Approval> selectByPrimaryKey(Approval record);
    /**
     * 条件更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Approval record);
    /**
     * 全更新
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Approval record);
    /**
     * id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Approval record);
}