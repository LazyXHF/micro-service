package com.portjs.base.service;

import com.portjs.base.entity.Log;

/**
 * @program: mgt-contrl-platform
 * @description: dao
 * @author: Mr.Gu
 * @create: 2019-03-01 10:04
 **/
public interface LogService {
    int insertSelective(Log record);
}