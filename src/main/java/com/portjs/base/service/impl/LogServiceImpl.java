package com.portjs.base.service.impl;


import com.portjs.base.dao.LogMapper;
import com.portjs.base.entity.Log;
import com.portjs.base.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: mgt-contrl-platform
 * @description: Log服务层
 * @author: Mr.Gu
 * @create: 2019-03-01 10:06
 **/
@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
public class LogServiceImpl implements LogService {

    private static final String tag = "LogServiceImpl======";
    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Resource
    private LogMapper logMapper;

    @Override
    public int insertSelective(Log record) {
        logger.debug(tag + record.toString());
        return logMapper.insertSelective(record);
    }
}
