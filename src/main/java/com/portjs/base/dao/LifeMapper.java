package com.portjs.base.dao;

import com.portjs.base.entity.Life;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LifeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Life record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    int insertSelective(Life record);
    /**
     * 条件查询
     * @param record
     * @return
     */
    List<Life> selectByPrimaryKey(Life record);

    int updateByPrimaryKeySelective(Life record);
    /**
     * id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Life record);
    /**
     * 分组查询
     * @return
     */
    List<Life> sumLine();

    /**
     * 查询在建项目id
     * @return
     */
    List<Life> sumLines();

    /**
     * 在建项目的projectId
     * @return
     */
    List<String> selectProjectId();
}