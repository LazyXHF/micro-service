package com.project.mgt.util;

/**
 * Created by 许虎飞 on 2018/12/14.
 */
public   class   Code {
    //表示从客户端发来的请求在服务器端被正确处理
     public final static  Integer CODE_OK = 200;
    //表示服务器端在执行请求时发生了错误
     public final static  Integer CODE_ERROR = 500;
    //表明服务器暂时处于超负载或正在停机维护，无法处理请求
     public final static  Integer CODE_STOP = 503;
    //表示发送的请求需要有通过 HTTP 认证的认证信息(没有认证)
     public final static  Integer CODE_NOAUTH = 401;
    //表示对请求资源的访问被服务器拒绝(没有权限)
     public final static  Integer CODE_FORBIDDEN = 403;






}
