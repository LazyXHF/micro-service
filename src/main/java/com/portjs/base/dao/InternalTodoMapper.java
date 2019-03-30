package com.portjs.base.dao;

import com.portjs.base.entity.InternalTodo;
import com.portjs.base.entity.InternalTodoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalTodoMapper {
    int countByExample(InternalTodoExample example);

    int deleteByExample(InternalTodoExample example);

    int deleteByPrimaryKey(String id);

    int insert(InternalTodo record);

    int insertSelective(InternalTodo record);

    List<InternalTodo> selectByExample(InternalTodoExample example);

    InternalTodo selectByPrimaryKey(String id);

    /**
     * 条件查询
     * @param example
     * @return
     */
    List<InternalTodo> selectByObject(InternalTodo example);

    int updateByExampleSelective(@Param("record") InternalTodo record, @Param("example") InternalTodoExample example);

    int updateByExample(@Param("record") InternalTodo record, @Param("example") InternalTodoExample example);

    int updateByPrimaryKeySelective(InternalTodo record);

    int updateByPrimaryKey(InternalTodo record);
}