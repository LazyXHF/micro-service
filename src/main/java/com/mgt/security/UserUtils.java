package com.mgt.security;
import com.mgt.project.Example.entity.TXietongUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {
    public static TXietongUser getCurrentUser() {
        try {
            return (TXietongUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return  new TXietongUser();
        }
    }
}
