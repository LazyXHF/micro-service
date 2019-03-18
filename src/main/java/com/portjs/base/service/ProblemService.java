package com.portjs.base.service;

import com.portjs.base.entity.Problem;
import com.portjs.base.util.ResponseMessage;

import java.util.List;

public interface ProblemService {
    ResponseMessage deleteByPrimaryKey(List<String> record);
    /**
     *  插入
     * @param record
     * @return
     */
    ResponseMessage insert(Problem record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    ResponseMessage insertSelective(Problem record);
    /**
     * 根据record条件查询
     * @param record
     * @return
     */
    ResponseMessage selectByPrimaryKey(Problem record);
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