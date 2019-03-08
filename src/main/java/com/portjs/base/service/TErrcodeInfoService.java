package com.portjs.base.service;

/**
 * @author: daiyueyuan
 * @date: 2019/3/6 10:54
 * @description: 错误信息接口
 */
public interface TErrcodeInfoService {

    String getErrorMsg(String errorType, String errorCode);

}
