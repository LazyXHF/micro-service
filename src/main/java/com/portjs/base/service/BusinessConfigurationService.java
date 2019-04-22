package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

import java.util.Map;

/**
 * @author: daiyueyuan
 * @date: 2019/4/18 19:26
 * @description:
 */
public interface BusinessConfigurationService {
    ResponseMessage selectBusinessConfigurationById(String requestBody);
}
