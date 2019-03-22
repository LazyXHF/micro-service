package com.portjs.base.service;

import com.alibaba.fastjson.JSONArray;
import com.portjs.base.entity.Problem;
import com.portjs.base.util.ResponseMessage;

import java.util.List;

public interface ProblemService {
    /**
     * 单条插入
     * @param record
     * @return
     */
    ResponseMessage insertProblem(Problem record);

    /**
     * 软删除
     * @param record
     * @return
     */
    ResponseMessage deleteByPrimaryKey(List<String> record);
    /**
     *  插入
     * @param record
     * @return
     */
    ResponseMessage insert(Problem record);
    /**
     * 条件插入
     * @param data
     * @return
     */
    ResponseMessage insertSelective(JSONArray data);
    /**
     * 根据record条件查询
     * @param responseBody
     * @return
     */
    ResponseMessage selectByPrimaryKey(String responseBody);
    /**
     * 全更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(Problem record);
    /**
     * id更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKey(Problem record);
}