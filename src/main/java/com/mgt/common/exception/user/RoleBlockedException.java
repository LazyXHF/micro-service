package com.mgt.common.exception.user;

/**
 * @program: mgt-contrl-platform
 * @description: 角色锁定异常类
 * @author: Mr.Gu
 * @create: 2019-02-27 12:27
 **/
public class RoleBlockedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public RoleBlockedException(String reason)
    {
        super("role.blocked", new Object[] { reason });
    }

}
