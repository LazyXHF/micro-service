package com.portjs.base.dao;

import com.portjs.base.entity.TTodo;
import com.portjs.base.entity.TTodoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TTodoMapper {
    int countByExample(TTodoExample example);

    int deleteByExample(TTodoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TTodo record);

    int insertSelective(TTodo record);

    List<TTodo> selectByExample(TTodoExample example);

    TTodo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TTodo record, @Param("example") TTodoExample example);

    int updateByExample(@Param("record") TTodo record, @Param("example") TTodoExample example);

    int updateByPrimaryKeySelective(TTodo record);

    int updateByPrimaryKey(TTodo record);

    List<TTodo> selectBySomething(TTodo record);

    int  selectCountBySomething(TTodo record);
}