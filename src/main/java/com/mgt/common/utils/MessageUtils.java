package com.mgt.common.utils;

import com.mgt.common.utils.spring.SpringUtils;
import org.springframework.context.MessageSource;

/**
 * @program: mgt-contrl-platform
 * @description: 读取文件资源
 * @author: Mr.Gu
 * @create: 2019-02-27 12:27
 **/
public class MessageUtils
{
    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args)
    {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, null);
    }
}
