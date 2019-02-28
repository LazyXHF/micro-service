package com.mgt.common.exception.user;

/**
 * @program: mgt-contrl-platform
 * @description: 用户删除
 * @author: Mr.Gu
 * @create: 2019-02-27 12:27
 **/
public class UserDeleteException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserDeleteException()
    {
        super("user.password.delete", null);
    }
}
