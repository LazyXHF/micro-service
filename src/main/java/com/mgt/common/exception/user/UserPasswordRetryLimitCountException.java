package com.mgt.common.exception.user;

/**
 * @program: mgt-contrl-platform
 * @description:  用户错误记数异常类
 * @author: Mr.Gu
 * @create: 2019-02-27 15:29
 **/
public class UserPasswordRetryLimitCountException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitCountException(int retryLimitCount)
    {
        super("user.password.retry.limit.count", new Object[] { retryLimitCount });
    }
}
