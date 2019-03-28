package com.portjs.base.service;


import com.portjs.base.entity.*;

import java.util.List;

/**
 * Created by Administrator on 2018/12/22.
 */

public interface BanGongManagerService {
    public int  addBanGong(TXietongSupplies supplies);

    int getCount(String content, String category);


    int updateBanGong(TXietongSupplies supplies);

    int getRecordCount(String supplyName, String receiptorName);

    List<TXietongSupplyRecord> getSupplyRecord(String supplyId, String supplyType);

    int addRecords(TXietongSupplyRecord record);


    int addSuppliedApply(TXietongSuppliesApply suppliesApply);

    int addApplyRecords(TXietongSuppliesApplyRecord applyRecord);

    int getApplyCount(String supplyName, String applyName, String ID);

    TXietongSuppliesApply queryApplying(String supplyName, String applyName, String ID, Integer rowNum, Integer pageCount);

    int updateapplyRecord(TXietongSuppliesApplyRecord applyRecords);

    int getSupplyApplyingCount(String ownerId);

    List<TXietongSuppliesApply> querySupplyApplyingList(String ownerId, String bangongId1, Integer rowNum, Integer pageCount);

    List<TXietongSuppliesApplyRecord> queryhandleDetails(String id);

    int consoleApplying(String id);

    int updateSuppliesApply(String id);

    int addSupplyRecord(TXietongSupplyRecord supplyRecord);

    int queryStock(String supplyName, String supplyType);

    int updateSupplies(int newStcok, String supplyName, String supplyType, Integer attribute);

    List<TXietongSuppliesRepository> querySupplyName(String categoryId);

    List<TXietongSuppliesRepository> querySupplyType(Integer id);

    List<TXietongDictionary> queryApplyPeople();

    /*int updateSupplyRecords(String id);*/

    int deleteSupplyApplyRecords(String id);

    TXietongSuppliesApply queryApplyById(String id);

    int insertHisApply(TXietongSuppliesApply suppliesApply);

    int deleteApplyById(String id);

    int addBanGongName(String supplyName, String categoryId);

    int addBanGongType(String type, Integer id);

    int queryChongFu(String categoruId, String supplyName);


    int addToRepository(TXietongSuppliesApplyRecord toRepository);

    int queryResultCount(String ownerId, String supplyName, String supplyType);

    int queryResultCountDaiBan(String ownerId, String supplyName, String supplyType);

    List<TXietongSuppliesApply> queryResult(String ownerId, String supplyName, String applyName, Integer rowNum, Integer pageCount);



    int queryChongFuType(String type);

    int deleteRepository(String id);

    int updateOfficer(String id, String nameId, String name);

    TXietongDictionary queryOfficer(String id);

    TXietongSupplies querySupplysById(String id);

    int deleteSupplyRecord(String name, String type);

    int deleteName(Integer id);

    int deleteType(Integer id);

    TXietongSuppliesApplyRecord queryBanGongXiangqing(String id, String ownerId);

    Integer queryPucharseStatus(String id, String pucharseId1);

    long queryPucharseId();

    List<TXietongSuppliesApply> querySupplyApplyingRepository(String ownerId, Integer rowNum, Integer pageCount);

    int updateapplyRecordCaiGouYuan(TXietongSuppliesApplyRecord applyRecords);

    Long queryBanGongId();

    int updateSupplyStatus(TXietongSuppliesApply suppliesApply);

    int updatePstatus(TXietongSuppliesApply suppliesApply);

    int updateBnGongshiStatus(String applyId, String bstatus);

    int updateRepositoryStatus(String id, String rstatus);

    List<TXietongSuppliesApply> queryCaiGouList(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount);

    int getCaiGouCount(String supplyName, String applyName, String ownerId);

    int updateapplyRecord1(TXietongSuppliesApplyRecord applyRecords);

    List<TXietongSuppliesApply> queryApplying1(String supplyName, String applyName, String ownerId);

    int querySupply(String supplyName, String supplyType);

    String querySupplyId(String category, String name, String type);

    Integer queryOpinion(String id, String bangongshiId);

    int getSupplyApplyingCount1(String ownerId);

    String queryRecordId(String applyId, String ownerId);

    String queryRequestType(String applyId);


    Long queryRepositoryId();

    TXietongSuppliesApply queryApplyingDaiBan(String supplyName, String applyName, String ID, Integer rowNum, Integer pageCount);

    List<TXietongSuppliesApply> queryResultDaiBan(String ownerId, String supplyName, String applyName, Integer rowNum, Integer pageCount);

    List<TXietongSuppliesApply> queryCaiGouListDaiBan(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount);

    int updateapplyRecordById(String id);

    String queryRecordIdBanGong(String applyId, String ownerId);

    List<TXietongSupplyRecord> queryAllSupplyNames();

    List<TXietongSupplyRecord> querySupplyRecord(String supplyName, String departName, String ym);

    List<TXietongSupplyRecord> queryAllDepartNames();

    Double queryPrice(String supplyName, String supplyType);

    List<String> querySupplyYears();

    int getApplyCountDaiBan(String supplyName, String applyName, String ownerId);


    int getCaiGouCountDaiBan(String supplyName, String applyName, String ownerId);

    int queryCategory(String category);

    int addCategory(String id, String category);

    List<TXietongSuppliesCategory> queryCategories();

    int deleteCategory(String id);

    List<TXietongSupplies> getSupplies(String cintent, String category, Integer rowNum, Integer pageCount);

    List<TXietongSupplies> getSupplies1(String content, String category, Integer rowNum, Integer pageCount);

    TXietongSuppliesApplyRecord queryBanGongXiangqing1(String id, String repositoryId1);

    int querySupplyByName(String supplyName, String supplyType);

    List<TXietongSuppliesApply> queryAll(Integer rowNum, Integer pageCount);

    int getCountAll();

    TXietongSuppliesCategory queryCategoryClass(String category);

    TXietongSuppliesRepository queryRepository(String name);

    int insertCategory(String categoryid2, String category);

    int insertSupply(String name, String categoryid2);

    int queryNameId(String name, String categoryid2);

    int insertType(String type, int typeId);

    int updateRepository(String name, String categoryid2);

    int queryRepositoryType(String type, Integer typeId);

    int getCount1(String content, String category);

    List<TXietongSuppliesApplyRecord> queryApplyRecords(String ownerId, String id);

    Long queryCaiGouYuanId();

    int updateSypplyApply(TXietongSuppliesApply suppliesApply);

    List<TXietongSuppliesApply> queryApplying2(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount);

    int getApplyCount2(String supplyName, String applyName, String ownerId);

    int updateOfficerRecord(TXietongSuppliesApplyRecord record);

    List<TXietongSuppliesApply> queryApplyingDaiBan2(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount);

    int getApplyCountDaiBan2(String supplyName, String applyName, String ownerId);

    List<TXietongSuppliesApplyRecord> querySupplyApplyRecord(String ownerId);

    List<TXietongSuppliesApplyRecord> querySupplyApplyRecord2(String ownerId, Integer rowNum, Integer pageCount);

    int updateBanGongshiStatus(String id, String nextPeopleId);

    TXietongSuppliesApply print(String id);

    int queryStatus(String id, String ownerId);

    int selectCountAll(String supplyName, String applyName, String ownerId);

    List<TXietongSuppliesApply> selectAll(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount);

    List<TXietongSuppliesApply> selectAllDaiBan(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount);

    int selectCountAllDaiBan(String supplyName, String applyName, String ownerId);

    int updateApplyStatus(String id, String applyId);

    String queryRecordCaiGouId(String id, String caigouyuanId);

    List<TXietongSuppliesCategory> querySupplyCategories();

    List<Integer> queryAttribute(String name, String type);

    int updateSupplies1(int newStock, String supplyName, String supplyType);

    List<String> queryAttributeFromApply(String supplyName, String supplyType);

    int queryCategorySupply(String id, String name);
}
