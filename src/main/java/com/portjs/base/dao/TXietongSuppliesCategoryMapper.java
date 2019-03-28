package com.portjs.base.dao;

import com.portjs.base.entity.TXietongSuppliesCategory;
import com.portjs.base.entity.TXietongSuppliesRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongSuppliesCategoryMapper {
    int addCategory(@Param("id") String id, @Param("category") String category);

    int queryCategory(String category);

    List<TXietongSuppliesCategory> queryCategories();

    int deleteCategory(@Param("id") String id);

    TXietongSuppliesCategory queryCategoryClass(@Param("category") String category);

    int insertCategory(@Param("categoryid2") String categoryid2, @Param("category") String category);
}