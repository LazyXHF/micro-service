package com.mgt.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import java.util.Collection;

/**
 * 通过当前的请求地址，获取该地址需要的用户角色
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

   // AntPathMatcher antPathMatcher = new AntPathMatcher();
    //遍历出所有符合当前url请求的地址,对应的角色
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o)throws IllegalArgumentException {

        String requestUrl = ((FilterInvocation) o).getRequestUrl();

        if(requestUrl.startsWith("/user")){
            return SecurityConfig.createList(new String[0]);
        }
        if ("/login_p".equals(requestUrl)) {
            return null;
        }

       /* //部门
        if(requestUrl.startsWith("/department")){
            return SecurityConfig.createList(new String[0]);
        }

        // 下载用户手册
        if(requestUrl.startsWith("/shouce")){
            return SecurityConfig.createList(new String[0]);
        }

        // 收文传阅单
        if(requestUrl.startsWith("/txietongReceiving/selectTXietongReceivingDetails")){
            return SecurityConfig.createList(new String[0]);
        }

        // 发文传阅单
        if(requestUrl.startsWith("/txietongDispatch/selectTXietongDispatchDetails")){
            return SecurityConfig.createList(new String[0]);
        }
*/




        //

  /*      //获取所有菜单资源
        List<TXietongMenuResource> allMenu = menuResourceService.getAllMenuResource();
        for (TXietongMenuResource menu : allMenu) {
            //将当前的请求url地址和遍历符合要求的url相比较.并且此url对应的角色要存在
            if (antPathMatcher.match(menu.getUrl(), requestUrl)
                    &&menu.getRoles().size()>0) {
                List<TXietongRole> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getName();
                }
                //将所有的符合要求的角色集合交给security容器管理
                return SecurityConfig.createList(values);
            }
        }*/
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
