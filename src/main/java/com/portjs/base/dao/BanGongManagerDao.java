package com.portjs.base.dao;

import com.portjs.base.entity.TXietongSupplies;
import com.portjs.base.entity.TXietongSuppliesCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/12/22.
 */
@Repository
public interface BanGongManagerDao {
    int addBanGong(TXietongSupplies supplies);

    int getCount(@Param("content") String content, @Param("category") String category);

    List<TXietongSupplies> getSupplies(@Param("content") String content, @Param("category") String category, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int updateBanGong(TXietongSupplies supplies);


    int queryStock(@Param("supplyName") String supplyName, @Param("supplyType") String supplyType);

    int updateSupplies(@Param("newStock") int newStcok, @Param("supplyName") String supplyName, @Param("supplyType") String supplyType, @Param("attribute") Integer attribute);

    List querySupplyName();

    List<TXietongSupplies> queryAllSupplies();

    TXietongSupplies selectRight(@Param("name") String name, @Param("type") String type);

    int updateStock(@Param("newStock") Integer newStock, @Param("name") String name, @Param("typeId") String typeid);

    int deleteRepository(@Param("id") String id);

    TXietongSupplies querySupplysById(String id);

    int querySupply(@Param("supplyName") String supplyName, @Param("supplyType") String supplyType);

    String querySupplyId(@Param("category") String category, @Param("supplyName") String name, @Param("supplyType") String type);

    Double queryPrice(@Param("supplyName") String supplyName, @Param("supplyType") String supplyType);

    List<TXietongSupplies> getSupplies1(@Param("content") String content, @Param("category") String category, @Param("rownum") Integer rowNum, @Param("pagecount") Integer pageCount);

    int querySupplyByName(@Param("supplyName") String supplyName, @Param("supplyType") String supplyType);

    int getCount1(@Param("content") String content, @Param("category") String category);

    List<TXietongSuppliesCategory> querySupplyCategories();

    List<Integer> queryAttribute(@Param("name") String name, @Param("type") String type);

    int updateSupplies1(@Param("newStock") int newStcok, @Param("supplyName") String supplyName, @Param("supplyType") String supplyType);
}
