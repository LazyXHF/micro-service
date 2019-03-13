package com.portjs.base.service;

import com.portjs.base.entity.InternalPact;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;

public interface InternalPactService {

    /**
     * 根据项目id去合同表查询相关合同信息
     * @param id  项目id
     * @param pageNo
     * @param pageSize
     * @return
     */
   ResponseMessage queryAllPacts(@Param("id") String id, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /**
     * 添加合同信息
     * @param record
     * @return
     */
    ResponseMessage insertPact(InternalPact record);

    /**
     * 根据id删除合同信息
     * @param id
     * @return
     */
    ResponseMessage deleteByPrimaryKey(String id);

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
    ResponseMessage updateByPrimaryKey(InternalPact record);
}
