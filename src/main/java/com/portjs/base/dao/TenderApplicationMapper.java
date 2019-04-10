package com.portjs.base.dao;

import com.portjs.base.entity.TenderApplication;
import com.portjs.base.entity.TenderApplicationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TenderApplicationMapper {
    int countByExample(TenderApplicationExample example);

    int deleteByExample(TenderApplicationExample example);

    int deleteByPrimaryKey(String id);

    int insert(TenderApplication record);

    int insertSelective(TenderApplication record);

    List<TenderApplication> selectByExample(TenderApplicationExample example);

    TenderApplication selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TenderApplication record, @Param("example") TenderApplicationExample example);

    int updateByExample(@Param("record") TenderApplication record, @Param("example") TenderApplicationExample example);

    int updateByPrimaryKeySelective(TenderApplication record);

    int updateByPrimaryKey(TenderApplication record);

    /**
     * 查询总数
     * @param method
     * @param projectId
     * @param projectName
     * @return
     */
    int selectByMethodCount(@Param("method") String method, @Param("projectId") String projectId,@Param("projectName")  String projectName);
}