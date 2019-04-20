package com.portjs.base.dao;

import com.portjs.base.entity.Problem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemMapper {
    /**
     * 软删除
     * @param id
     * @return
     */
    int updateFalseDeletion(@Param("id") List<String> id);

    int deleteByPrimaryKey(String id);
    /**
     *  插入
     * @param record
     * @return
     */
    int insert(Problem record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    int insertSelective(Problem record);
    /**
     * 根据record条件查询
     * @param record
     * @return
     */
    List<Problem> selectByPrimaryKey(Problem record);
    /**
     * 条件查询
     * @param
     * @return
     */
    List<Problem> queryBySomeThing(@Param("id") String id, @Param("projectId") String projectId, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("problemType") String problemType, @Param("problemPriority") String problemPriority, @Param("proposer") String proposer, @Param("solve") String solve);
    /**
     * 全更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Problem record);
    /**
     * id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Problem record);
}