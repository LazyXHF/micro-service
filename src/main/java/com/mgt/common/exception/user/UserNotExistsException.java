package com.mgt.common.exception.user;

/**
 * @program: mgt-contrl-platform
 * @description: 用户不存在
 * @author: Mr.Gu
 * @create: 2019-02-27 12:27
 **/
public class UserNotExistsException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserNotExistsException()
    {
        super("user.not.exists", null);
    }
}
