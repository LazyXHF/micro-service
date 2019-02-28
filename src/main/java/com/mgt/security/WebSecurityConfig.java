package com.mgt.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgt.common.utils.Code;
import com.mgt.common.utils.ResponseMessage;
import com.mgt.project.Example.service.impl.TXietongUserServiceImpl;
import org.apache.catalina.security.SecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    static final String tag = "SecurityConfig======";
    static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    TXietongUserServiceImpl userService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;

//    @Autowired
//    JedisConnectionFactory jedisConnectionFactory;
//
//
//    @Bean
//    SpringSessionBackedSessionRegistry sessionRegistry() {
//        return new SpringSessionBackedSessionRegistry(getSessionRepository());
//    }
//    @Bean
//    public FindByIndexNameSessionRepository getSessionRepository() {
//        return new RedisOperationsSessionRepository(jedisConnectionFactory);
//    }

    /**
     * 用来配置用户签名服务，主要是user-details机制。注：此处还可以给用户赋予角色 AuthenticationManagerBuilder
     * 签名管理器构造器，用于构建用户具体权限控制
     */
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userRoleService).passwordEncoder(new PasswordEncoder() {
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                logger.debug("rawPassword is " + rawPassword + ",encodedPassword is " + encodedPassword);
//                return encodedPassword.equals(rawPassword);
//            }
//
//            @Override
//            public String encode(CharSequence rawPassword) {
//                logger.debug("rawPassword is " + rawPassword);
//                return rawPassword.toString();
//            }
//        });
//        // 不删除凭据，以便记住用户
//        auth.eraseCredentials(false);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.userDetailsService(userService)
//                .passwordEncoder(new BCryptPasswordEncoder());  //密码加密方式

        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                logger.debug("rawPassword is " + rawPassword + ",encodedPassword is " + encodedPassword);
                return encodedPassword.equals(rawPassword);
            }

            @Override
            public String encode(CharSequence rawPassword) {
                logger.debug("rawPassword is " + rawPassword);
                return rawPassword.toString();
            }
        });
        // 不删除凭据，以便记住用户
        auth.eraseCredentials(false);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(CorsUtils::isPreFlightRequest).and().ignoring().antMatchers("/resources/**",
                "/static/**", "/css/**", "/js/**", "/images/**")
                //swagger2配置路由,请勿删除
                .antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**")
                //swagger案例使用
                .antMatchers("/swagger2/**");
    }



    /**
     * 通过withObjectPostProcessor将刚刚创建的
     * UrlFilterInvocationSecurityMetadataSource和UrlAccessDecisionManager注入进来。到时候，
     * 请求都会经过刚才的过滤器（除了configure(WebSecurity web)方法忽略的请求）。
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin().loginPage("/login_p").loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        AuthenticationException e) throws IOException {
                        resp.setContentType("application/json;charset=utf-8");
                        ResponseMessage responseMessage = null;

                        //                        RespBean respBean = null;
                        if (e instanceof BadCredentialsException ||
                                e instanceof UsernameNotFoundException) {
                            responseMessage = new ResponseMessage(Code.CODE_ERROR,"账户名或者密码输入错误!");
                        } else if (e instanceof LockedException) {
                            responseMessage = new ResponseMessage(Code.CODE_ERROR,"账户被锁定，请联系管理员!");
                        } else if (e instanceof CredentialsExpiredException) {
                            responseMessage = new ResponseMessage(Code.CODE_ERROR,"密码过期，请联系管理员!");
                        } else if (e instanceof AccountExpiredException) {
                            responseMessage = new ResponseMessage(Code.CODE_ERROR,"账号过期，请联系管理员!");
                        } else if (e instanceof DisabledException) {
                            responseMessage = new ResponseMessage(Code.CODE_ERROR,"账号不能使用，请联系管理员!");
                        } else {
                            responseMessage = new ResponseMessage(Code.CODE_ERROR,"登录失败！");
                        }
                        resp.setStatus(401);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(responseMessage));
                        out.flush();
                        out.close();
                    }
                })
                //配置登录成功时返回的JSON，登录成功时返回当前用户的信息。
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        Authentication auth) throws IOException {
                        resp.setContentType("application/json;charset=utf-8");
                        ResponseMessage responseMessage = new ResponseMessage(Code.CODE_OK,"登录成功!",
                                UserUtils.getCurrentUser());
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(responseMessage));
                        out.flush();
                        out.close();
                        logger.debug("登录成功后，打印session=" + req.getSession().getId());
                    }
                }).permitAll().and()
                // 退出页面和默认跳转路径
                .logout()./* logoutUrl("/").logoutSuccessUrl("/"). */permitAll().and().cors().and()
                // 权限不足
                .csrf().disable().exceptionHandling().accessDeniedHandler(deniedHandler);

        // session使用数据库进行管理，最大并发数（可以控制单个用户只能创建一个session，也就只能在服务器登录一次），相同账号登录时的踢人
//		http.sessionManagement()./* 最大并发session */maximumSessions(1).expiredUrl("/login")./* 是否阻止新的登录 */maxSessionsPreventsLogin(true);

        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();


    }

    // Spring Security + Spring Session 引起的 session 冲突问题
    @Bean
    public CookieSerializer httpSessionIdResolver() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setCookieName("token");
        cookieSerializer.setUseHttpOnlyCookie(false);
        cookieSerializer.setSameSite(null);
        return cookieSerializer;
    }


}