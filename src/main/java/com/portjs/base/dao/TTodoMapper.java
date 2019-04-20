package com.portjs.base.dao;

import com.portjs.base.entity.TTodo;
import com.portjs.base.entity.TTodoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    TTodo toApprove(@Param("id") String id, @Param("ownerId") String ownerId);

    List<TTodo> selectBySomething(TTodo record);

    List<TTodo> queryNotReviewProject(@Param("id") String id);

    int  selectCountBySomething(TTodo record);

    /**
     * 查询所有待办信息
     * @return ReceiverId 问题被 @ 人 （接收人，审核人id）
     */
    List<TTodo> queryTodoInfos();

    /**
     * 根据todo_type="事务处理" 和 receiver_id = #｛receiver_id｝还有问题单id relateddomain_id,
     * @return receiver_id 接收人id
     */
    int updateStatusByCommunicationLog(@Param("receiverId") String receiverId, @Param("relateddomainId") String relateddomainId);


    int deleteTodoRecord(@Param("id") String id, @Param("ownerId") String ownerId);

    int queryTodoRecord(@Param("id") String id, @Param("ownerId") String ownerId);

    int updateTodoRecord(TTodo tTodo);
}