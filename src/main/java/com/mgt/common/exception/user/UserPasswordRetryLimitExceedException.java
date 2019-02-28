package com.mgt.common.exception.user;

/**
 * @program: mgt-contrl-platform
 * @description:  用户错误最大次数异常类
 * @author: Mr.Gu
 * @create: 2019-02-27 15:29
 **/
public class UserPasswordRetryLimitExceedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount)
    {
        super("user.password.retry.limit.exceed", new Object[] { retryLimitCount });
    }
}
