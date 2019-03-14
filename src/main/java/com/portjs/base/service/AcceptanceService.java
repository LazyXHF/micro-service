package com.portjs.base.service;

import com.portjs.base.entity.Acceptance;
import com.portjs.base.util.ResponseMessage;

/**
 * @author gumingyang
 **/
public interface AcceptanceService {
    /**
     * 根据id删除，可多条删除
     * @param ids
     * @return
     */
    ResponseMessage deleteByPrimaryKey(String ids);
    /**
     * 插入
     * @param record
     * @return
     */
    ResponseMessage insert(Acceptance record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    ResponseMessage insertSelective(Acceptance record);
    /**
     * 根据annex，条件查询
     * @param record
     * @return
     */
    ResponseMessage selectByPrimaryKey(Acceptance record);
    /**
     * 条件更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(Acceptance record);
    /**
     * 更新所有
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKey(Acceptance record);
}
