package com.portjs.base.dao;

import com.portjs.base.entity.TUser;
import com.portjs.base.entity.TXietongUserMinisterRelation;
import com.portjs.base.entity.TXietongUserMinisterRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TXietongUserMinisterRelationMapper {
    int countByExample(TXietongUserMinisterRelationExample example);

    int deleteByExample(TXietongUserMinisterRelationExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongUserMinisterRelation record);

    int insertSelective(TXietongUserMinisterRelation record);

    List<TXietongUserMinisterRelation> selectByExample(TXietongUserMinisterRelationExample example);

    TXietongUserMinisterRelation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongUserMinisterRelation record, @Param("example") TXietongUserMinisterRelationExample example);

    int updateByExample(@Param("record") TXietongUserMinisterRelation record, @Param("example") TXietongUserMinisterRelationExample example);

    int updateByPrimaryKeySelective(TXietongUserMinisterRelation record);

    int updateByPrimaryKey(TXietongUserMinisterRelation record);

    List<TUser> selectAll();
}