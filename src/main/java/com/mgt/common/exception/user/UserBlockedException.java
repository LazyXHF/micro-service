package com.mgt.common.exception.user;

/**
 * @program: mgt-contrl-platform
 * @description: 用户锁定异常类
 * @author: Mr.Gu
 * @create: 2019-02-27 12:27
 **/
public class UserBlockedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserBlockedException(String reason)
    {
        super("user.blocked", new Object[] { reason });
    }
}
