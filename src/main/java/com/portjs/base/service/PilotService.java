package com.portjs.base.service;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.entity.Pilot;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PilotService {
    /**
     * 删除 支持多条删除
     * @param id
     * @return
     * TODO
     */
    ResponseMessage deleteByPrimaryKey(List<String> id);
    /**
     *  插入
     * @param record
     * @return
     * TODO
     */
    ResponseMessage insert(Pilot record);

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
    ResponseMessage selectByPrimaryKey(Pilot record);
    /**
     * 全更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(Pilot record);
    /**
     * id更新
     * @param record
     * @return
     * TODO
     */
    ResponseMessage updateByPrimaryKey(Pilot record);
}