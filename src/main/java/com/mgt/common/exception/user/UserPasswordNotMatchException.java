package com.mgt.common.exception.user;

/**
 * @program: mgt-contrl-platform
 * @description:  用户密码不正确或不符合规范异常类
 * @author: Mr.Gu
 * @create: 2019-02-27 15:29
 **/
public class UserPasswordNotMatchException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException()
    {
        super("user.password.not.match", null);
    }
}
