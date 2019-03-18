package com.portjs.base.dao;

import com.portjs.base.entity.Design;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignMapper {
    /**
     * 删除 支持多条删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(@Param("id") List<String> id);

    /**
     * 批量更新 软删除
     * @param id
     * @return
     */
    int updateDesign(@Param("id") List<String> id);


    /**
     *  插入
     * @param record
     * @return
     */
    int insert(Design record);

    /**
     * 条件插入
     * @param record
     * @return
     */
    int insertSelective(Design record);

    /**
     * 根据record条件查询
     * @param record
     * @return
     */
    List<Design> selectByPrimaryKey(Design record);
    /**
     * 全更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Design record);
    /**
     * id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Design record);
}