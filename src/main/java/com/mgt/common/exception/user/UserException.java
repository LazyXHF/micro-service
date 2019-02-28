package com.mgt.common.exception.user;


import com.mgt.common.exception.base.BaseException;

/**
 * @program: mgt-contrl-platform
 * @description: 用户信息
 * @author: Mr.Gu
 * @create: 2019-02-27 12:27
 **/
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }

}
