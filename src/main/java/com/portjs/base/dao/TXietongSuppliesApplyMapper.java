package com.portjs.base.dao;

import com.portjs.base.entity.TXietongSuppliesApply;
import com.portjs.base.entity.TXietongSuppliesApplyExample;
import com.portjs.base.entity.TXietongSuppliesApplyRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongSuppliesApplyMapper {
    int countByExample(TXietongSuppliesApplyExample example);

    int deleteByExample(TXietongSuppliesApplyExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongSuppliesApply record);

    int insertSelective(TXietongSuppliesApply record);

    List<TXietongSuppliesApply> selectByExample(TXietongSuppliesApplyExample example);

    TXietongSuppliesApply selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongSuppliesApply record, @Param("example") TXietongSuppliesApplyExample example);

    int updateByExample(@Param("record") TXietongSuppliesApply record, @Param("example") TXietongSuppliesApplyExample example);

    int updateByPrimaryKeySelective(TXietongSuppliesApply record);

    int updateByPrimaryKey(TXietongSuppliesApply record);
/*
 ============================================自己写的方法=========================================================================
*/
    int addSuppliedApply(TXietongSuppliesApply suppliesApply);
    //这是用品审批的查询

    int getApplyCount(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ID") String ID);

    int getApplyCountDaiBan(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ID") String ID);

    TXietongSuppliesApply queryApplying(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ID") String ID, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int getSupplyApplyingCount(@Param("ownerId") String ownerId);

        List<TXietongSuppliesApply> querySupplyApplyingList(@Param("ownerId") String ownerId, @Param("bangongId1") String bangongId1, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int consoleApplying(@Param("id") String id);

    int updateSuppliesApply(@Param("id") String id);

    TXietongSuppliesApply queryApplyById(@Param("id") String id);

    int insertHisApply(TXietongSuppliesApply suppliesApply);

    int deleteApplyById(@Param("id") String id);
//！！！！！！！！！！！！！！！！！！！！！这里第三个参数传错了  但是并没有使用！！！！！！！！  下面也是
    int queryResultCount(@Param("ownerId") String ownerId, @Param("supplyName") String supplyName, @Param("applyName") String applyName);

    int queryResultCountDaiBan(@Param("ownerId") String ownerId, @Param("supplyName") String supplyName, @Param("applyName") String applyName);

    List<TXietongSuppliesApply> queryResult(@Param("ownerId") String ownerId, @Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    List<TXietongSuppliesApply> querySupplyApplyingRepository(@Param("ownerId") String ownerId, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int updateSupplyStatus(TXietongSuppliesApply suppliesApply);

    int updatePstatus(TXietongSuppliesApply suppliesApply);

    int updateBnGongshiStatus(@Param("applyId") String applyId, @Param("bstatus") String bstatus);

    int updateRepositoryStatus(@Param("id") String id, @Param("rstatus") String rstatus);

    List<TXietongSuppliesApply> queryCaiGouList(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int getCaiGouCount(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId);

    int getCaiGouCountDaiBan(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId);

    List<TXietongSuppliesApply> queryApplying1(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId);


    int getSupplyApplyingCount1(String ownerId);

    String queryRequestType(@Param("id") String applyId);


    TXietongSuppliesApply queryApplyingDaiBan(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ID") String ID, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    List<TXietongSuppliesApply> queryResultDaiBan(@Param("ownerId") String ownerId, @Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);;

    List<TXietongSuppliesApply> queryCaiGouListDaiBan(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);;

    List<TXietongSuppliesApply> queryAll(@Param("rowNum") Integer rowNum, @Param("pageCount") Integer pageCount);

    int queryCountAll();

    int updateSypplyApply(TXietongSuppliesApply suppliesApply);

    List<TXietongSuppliesApply> queryApplying2(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int getApplyCount2(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId);

    List<TXietongSuppliesApply> queryApplyingDaiBan2(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int getApplyCountDaiBan2(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId);

    TXietongSuppliesApply print(@Param("id") String id);

    int selectCountAll(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId);

    List<TXietongSuppliesApply> selectAll(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    List<TXietongSuppliesApply> selectAllDaiBan(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int selectCountAllDaiBan(@Param("supplyName") String supplyName, @Param("applyName") String applyName, @Param("ownerId") String ownerId);

    List<String> queryAttributeFromApply(@Param("supplyName") String supplyName, @Param("supplyType") String supplyType);
}