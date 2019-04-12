package com.portjs.base.dao;

import com.portjs.base.entity.TXietongDictionary;
import com.portjs.base.entity.TXietongDictionaryExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface TXietongDictionaryMapper {
    int countByExample(TXietongDictionaryExample example);

    int deleteByExample(TXietongDictionaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongDictionary record);

    int insertSelective(TXietongDictionary record);

    List<TXietongDictionary> selectByExample(TXietongDictionaryExample example);

    TXietongDictionary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongDictionary record, @Param("example") TXietongDictionaryExample example);

    int updateByExample(@Param("record") TXietongDictionary record, @Param("example") TXietongDictionaryExample example);

    int updateByPrimaryKeySelective(TXietongDictionary record);

    int updateByPrimaryKey(TXietongDictionary record);

    List<TXietongDictionary> selectTpyeXiala();

    List<TXietongDictionary> selectJinjiXiala();

    List<TXietongDictionary> selectDictionaryType();

    //这是固定资产管理查询所有类型的方法
    List<String> queryLeixing();

    // 办公用品名称下拉框
    List querySupplyName();

    List<TXietongDictionary> querySupplyType(@Param("id") String id);

    List<TXietongDictionary> queryApplyPeople();

    //机要员的信息获取
    List<TXietongDictionary> selectjiyaoMsg(@Param("mid_value") String mid_value);

    List<TXietongDictionary> selectalljiyaoMsg();

    int updateOfficer(@Param("id") String id, @Param("name") String name);

    //查询督办员
    TXietongDictionary selectDubanyuan();

    int updateDubanyuan(@Param("mainValue") String mainValue, @Param("midValue") String midValue);

    int insertDuban(TXietongDictionary dictionary);

    int updateOfficer(@Param("id") String id, @Param("nameId") String nameId, @Param("name") String name);

    TXietongDictionary queryOfficer(@Param("id") String id);

    //插入机要员信息
    int insertJiyaoyuan(TXietongDictionary dictionary);

    //修改机要信息
    int updateJiyaoyuan(TXietongDictionary dictionary);

    //收文部委领导配置
    int insertReceivingLeader(TXietongDictionary dictionary);

    //删除机要员重新插入
    int deleteJiyaoMsg();

    //分页查询字典表
    List<TXietongDictionary> selectByPage(@Param("code") String code, @Param("rowNum") int rowNum, @Param("pageCount") int pageCount);

    //添加督办员
    int insertDubanyuan(TXietongDictionary dictionary);

    //删除督办员
    int deletedubanyuan();

    //查询采购员id
    long queryPucharseId();

    long queryRepositoryId();

    Long queryBanGongId();

    List<TXietongDictionary> selectDubanzhonglei();

    int insertDubanzhonglei(TXietongDictionary dictionary);

    //查询会议室审核人
    TXietongDictionary selectConferenceRoom();


    List<TXietongDictionary> selectNiandu();

    int insertNiandu(TXietongDictionary dictionary);

    //
    int deleteReceivingLeader(@Param("typeCode") String typeCode);

    //用车审核员
    TXietongDictionary selectPaicheyuan();


    Long queryCaiGouYuanId();

    TXietongDictionary selectgongwuyuan();

/**
 * TODO   分割线===========================================================================================================================================================
 */


    /**
     * 查询人员配置信息
     * @return
     */
    List<TXietongDictionary> queryPersionModelInfo();

    /**
     * 添加人员配置信息
     * @param dictionary
     * @return
     */
    int insertPersionModelInfo(TXietongDictionary dictionary);

    /**
     * 修改人员配置信息
     * @param dictionary
     * @return
     */
    int updatePersionModelInfo(TXietongDictionary dictionary);

    /**
     * 删除人员配置信息
     * @param dictionary
     * @return
     */
    int deletePersionModelInfo(TXietongDictionary dictionary);

/**
 * TODO   分割线===========================================================================================================================================================
 */

    /**
     * 查询资源配置信息
     * @return
     */
    List<TXietongDictionary> queryResourceModelInfo();

    /**
     * 添加资源配置信息
     * @param dictionary
     * @return
     */
    int insertResourceModelInfo(TXietongDictionary dictionary);

    /**
     * 修改资源配置信息
     * @param dictionary
     * @return
     */
    int updateResourceModelInfo(TXietongDictionary dictionary);

    /**
     * 删除资源配置信息
     * @param dictionary
     * @return
     */
    int deleteResourceModelInfo(TXietongDictionary dictionary);


    @Update("UPDATE t_xietong_dictionary SET MAIN_VALUE=#{name} WHERE MID_VALUE = #{id}")
    int updateMAINByMID(@Param("name")String name,@Param("id")String id);
}