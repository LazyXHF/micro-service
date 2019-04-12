package com.portjs.base.dao;

import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.entity.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InternalPersionResourceMapper {

    int deleteByPrimaryKey(String id);
    int deletePersons(String projectId);
    /**
     * 批量删除人员信息
     * @return
     */
    int updatePersionInfoByIds(@Param("id") List<String> ids);

    /**
     * 添加人员信息
     * @param record
     * @return
     */
    int insertPersionInfo(InternalPersionResource record);

    /**
     * 根据项目id获取人员信息
     * @return id
     */
    List<InternalPersionResource> queryAllPersionInfo(@Param("id")String projectId,@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /**
     * 统计项目相关人员数目
     * @param projectId
     * @return
     */
    int persionCounts(@Param("id")String projectId);

    int insertSelective(InternalPersionResource record);

    /**
     * 根据人员信息id获取人员信息
     * @param id
     * @return
     */
    InternalPersionResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InternalPersionResource record);

    /**
     * 更新人员信息
     * @param record
     * @return
     */
    int updatePersionInfo(InternalPersionResource record);

}