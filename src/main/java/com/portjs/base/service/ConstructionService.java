package com.portjs.base.service;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.entity.Construction;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ConstructionService {
    /**
     * 删除 支持多条删除
     * @param id
     * @return
     */
    ResponseMessage deleteByPrimaryKey(List<String> id);
    /**
     *  插入
     * @param record
     * @return
     * TODO
     */
    ResponseMessage insert(Construction record);
    /**
     * 条件插入
     * @param requestJson
     * @return
     */
    ResponseMessage insertSelective(JSONObject requestJson);
    /**
     * 根据record条件查询
     * @param record
     * @return
     */
    ResponseMessage selectByPrimaryKey(Construction record);

    /**
     * 条件更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(Construction record);

    /**
     * 全更新
     * @param record
     * @return
     * TODO
     */
    ResponseMessage updateByPrimaryKeyWithBLOBs(Construction record);
    /**
     * id更新
     * @param record
     * @return
     * TODO
     */
    ResponseMessage updateByPrimaryKey(Construction record);
}