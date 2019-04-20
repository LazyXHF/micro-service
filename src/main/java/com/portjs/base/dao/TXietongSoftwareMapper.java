package com.portjs.base.dao;

import com.portjs.base.entity.TXietongSoftware;
import com.portjs.base.entity.TXietongSoftwareExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TXietongSoftwareMapper {
    int countByExample(TXietongSoftwareExample example);

    int deleteByExample(TXietongSoftwareExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongSoftware record);

    int insertSelective(TXietongSoftware record);

    List<TXietongSoftware> selectByExample(TXietongSoftwareExample example);

    TXietongSoftware selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongSoftware record, @Param("example") TXietongSoftwareExample example);

    int updateByExample(@Param("record") TXietongSoftware record, @Param("example") TXietongSoftwareExample example);

    int updateByPrimaryKeySelective(TXietongSoftware record);

    int updateByPrimaryKey(TXietongSoftware record);

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<TXietongSoftware> querySoftwareByPage(@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
    int selectSoftwareCounts();
}