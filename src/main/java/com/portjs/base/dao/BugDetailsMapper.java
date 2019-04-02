package com.portjs.base.dao;

import com.portjs.base.entity.BugDetails;
import com.portjs.base.entity.BugDetailsRecord;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.vo.Bug;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BugDetailsMapper {
    int deleteByPrimaryKey(@Param("id") List<String> ids);

    int insert(BugDetails record);

    int insertSelective(BugDetails record);

    BugDetails selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BugDetails record);

    int updateByPrimaryKeyWithBLOBs(BugDetails record);

    int updateByPrimaryKey(BugDetails record);



//
//    /**
//     * 级联查询
//     * @return
//     */
//    List<BugDetails> queryAllBugAndRecordInfo(@Param("id") String id);
//



    /**
     * 根据指派人id去查询流程表
     * @param ownerId
     * @return
     */
    @Select("select * from t_mgt_bug_record where owner_id = #{ownerId}")
    List<BugDetailsRecord> queryBugDetailsRecordByOwnerId(@Param("ownerId")String ownerId);



    /**
     * bug分页列表(添加页面)
     * @param modules  模块
     * @param projectedName   项目名称
     * @param designatedPersion  指派人
     * @param result    处理结果
     * @return
     */
    List<BugDetails> queryAllBugInfo(@Param("projectId")String projectId,@Param("result")int result,@Param("modules")String modules,@Param("projectedName")String projectedName,
                                                  @Param("designatedPersion")String designatedPersion,
                                                  @Param("pageNo")int pageNo,@Param("pageSize")int pageSize);
    /**
     * bug分页列表（待办页面）
     * @return
     */
    List<BugDetails> queryAllBugInfoFlow(@Param("id")String id,
                                     @Param("pageNo")int pageNo,@Param("pageSize")int pageSize);
    /**
     * 统计bug条数（添加页面）
     * @param projectId
     * @return
     */
    int bugCounts(@Param("projectId")String projectId,@Param("result")int result,@Param("modules")String modules,@Param("projectedName")String projectedName,
                  @Param("designatedPersion")String designatedPersion);

    /**
     * 统计bug条数（待办页面）
//     * @param projectId
     * @return
     */
    int bugFlowCounts(@Param("id")String id);


    /**
     * 查询所有bug信息
     * @return
     */
//    @Select("select  DISTINCT status,type,priority from t_mgt_bug where status is not null and type is not null and priority is not null")
//    List<Bug> queryAllBugIf();

//    @Update("update t_mgt_bug set result=#{result} where id=#{id}")
//     int updateStatusById(@Param("result")String result,@Param("id")String id);


    /**
     * 查询待办
     * @return
     */
    List<BugDetails>  selectBugSearchDealtWith(@Param("ownerId")String ownerId, @Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize);

    int countBugSearchDealtWith(@Param("ownerId")String ownerId);

    /**
     * 查询在办
     */
    List<BugDetails> selectBugSearchDealtDoing(@Param("ownerId")String ownerId, @Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize);
    int countBugSearchDealtDoing(@Param("ownerId")String ownerId);

    /**
     * 查询是否有待办bug
     * @param ownerId
     * @return
     */
    List<BugDetails>  selectIsBugSearchDealtWith(@Param("ownerId")String ownerId);


    /**
     * 查询已办
     */
    List<BugDetails> selectBugSearchDealtEnd(@Param("ownerId")String ownerId, @Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize);
    int countBugSearchDealtEnd(@Param("ownerId")String ownerId);

    List<BugDetails> queryAllBugAndRecordInfo(@Param("id") String id);



    //修改主表状态
    @Update("UPDATE  t_mgt_bug SET result=#{result} and mendTime = #{endTime} WHERE id = #{id}")
    int updateStatusById(@Param("result") String result,@Param("id")String id,@Param("endTime")Date endTime);
}