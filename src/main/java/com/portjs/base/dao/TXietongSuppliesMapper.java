package com.portjs.base.dao;

import com.portjs.base.entity.TXietongSupplies;
import com.portjs.base.entity.TXietongSuppliesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TXietongSuppliesMapper {
    int countByExample(TXietongSuppliesExample example);

    int deleteByExample(TXietongSuppliesExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongSupplies record);

    int insertSelective(TXietongSupplies record);

    List<TXietongSupplies> selectByExample(TXietongSuppliesExample example);

    TXietongSupplies selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongSupplies record, @Param("example") TXietongSuppliesExample example);

    int updateByExample(@Param("record") TXietongSupplies record, @Param("example") TXietongSuppliesExample example);

    int updateByPrimaryKeySelective(TXietongSupplies record);

    int updateByPrimaryKey(TXietongSupplies record);

    TXietongSupplies querySupplysById(@Param("id") String id);

}