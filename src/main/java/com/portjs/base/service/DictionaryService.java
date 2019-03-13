package com.portjs.base.service;

import com.portjs.base.entity.TXietongDictionary;
import com.portjs.base.util.ResponseMessage;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DictionaryService {
    List<TXietongDictionary> selectTpyeXiala();

    List<TXietongDictionary> selectJinjiXiala();

    List<TXietongDictionary> selectDictionary(String code);

    ResponseMessage updateDictionary(String request);

    ResponseMessage insertDictionaryType(String request);

    ResponseMessage selectDictionaryType();

    ResponseMessage insertDictionary(String request);

    ResponseMessage deleteDictionary(String request);

    ResponseMessage selectAll(String request);

    TXietongDictionary selectDubanyuan();

    int updateDubanyuan(String requestBody);

    ResponseMessage insertDuban(String requestBody);

    //插入机要员的信息
    int insertJiyaoyuan(String requestBody);

    //查询所有机要员
    List<TXietongDictionary> selectJiyaoyuan();

    //修改机要员信息
    int updateJiyaoyuan(String requestBody);
    
    //修改部委领导信息
    ResponseMessage updateReceivingLeader(String requestBody);

    ResponseMessage insertInsertType(String requestBody);


    ResponseMessage updateInsertType(String requestBody);

    List<TXietongDictionary> selectDubanzhonmglei();

    ResponseMessage insertDubanzhonglei(String requestBody);


    //查询公务接待审批人
    ResponseMessage selectReceptionManager();

    //修改公务接待审批人
    ResponseMessage updateReceptionManager(TXietongDictionary dictionary);

    //会议室审核人查询
    ResponseMessage selectDictionaryByType();
  

    //查询办公室核稿人
    ResponseMessage selectOfficePeople();


    ResponseMessage selectNiandu();

    ResponseMessage insertNiandu(String requestBody);

    //固定资产统一配置回显
	ResponseMessage selectPeopleGd(String requestBody);

	//固定资产统一配置人员
	ResponseMessage updatePeopleGd(String requestBody);






	//统一模板配置
	ResponseMessage selectTypeCodeModelByCodeId(String codeId);

    //查询发文中的配置项
	ResponseMessage selectDispatchTypeByTypeId(String requestBody);
    //统一配置
	ResponseMessage updateDictionaryByCodeAndId(String requestBody);
    
	
}
