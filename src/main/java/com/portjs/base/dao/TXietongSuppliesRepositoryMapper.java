package com.portjs.base.dao;

import com.portjs.base.entity.TXietongSuppliesRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TXietongSuppliesRepositoryMapper {

    int addBanGongName(@Param("supplyName") String supplyName, @Param("categoryId") String categoryId);

    int addBanGongType(@Param("type") String type, @Param("id") Integer id);

    List<TXietongSuppliesRepository> querySupplyName(@Param("categoryId") String categoryId);

    List<TXietongSuppliesRepository> querySupplyType(@Param("id") Integer id);

    int queryChongFu(@Param("categoryId") String categoryId, @Param("supplyName") String supplyName);

    int queryTypeId(@Param("supplyName") String supplyName);

    int queryChongFuType(@Param("type") String type);

    int queryType(@Param("type") String type, @Param("typeId") int typeId);

    int deleteName(@Param("id") Integer id);

    int deleteType(@Param("typeId") Integer id);

    TXietongSuppliesRepository queryRepository(@Param("name") String name);

    int insertSupply(@Param("name") String name, @Param("categoryid2") String categoryid2);

    int queryNameId(@Param("name") String name, @Param("categoryid2") String categoryid2);

    int insertType(@Param("type") String type, @Param("typeId") int typeId);

    int updateRepository(@Param("name") String name, @Param("categoryid2") String categoryid2);

    int queryRepositoryType(@Param("type") String type, @Param("typeId") Integer typeId);

    int queryCategorySupply(@Param("categoryId") String id, @Param("name") String name);
}