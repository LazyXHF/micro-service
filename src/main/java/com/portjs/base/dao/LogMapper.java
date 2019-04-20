package com.portjs.base.dao;

import com.portjs.base.entity.Log;
import org.springframework.stereotype.Repository;

/**
 * @program: mgt-contrl-platform
 * @description: dao
 * @author: Mr.Gu
 * @create: 2019-03-01 10:04
 **/
@Repository
public interface LogMapper {
    int insertSelective(Log record);
}