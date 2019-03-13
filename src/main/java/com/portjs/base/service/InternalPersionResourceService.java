package com.portjs.base.service;

import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Service;

@Service
public interface InternalPersionResourceService {

    /**
     * 添加人员信息
     * @param record
     * @return
     */
    ResponseMessage insertPersionInfo(InternalPersionResource record);

    /**
     * 根据id查询人员信息
     * @param id
     * @return
     */
    ResponseMessage selectByPrimaryKey(String id);
    /**
     * 更新人员信息
     * @param record
     * @return
     */
    ResponseMessage updatePersionInfo(InternalPersionResource record);

    /**
     * 根据id删除人员信息
     * @param id
     * @return
     */
    ResponseMessage deleteByPrimaryKey(String id);

}
