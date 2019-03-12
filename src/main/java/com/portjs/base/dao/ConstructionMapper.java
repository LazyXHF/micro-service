package com.portjs.base.dao;

import com.portjs.base.entity.Construction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructionMapper {
    /**
     * 删除 支持多条删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     *  插入
     * @param record
     * @return
     */
    int insert(Construction record);

    /**
     * 条件插入
     * @param record
     * @return
     */
    int insertSelective(Construction record);

    /**
     * 根据record条件查询
     * @param record
     * @return
     */
    List<Construction> selectByPrimaryKey(Construction record);

    /**
     * 条件更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Construction record);

    /**
     * 全更新
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Construction record);

    /**
     * id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Construction record);
}