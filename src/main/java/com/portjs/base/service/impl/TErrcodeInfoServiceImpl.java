package com.portjs.base.service.impl;

import com.portjs.base.dao.TErrcodeInfoMapper;
import com.portjs.base.entity.TErrcodeInfo;
import com.portjs.base.service.TErrcodeInfoService;
import com.portjs.base.util.LogUtil;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: daiyueyuan
 * @date: 2019/3/6 10:55
 * @description:
 */

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
public class TErrcodeInfoServiceImpl extends LogUtil implements TErrcodeInfoService  {

    @Autowired
    private TErrcodeInfoMapper errcodeInfoMapper;

    @Override
    // 启用缓存
    @Cacheable(value = "t_errorcode_info", key = "#errorType.concat(#errorCode)")
    public String getErrorMsg(String errorType, String errorCode) {
        logger.debug("getErrorMsg() begin...errorType=" + errorType + "],errorCode=" + errorCode);
        String errorMsg = "";

        // 缓存没有，查询数据库
        if (errorMsg == null || errorMsg.isEmpty()) {
            System.out.println("查询数据库");

            TErrcodeInfo errcodeInfo = errcodeInfoMapper.selectErrorMsg(errorType, errorCode);
            System.out.println("0000=" + errcodeInfo);
            errorMsg = errcodeInfo.getErrorMsg();

            if (errorMsg == null || errorMsg.isEmpty()) {
                System.out.println(
                        "数据库也没有该errorType=" + errorType + "]errorCode=" + errorCode + "]对应的错误描述信息");
            }

            System.out.println("查询数据库end ，errorMsg=" + errorMsg);
        }

        return errorMsg;
    }
}
