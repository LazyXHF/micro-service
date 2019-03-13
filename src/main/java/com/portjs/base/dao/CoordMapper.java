package com.portjs.base.dao;

import com.portjs.base.entity.Coord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoordMapper {
    /**
     * 多条删除，支持单条删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(@Param("id") List<String> id);
    /**
     * 插入
     * @param record
     * @return
     */
    int insert(Coord record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    int insertSelective(Coord record);
    /**
     * record，条件查询
     * @param record
     * @return
     */
    List<Coord> selectByPrimaryKey(Coord record);
    /**
     * 条件更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Coord record);
    /**
     * 全更新
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Coord record);
    /**
     * id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Coord record);
}