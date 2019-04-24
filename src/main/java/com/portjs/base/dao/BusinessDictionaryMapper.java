package com.portjs.base.dao;

import com.portjs.base.entity.BusinessDictionary;
import com.portjs.base.entity.BusinessDictionaryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BusinessDictionaryMapper {
    int countByExample(BusinessDictionaryExample example);

    int deleteByExample(BusinessDictionaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(BusinessDictionary record);

    int insertSelective(BusinessDictionary record);

    List<BusinessDictionary> selectByExample(BusinessDictionaryExample example);

    BusinessDictionary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusinessDictionary record, @Param("example") BusinessDictionaryExample example);

    int updateByExample(@Param("record") BusinessDictionary record, @Param("example") BusinessDictionaryExample example);

    int updateByPrimaryKeySelective(BusinessDictionary record);

    int updateByPrimaryKey(BusinessDictionary record);

    BusinessDictionary selectByNode(@Param("projectNode") String projectNode);

    List<BusinessDictionary> selectAllProjectSchedule();
}