package com.portjs.base.dao;

import com.portjs.base.entity.TXietongDocModel;
import com.portjs.base.entity.TXietongDocModelExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TXietongDocModelMapper {
    int countByExample(TXietongDocModelExample example);

    int deleteByExample(TXietongDocModelExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongDocModel record);

    int insertSelective(TXietongDocModel record);

    List<TXietongDocModel> selectByExample(TXietongDocModelExample example);

    TXietongDocModel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongDocModel record, @Param("example") TXietongDocModelExample example);

    int updateByExample(@Param("record") TXietongDocModel record, @Param("example") TXietongDocModelExample example);

    int updateByPrimaryKeySelective(TXietongDocModel record);

    int updateByPrimaryKey(TXietongDocModel record);

    /**
     * 分页
     * @return
     */
    List<TXietongDocModel> queryDocModelByPage(@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);

    /**
     * 统计
     * @return
     */
    int selectCounts();

}