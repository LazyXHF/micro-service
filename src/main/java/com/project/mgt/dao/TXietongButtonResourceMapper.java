package com.project.mgt.dao;

import com.project.mgt.entity.TXietongButtonResource;
import com.project.mgt.entity.TXietongButtonResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TXietongButtonResourceMapper {
    int countByExample(TXietongButtonResourceExample example);

    int deleteByExample(TXietongButtonResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TXietongButtonResource record);

    int insertSelective(TXietongButtonResource record);

    List<TXietongButtonResource> selectByExample(TXietongButtonResourceExample example);

    TXietongButtonResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TXietongButtonResource record, @Param("example") TXietongButtonResourceExample example);

    int updateByExample(@Param("record") TXietongButtonResource record, @Param("example") TXietongButtonResourceExample example);

    int updateByPrimaryKeySelective(TXietongButtonResource record);

    int updateByPrimaryKey(TXietongButtonResource record);

    //根据按钮id和资源id删除某权限
    int deleteButtonResource(@Param("bid") String id, @Param("reid") String reid);

    //根据按钮id和资源id查找资源
    TXietongButtonResource findButtonResourceByBidAndReid(@Param("bid") String bid, @Param("reid") String reid);
}
