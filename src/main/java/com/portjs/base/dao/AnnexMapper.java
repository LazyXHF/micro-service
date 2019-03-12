package com.portjs.base.dao;

import com.portjs.base.entity.Annex;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnnexMapper {
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
    int insert(Annex record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    int insertSelective(Annex record);
    /**
     * 根据annex，条件查询
     * @param record
     * @return
     */
    List<Annex> selectByPrimaryKey(Annex record);
    /**
     * 条件更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Annex record);
    /**
     * 更新所有
     * @param record
     * @return
     */
    int updateByPrimaryKey(Annex record);
}