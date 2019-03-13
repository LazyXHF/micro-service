package com.portjs.base.dao;

import com.portjs.base.entity.InternalPersionResource;
import org.springframework.stereotype.Repository;


@Repository
public interface InternalPersionResourceMapper {
    int deleteByPrimaryKey(String id);

    /**
     * 添加人员信息
     * @param record
     * @return
     */
    int insertPersionInfo(InternalPersionResource record);

    int insertSelective(InternalPersionResource record);

    InternalPersionResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InternalPersionResource record);

    /**
     * 更新人员信息
     * @param record
     * @return
     */
    int updatePersionInfo(InternalPersionResource record);


}