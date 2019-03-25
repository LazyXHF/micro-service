package com.portjs.base.service;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.entity.Design;
import com.portjs.base.util.ResponseMessage;

import java.util.List;

public interface DesignService {
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
    ResponseMessage insert(Design record);
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
    ResponseMessage selectByPrimaryKey(Design record);
    /**
     * 条件更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(Design record);
    /**
     * 全更新
     * @param record
     * @return
     * TODO
     */
    ResponseMessage updateByPrimaryKey(Design record);
}