package com.portjs.base.dao;

import com.portjs.base.entity.BusinessConfiguration;
import com.portjs.base.entity.BusinessConfigurationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessConfigurationMapper {
    int countByExample(BusinessConfigurationExample example);

    int deleteByExample(BusinessConfigurationExample example);

    int deleteByPrimaryKey(String id);

    int insert(BusinessConfiguration record);

    int insertSelective(BusinessConfiguration record);

    List<BusinessConfiguration> selectByExample(BusinessConfigurationExample example);

    BusinessConfiguration selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusinessConfiguration record, @Param("example") BusinessConfigurationExample example);

    int updateByExample(@Param("record") BusinessConfiguration record, @Param("example") BusinessConfigurationExample example);

    int updateByPrimaryKeySelective(BusinessConfiguration record);

    int updateByPrimaryKey(BusinessConfiguration record);

    BusinessConfiguration querybusinessConfiguration(@Param("type") String type);

    List<String> queryTypeList();

    List<BusinessConfiguration> selectByProjectSchedule(@Param("projectId") String projectId, @Param("projectSchedule") String projectSchedule);

    List<BusinessConfiguration> selectAll(@Param("projectId") String projectId);
}