package com.portjs.base.dao;

import com.portjs.base.entity.BugDetails;
import com.portjs.base.entity.InternalPersionResource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
    int bugCounts(@Param("projectId")String projectId,@Param("modules")String modules,@Param("title")String title,
                  @Param("designatedPersion")String designatedPersion,@Param("result")int result);

    /**
     * bug分页列表
     * @param modules  模块
     * @param title   标题
     * @param designatedPersion  指派人
     * @param result    处理结果
     * @return
     */
    List<BugDetails> queryAllBugInfo(@Param("projectId")String projectId,@Param("modules")String modules,@Param("title")String title,
                                                  @Param("designatedPersion")String designatedPersion,@Param("result")int result,
                                                  @Param("pageNo")int pageNo,@Param("pageSize")int pageSize);


    /**
     * 查询所有bug信息
     * @return
     */
    @Select("select DISTINCT modules, designated_persion, projected_name from t_mgt_bug")
    List<BugDetails> queryAllBugInfos();
}