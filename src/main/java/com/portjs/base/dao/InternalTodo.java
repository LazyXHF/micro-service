package com.portjs.base.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/3/27.
 */
@Repository
public interface InternalTodo {

     int isShenHe(@Param("id") String id, @Param("ownerId") String ownerId);



}
