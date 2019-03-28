package com.portjs.base.service.impl;

import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.BanGongManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Administrator on 2018/12/22.
 */
@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = -1)
public class BanGongManagerSerImpl implements BanGongManagerService {
    static final String tag="BanGongManagerSerImpl";
    static final Logger logger= LoggerFactory.getLogger(BanGongManagerSerImpl.class);
    @Autowired
    private BanGongManagerDao bangongmanagerdao;
    //这是领用记录的dao
    @Autowired
    private TXietongSupplyRecordMapper supplyRecordMapper;
    @Autowired
    private TXietongSuppliesApplyMapper applyMapper;
    @Autowired
    private TXietongSuppliesApplyRecordMapper applyRecordMapper;
    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;
    @Autowired
    private TXietongSuppliesRepositoryMapper repositoryMapper;
    @Autowired
   private TXietongSuppliesMapper suppliesMapper;
    @Autowired
    private TXietongSuppliesCategoryMapper categoryMapper;
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 10000)
    @Override
    public int addBanGong(TXietongSupplies supplies) {
        return bangongmanagerdao.addBanGong(supplies);
    }
    @Override
    public int getCount(String content,String category) {
        return bangongmanagerdao.getCount(content,category);
    }

    @Override
    public List<TXietongSupplies> getSupplies(String content,String category, Integer rowNum, Integer pageCount) {
        return bangongmanagerdao.getSupplies(content,category,rowNum,pageCount);
    }

    @Override
    public List<TXietongSupplies> getSupplies1(String content, String category, Integer rowNum, Integer pageCount) {
        return bangongmanagerdao.getSupplies1(content,category,rowNum,pageCount);
    }

    @Override
    public TXietongSuppliesApplyRecord queryBanGongXiangqing1(String id, String repositoryId1) {
        return applyRecordMapper.queryBanGongXiangqing1(id,repositoryId1);
    }

    @Override
    public int querySupplyByName(String supplyName, String supplyType) {
        return bangongmanagerdao.querySupplyByName(supplyName,supplyType);
    }

    @Override
    public List<TXietongSuppliesApply> queryAll(Integer rowNum, Integer pageCount) {
        return applyMapper.queryAll(rowNum,pageCount);
    }

    @Override
    public int getCountAll() {
        return applyMapper.queryCountAll();
    }

    @Override
    public TXietongSuppliesCategory queryCategoryClass(String category) {
        return categoryMapper.queryCategoryClass(category);

    }

    @Override
    public TXietongSuppliesRepository queryRepository(String name) {
        return repositoryMapper.queryRepository(name);
    }

    @Override
    public int insertCategory(String categoryid2, String category) {
        return categoryMapper.insertCategory(categoryid2,category);
    }

    @Override
    public int insertSupply(String name, String categoryid2) {
      return   repositoryMapper.insertSupply(name,categoryid2);
    }

    @Override
    public int queryNameId(String name, String categoryid2) {
        return repositoryMapper.queryNameId(name,categoryid2);
    }

    @Override
    public int insertType(String type, int typeId) {
        return  repositoryMapper.insertType(type,typeId);
    }

    @Override
    public int updateRepository(String name, String categoryid2) {
       return   repositoryMapper.updateRepository(name,categoryid2);
    }

    @Override
    public int queryRepositoryType(String type,Integer typeId) {
        return repositoryMapper.queryRepositoryType(type,typeId);
    }

    @Override
    public int getCount1(String content, String category) {
        return bangongmanagerdao.getCount1(content,category);
    }

    @Override
    public List<TXietongSuppliesApplyRecord> queryApplyRecords(String ownerId,String id) {
        return applyRecordMapper.queryApplyRecords(ownerId,id);
    }

    @Override
    public Long queryCaiGouYuanId() {
        return dictionaryMapper.queryCaiGouYuanId();
    }

    @Override
    public int updateSypplyApply(TXietongSuppliesApply suppliesApply) {
        return applyMapper.updateSypplyApply(suppliesApply);
    }

    @Override
    public List<TXietongSuppliesApply> queryApplying2(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount) {
        return applyMapper.queryApplying2(supplyName,applyName,ownerId,rowNum,pageCount);
    }

    @Override
    public int getApplyCount2(String supplyName, String applyName, String ownerId) {
        return applyMapper.getApplyCount2(supplyName,applyName,ownerId);
    }

    @Override
    public int updateOfficerRecord(TXietongSuppliesApplyRecord record) {
        return applyRecordMapper.updateOfficerRecord(record);
    }

    @Override
    public List<TXietongSuppliesApply> queryApplyingDaiBan2(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount) {
        return applyMapper.queryApplyingDaiBan2(supplyName,applyName,ownerId,rowNum,pageCount);
    }

    @Override
    public int getApplyCountDaiBan2(String supplyName, String applyName, String ownerId) {
        return applyMapper.getApplyCountDaiBan2(supplyName,applyName,ownerId);
    }

    @Override
    public List<TXietongSuppliesApplyRecord> querySupplyApplyRecord(String ownerId) {
        return applyRecordMapper.querySupplyApplyRecord(ownerId);
    }

    @Override
    public List<TXietongSuppliesApplyRecord> querySupplyApplyRecord2(String ownerId, Integer rowNum, Integer pageCount) {
        return applyRecordMapper.querySupplyApplyRecord2(ownerId,rowNum,pageCount);
    }

    @Override
    public int updateBanGongshiStatus(String id, String nextPeopleId) {
        return applyRecordMapper.updateBanGongshiStatus(id,nextPeopleId);
    }

    @Override
    public TXietongSuppliesApply print(String id) {
        return applyMapper.print(id);
    }

    @Override
    public int queryStatus(String id, String ownerId) {
        return applyRecordMapper.queryStatus(id,ownerId);
    }

    @Override
    public int selectCountAll(String supplyName, String applyName, String ownerId) {
        return applyMapper.selectCountAll(supplyName,applyName,ownerId);
    }

    @Override
    public List<TXietongSuppliesApply> selectAll(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount) {
        return applyMapper.selectAll(supplyName,applyName,ownerId,rowNum,pageCount);
    }

    @Override
    public List<TXietongSuppliesApply> selectAllDaiBan(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount) {
        return applyMapper.selectAllDaiBan(supplyName,applyName,ownerId,rowNum,pageCount);
    }

    @Override
    public int selectCountAllDaiBan(String supplyName, String applyName, String ownerId) {
        return applyMapper.selectCountAllDaiBan(supplyName,applyName,ownerId);
    }

    @Override
    public int updateApplyStatus(String id, String applyId) {
        return applyRecordMapper.updateApplyStatus(id,applyId);
    }

    @Override
    public String queryRecordCaiGouId(String id, String caigouyuanId) {
        return  applyRecordMapper.queryRecordCaiGouId(id,caigouyuanId);
    }

    @Override
    public List<TXietongSuppliesCategory> querySupplyCategories() {
        return bangongmanagerdao.querySupplyCategories();
    }

    @Override
    public List<Integer> queryAttribute(String name, String type) {
        return bangongmanagerdao.queryAttribute(name,type);
    }

    @Override
    public int updateSupplies1(int newStock, String supplyName, String supplyType) {
        return bangongmanagerdao.updateSupplies1(newStock,supplyName,supplyType);
    }

    @Override
    public List<String> queryAttributeFromApply(String supplyName, String supplyType) {
        return applyMapper.queryAttributeFromApply(supplyName,supplyType);
    }

    @Override
    public int queryCategorySupply(String id, String name) {
        return repositoryMapper.queryCategorySupply(id,name);
    }


    @Override
    public int updateBanGong(TXietongSupplies supplies) {
        return bangongmanagerdao.updateBanGong(supplies);
    }

    @Override
    public int getRecordCount(String supplyName, String receiptorName) {
        return supplyRecordMapper.getRecordCount(supplyName,receiptorName);
    }

    @Override
    public List<TXietongSupplyRecord> getSupplyRecord(String supplyId, String supplyType) {
        return supplyRecordMapper.getSupplyRecordList(supplyId,supplyType);
    }

    @Override
    public int addRecords(TXietongSupplyRecord record) {
        return supplyRecordMapper.addRecords(record);
    }

    @Override
    public int addSuppliedApply(TXietongSuppliesApply suppliesApply) {
        return applyMapper.addSuppliedApply(suppliesApply);
    }

    @Override
    public int addApplyRecords(TXietongSuppliesApplyRecord applyRecord) {
        return applyRecordMapper.addApplyRecords(applyRecord);
    }

    @Override
    public int getApplyCount(String supplyName, String applyName,String ID) {
        return applyMapper.getApplyCount(supplyName,applyName,ID);
    }

    @Override
    public TXietongSuppliesApply queryApplying(String supplyName, String applyName,String ID, Integer rowNum, Integer pageCount) {
        return applyMapper.queryApplying(supplyName,applyName, ID,rowNum,pageCount);
    }

    @Override
    public int updateapplyRecord(TXietongSuppliesApplyRecord applyRecords) {
        return applyRecordMapper.updateapplyRecord(applyRecords);
    }

    @Override
    public int getSupplyApplyingCount(String ownerId) {
        return applyMapper.getSupplyApplyingCount(ownerId);
    }

    @Override
    public List<TXietongSuppliesApply> querySupplyApplyingList(String ownerId,String bangongId1,Integer rowNum, Integer pageCount) {
        return applyMapper.querySupplyApplyingList(ownerId,bangongId1,rowNum,pageCount);
    }
    //查询审批详情
    @Override
    public List<TXietongSuppliesApplyRecord> queryhandleDetails(String id) {
        return applyRecordMapper.queryhandleDetails(id);
    }

    @Override
    public int consoleApplying(String id) {
        return applyMapper.consoleApplying(id) ;
    }

    @Override
    public int updateSuppliesApply(String id) {
        return applyMapper.updateSuppliesApply(id);
    }

    @Override
    public int addSupplyRecord(TXietongSupplyRecord supplyRecord) {
        return supplyRecordMapper.addSupplyRecord(supplyRecord);
    }

    @Override
    public int queryStock(String supplyName, String supplyType) {
        return bangongmanagerdao.queryStock(supplyName,supplyType);
    }

    @Override
    public int updateSupplies(int newStcok,String supplyName,String supplyType,Integer attribute) {
        return bangongmanagerdao.updateSupplies(newStcok,supplyName,supplyType,attribute);
    }

    @Override
    public List<TXietongSuppliesRepository> querySupplyName(String categoryId) {
        return repositoryMapper.querySupplyName(categoryId);
    }

    @Override
    public List<TXietongSuppliesRepository> querySupplyType(Integer id) {
        return repositoryMapper.querySupplyType(id);
    }

    @Override
    public List<TXietongDictionary> queryApplyPeople() {
        return dictionaryMapper.queryApplyPeople();
    }

    @Override
    public int deleteSupplyApplyRecords(String id) {
        return applyRecordMapper.deleteSupplyApplyRecords(id);
    }

    @Override
    public TXietongSuppliesApply queryApplyById(String id) {
        return applyMapper.queryApplyById(id);
    }

    @Override
    public int insertHisApply(TXietongSuppliesApply suppliesApply) {
        return applyMapper.insertHisApply(suppliesApply);
    }

    @Override
    public int deleteApplyById(String id) {
        return applyMapper.deleteApplyById(id);
    }

    @Override
    public int addBanGongName(String supplyName,String categoryId) {
        return repositoryMapper.addBanGongName(supplyName,categoryId);
    }

    @Override
    public int addBanGongType(String type,Integer id) {
        return repositoryMapper.addBanGongType(type,id);
    }

    @Override
    public int queryChongFu(String categoryId,String supplyName) {
        return repositoryMapper.queryChongFu(categoryId,supplyName);
    }

    @Override
    public int addToRepository(TXietongSuppliesApplyRecord toRepository) {
        return applyRecordMapper.addToRepository(toRepository);
    }

    @Override
    public int queryResultCount(String ownerId, String supplyName, String applyName) {
        return applyMapper.queryResultCount(ownerId,supplyName,applyName);
    }
    @Override
    public int queryResultCountDaiBan(String ownerId, String supplyName, String supplyType) {
        return applyMapper.queryResultCountDaiBan(ownerId,supplyName,supplyType);
    }


    @Override
    public List<TXietongSuppliesApply> queryResult(String ownerId, String supplyName, String applyName, Integer rownum,Integer pagecount) {
        return applyMapper.queryResult(ownerId,supplyName,applyName,rownum,pagecount);
    }

    @Override
    public int queryChongFuType(String type) {
        return repositoryMapper.queryChongFuType(type);
    }

    @Override
    public int deleteRepository(String id) {
        return bangongmanagerdao.deleteRepository(id);
    }

    @Override
    public int updateOfficer(String id,String nameId ,String name) {
        return dictionaryMapper.updateOfficer(id,nameId,name);
    }

    @Override
    public TXietongDictionary queryOfficer(String id) {
        return dictionaryMapper.queryOfficer(id);
    }

    @Override
    public TXietongSupplies querySupplysById(String id) {
        return bangongmanagerdao.querySupplysById(id);
    }

    @Override
    public int deleteSupplyRecord(String name, String type) {
        return supplyRecordMapper.deleteSupplyRecord(name,type);
    }

    @Override
    public int deleteName(Integer id) {
        return repositoryMapper.deleteName(id);
    }

    @Override
    public int deleteType(Integer id) {
        return repositoryMapper.deleteType(id);
    }

    @Override
    public TXietongSuppliesApplyRecord queryBanGongXiangqing(String id, String ownerId) {
        return applyRecordMapper.queryBanGongXiangqing(id,ownerId);
    }

    @Override
    public Integer queryPucharseStatus(String id, String pucharseId) {
        return applyRecordMapper.queryPucharseStatus(id,pucharseId);
    }

    @Override
    public long queryPucharseId() {
        return dictionaryMapper.queryPucharseId();
    }

    @Override
    public List<TXietongSuppliesApply> querySupplyApplyingRepository(String ownerId, Integer rowNum, Integer pageCount) {
        return applyMapper.querySupplyApplyingRepository(ownerId,rowNum,pageCount);
    }

    @Override
    public int updateapplyRecordCaiGouYuan(TXietongSuppliesApplyRecord applyRecords) {
        return applyRecordMapper.updateapplyRecordCaiGouYuan(applyRecords);
    }

    @Override
    public Long queryBanGongId() {
        return dictionaryMapper.queryBanGongId();
    }

    @Override
    public int updateSupplyStatus(TXietongSuppliesApply suppliesApply) {
        return applyMapper.updateSupplyStatus(suppliesApply);
    }

    @Override
    public int updatePstatus(TXietongSuppliesApply suppliesApply) {
        return applyMapper.updatePstatus(suppliesApply);
    }

    @Override
    public int updateBnGongshiStatus(String applyId,String bstatus) {
        return applyMapper.updateBnGongshiStatus(applyId,bstatus);
    }

    @Override
    public int updateRepositoryStatus(String id, String rstatus) {
        return applyMapper.updateRepositoryStatus(id,rstatus);
    }

    @Override
    public List<TXietongSuppliesApply> queryCaiGouList(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount) {
        return applyMapper.queryCaiGouList(supplyName,applyName, ownerId,rowNum,pageCount);
    }

    @Override
    public int getCaiGouCount(String supplyName, String applyName, String ownerId) {
        return applyMapper.getCaiGouCount(supplyName,applyName,ownerId);
    }

    @Override
    public int getCaiGouCountDaiBan(String supplyName, String applyName, String ownerId) {
        return applyMapper.getCaiGouCountDaiBan(supplyName,applyName,ownerId);
    }


    @Override
    public int updateapplyRecord1(TXietongSuppliesApplyRecord applyRecords) {
        return applyRecordMapper.updateapplyRecord1(applyRecords);
    }

    @Override
    public List<TXietongSuppliesApply> queryApplying1(String supplyName, String applyName, String ownerId) {
        return applyMapper.queryApplying1(supplyName,applyName, ownerId);
    }

    @Override
    public int querySupply(String supplyName, String supplyType) {
        return bangongmanagerdao.querySupply(supplyName,supplyType);
    }
    @Override
    public String querySupplyId(String category,String nameid, String type) {
        return bangongmanagerdao.querySupplyId(category,nameid,type);
    }

    @Override
    public Integer queryOpinion(String id,String bangongshiId) {
        return applyRecordMapper.queryOpinion(id,bangongshiId);
    }

    @Override
    public int getSupplyApplyingCount1(String ownerId) {
        return applyMapper.getSupplyApplyingCount1(ownerId);
    }

    @Override
    public String queryRecordId(String applyId, String ownerId) {
        return applyRecordMapper.queryRecordId(applyId,ownerId);
    }

    @Override
    public String queryRequestType(String applyId) {
        return applyMapper.queryRequestType(applyId);
    }

    @Override
    public Long queryRepositoryId() {
        return dictionaryMapper.queryRepositoryId();
    }

    @Override
    public TXietongSuppliesApply     queryApplyingDaiBan(String supplyName, String applyName, String ID, Integer rowNum, Integer pageCount) {
        return applyMapper.queryApplyingDaiBan(supplyName,applyName, ID,rowNum,pageCount);
    }

    @Override
    public List<TXietongSuppliesApply> queryResultDaiBan(String ownerId, String supplyName, String applyName, Integer rowNum, Integer pageCount) {
        return  applyMapper.queryResultDaiBan(ownerId,supplyName,applyName,rowNum,pageCount);
    }

    @Override
    public List<TXietongSuppliesApply> queryCaiGouListDaiBan(String supplyName, String applyName, String ownerId, Integer rowNum, Integer pageCount) {
        return applyMapper.queryCaiGouListDaiBan(supplyName,applyName, ownerId,rowNum,pageCount);
    }

    @Override
    public int updateapplyRecordById(String id) {
        return applyRecordMapper.updateapplyRecordById(id);
    }

    @Override
    public String queryRecordIdBanGong(String applyId, String ownerId) {
          return applyRecordMapper.queryRecordIdBanGong(applyId,ownerId);
    }

    @Override
    public List<TXietongSupplyRecord> queryAllSupplyNames() {
        return supplyRecordMapper.queryAllSupplyNames();
    }

    @Override
    public List<TXietongSupplyRecord> querySupplyRecord(String supplyName, String departName, String ym) {
        return supplyRecordMapper.querySupplyRecord(supplyName,departName,ym);
    }

    @Override
    public List<TXietongSupplyRecord> queryAllDepartNames() {
        return  supplyRecordMapper.queryAllDepartNames();
    }

    @Override
    public Double queryPrice(String supplyName, String supplyType) {
        return  bangongmanagerdao.queryPrice(supplyName,supplyType);
    }

    @Override
    public List<String> querySupplyYears() {
     return  supplyRecordMapper.querySupplyYears();
    }

    @Override
    public int getApplyCountDaiBan(String supplyName, String applyName, String ownerId) {
        return applyMapper.getApplyCountDaiBan(supplyName,applyName,ownerId);
    }
    @Override
    public int queryCategory(String category) {
        return categoryMapper.queryCategory(category);
    }

    @Override
    public int addCategory(String id,String category) {
        return categoryMapper.addCategory(id,category);
    }

    @Override
    public List<TXietongSuppliesCategory> queryCategories() {
        return categoryMapper.queryCategories();
    }

    @Override
    public int deleteCategory(String  id) {
        return categoryMapper.deleteCategory(id);
    }






    /*@Override
    public int updateSupplyRecords(String id) {
        return applyRecordMapper.updateSupplyRecords(id);
    }*/


}
