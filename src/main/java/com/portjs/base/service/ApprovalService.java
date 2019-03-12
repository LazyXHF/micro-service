package com.portjs.base.service;

import com.portjs.base.entity.Approval;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ApprovalService {
    /**
     * 删除 支持多条删除
     * @param id
     * @return
     * TODO
     */
    ResponseMessage deleteByPrimaryKey(String id);
    /**
     *  插入
     * @param record
     * @return
     * TODO
     */
    ResponseMessage insert(Approval record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    ResponseMessage insertSelective(String record);
    /**
     * 根据record条件查询
     * @param record
     * @return
     */
    ResponseMessage selectByPrimaryKey(Approval record);
    /**
     * 条件更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(Approval record);
    /**
     * 全更新
     * @param record
     * @return
     * TODO
     */
    ResponseMessage updateByPrimaryKeyWithBLOBs(Approval record);
    /**
     * id更新
     * @param record
     * @return
     * TODO
     */
    ResponseMessage updateByPrimaryKey(Approval record);
}