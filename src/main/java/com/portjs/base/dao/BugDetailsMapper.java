package com.portjs.base.dao;

import com.portjs.base.entity.BugDetails;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.vo.Bug;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

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


    /**
     * 统计bug条数
     * @param projectId
     * @return
     */
    int bugCounts(@Param("projectId")String projectId,@Param("result")int result,@Param("modules")String modules,@Param("projectedName")String projectedName,
                  @Param("designatedPersion")String designatedPersion);

    /**
     * bug分页列表
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
     * 查询所有bug信息
     * @return
     */
//    @Select("select  DISTINCT status,type,priority from t_mgt_bug where status is not null and type is not null and priority is not null")
//    List<Bug> queryAllBugIf();

    /**
     * 级联查询
     * @return
     */
    List<BugDetails> queryAllBugAndRecordInfo(@Param("id") String id);



    //修改主表状态
    @Update("UPDATE  t_mgt_bug SET result=#{result} WHERE id = #{id}")
    int updateStatusById(@Param("result") String result,@Param("id")String id);
}