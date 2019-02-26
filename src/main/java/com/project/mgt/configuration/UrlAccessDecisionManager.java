package com.project.mgt.configuration;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * FilterInvocationSecurityMetadataSource 这个类,结束以后会自动来到当前类
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {
    /**
     * @param auth 参数中保存了当前登录用户的角色信息
     * @param o
     * @param cas  UrlFilterInvocationSecurityMetadataSource中的getAttributes方法传来的，
    表示当前请求需要的角色（可能有多个）
     */
    @Override
    public void decide(Authentication auth, Object o, Collection<ConfigAttribute> cas){
        // 为空则不校验
        if (cas == null) {
            return;
        }

        Iterator<ConfigAttribute> iterator = cas.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute ca = iterator.next();
            //当前请求需要的权限
            String needRole = ca.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)) {
                if (auth instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("未登录");
                } else
                    return;
            }
            //当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }

        }
        throw new AccessDeniedException("权限不足!");
    }
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}