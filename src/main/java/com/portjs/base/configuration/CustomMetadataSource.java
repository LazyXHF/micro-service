package com.portjs.base.configuration;

import com.portjs.base.entity.TMenuResource;
import com.portjs.base.entity.TRole;
import com.portjs.base.service.TMenuResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 通过当前的请求地址，获取该地址需要的用户角色
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    /**
     *
     *   MenuService的作用是用来查询数据库中url和role的对应关系，
     *   查询结果是一个List集合，集合中是Menu类，Menu类有两个核心属性，
     *   一个是url pattern，即匹配规则(比如/admin/**)，
     *   还有一个是List,即这种规则的路径需要哪些角色才能访问。
     */
    @Autowired
    TMenuResourceService menuResourceService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    //遍历出所有符合当前url请求的地址,对应的角色
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) {

        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        if ("/login_p".equals(requestUrl)) {
            return null;
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




        //

        //获取所有菜单资源
        List<TMenuResource> allMenu = menuResourceService.getAllMenuResource();
        for (TMenuResource menu : allMenu) {
            //将当前的请求url地址和遍历符合要求的url相比较.并且此url对应的角色要存在
            if (antPathMatcher.match(menu.getPath(), requestUrl)
                    &&menu.getRoles().size()>0) {
                List<TRole> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getRoleName();
                }
                //将所有的符合要求的角色集合交给security容器管理
                return SecurityConfig.createList(values);
            }
        }
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
