package com.portjs.base.service;

import com.portjs.base.entity.ProjectClarificaiton;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectClarificaitonService {

    ResponseMessage insertSelective(ProjectClarificaiton record);

    ResponseMessage updateByPrimaryKeySelective(ProjectClarificaiton record);

    /**
     * 分页并模糊查询
     * @return responseBody
     */
    ResponseMessage queryByPage(String responseBody);

    /**
     * 批量软删除
     * @param ids
     * @return
     */
    ResponseMessage updateDeleteTimeByIds(List<String> ids);


}
