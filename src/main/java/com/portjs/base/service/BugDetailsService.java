package com.portjs.base.service;

import com.portjs.base.entity.BugDetails;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BugDetailsService {

    ResponseMessage deleteByPrimaryKey(List<String> ids);

    //int insert(BugDetails record);

    /**
     * 新增bug页面接口
     * @param record
     * @return
     */
    ResponseMessage insertSelective(BugDetails record);

    /**
     * 根据自身id查询Bug信息
     * @param id
     * @return
     */
    ResponseMessage selectByPrimaryKey(String id);

    ResponseMessage updateByPrimaryKeySelective(BugDetails record);

    /**
     * bug分页列表
     * @param requestBody
     * @return
     */
    ResponseMessage queryAllBugInfo(String requestBody);

    ResponseMessage queryAllBugInfos();

    //int updateByPrimaryKeyWithBLOBs(BugDetails record);

    //int updateByPrimaryKey(BugDetails record);

}
