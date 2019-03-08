package com.portjs.base.util;

import com.portjs.base.entity.TUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {
    //登录账号
   public static String USER_NAME_ACCOUNT;

    public static TUser getCurrentUser() {
        try {
            return (TUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return new TUser();
        }
    }
}
