package com.portjs.base.service;

import com.portjs.base.entity.InternalPact;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InternalPactService {

    /**
     * 根据项目id去合同表查询相关合同信息
     * @param id  项目id
     * @param pageNo
     * @param pageSize
     * @return （String name,String signState,String involvedUnit,String tradeNames）
     */
   ResponseMessage queryAllPacts(String id, int pageNo,int pageSize);

    /**
     * 添加合同信息
     * @param record
     * @return
     */
    ResponseMessage insertSelective(InternalPact record);

    /**
     * 根据id删除合同信息
     * @param id
     * @return
     */
    ResponseMessage deleteByPrimaryKey( List<String> id);

    /**
     * 根据id查询合同信息
     * @param id
     * @return
     */
    ResponseMessage selectByPrimaryKey(String id);

    /**
     * 根据id修改合同信息
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(InternalPact record);
}
