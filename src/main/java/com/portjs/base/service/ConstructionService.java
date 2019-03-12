package com.portjs.base.service;

import com.portjs.base.entity.Construction;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Repository;

public interface ConstructionService {
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
    ResponseMessage insert(Construction record);
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