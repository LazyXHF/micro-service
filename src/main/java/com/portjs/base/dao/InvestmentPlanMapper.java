package com.portjs.base.dao;

import com.portjs.base.entity.InvestmentPlan;
import com.portjs.base.entity.InvestmentPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestmentPlanMapper {
    int countByExample(InvestmentPlanExample example);

    int deleteByExample(InvestmentPlanExample example);

    int deleteByPrimaryKey(String id);

    int insert(InvestmentPlan record);

    int insertSelective(InvestmentPlan record);

    List<InvestmentPlan> selectByExample(InvestmentPlanExample example);

    InvestmentPlan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InvestmentPlan record, @Param("example") InvestmentPlanExample example);

    int updateByExample(@Param("record") InvestmentPlan record, @Param("example") InvestmentPlanExample example);

    int updateByPrimaryKeySelective(InvestmentPlan record);

    int updateByPrimaryKey(InvestmentPlan record);
}