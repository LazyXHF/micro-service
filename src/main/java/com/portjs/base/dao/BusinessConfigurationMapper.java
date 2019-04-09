package com.portjs.base.dao;

import com.portjs.base.entity.BusinessConfiguration;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BusinessConfigurationMapper {
    int deleteByPrimaryKey(String id);

    int insert(BusinessConfiguration record);

    int insertSelective(BusinessConfiguration record);

    BusinessConfiguration selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BusinessConfiguration record);

    int updateByPrimaryKey(BusinessConfiguration record);

    BusinessConfiguration querybusinessConfiguration(@Param("type") String type);

    List<String> queryTypeList();

    /*@Select("select schedule from business_configuration where project_type = #{projectType}")
    List<BusinessConfiguration> selectBusinessConfigurationSchedule(@Param("projectType")String projectType);*/
}