package com.portjs.base.dao;

import com.portjs.base.entity.Acceptance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcceptanceMapper {
    /**
     * 根据id删除，可多条删除
     * @param ids
     * @return
     */
    int deleteByPrimaryKey(String[] ids);
    /**
     * 插入
     * @param record
     * @return
     */
    int insert(Acceptance record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    int insertSelective(Acceptance record);
    /**
     * 根据annex，条件查询
     * @param record
     * @return
     */
    List<Acceptance> selectByPrimaryKey(Acceptance record);
    /**
     * 条件更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Acceptance record);
    /**
     * 更新所有
     * @param record
     * @return
     */
    int updateByPrimaryKey(Acceptance record);
}