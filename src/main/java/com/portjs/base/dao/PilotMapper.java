package com.portjs.base.dao;

import com.portjs.base.entity.Pilot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotMapper {
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
    int insert(Pilot record);

    /**
     * 条件插入
     * @param record
     * @return
     */
    int insertSelective(Pilot record);
    /**
     * 根据record条件查询
     * @param record
     * @return
     */
    List<Pilot> selectByPrimaryKey(Pilot record);
    /**
     * 全更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Pilot record);
    /**
     * id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Pilot record);
}