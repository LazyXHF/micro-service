package com.portjs.base.service;

import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * 批量删除人员信息
     * @param ids
     * @return
     */
    ResponseMessage updatePersionInfoByIds(List<String> ids);

    /**
     * 根据项目id获取人员信息
     * @return
     */
    ResponseMessage queryAllPersionInfo(String projectId ,int pageNo,int pageSize);

    /**
     * 根据id删除人员信息
     * @param id
     * @return
     */
    ResponseMessage deleteByPrimaryKey(String id);

}
