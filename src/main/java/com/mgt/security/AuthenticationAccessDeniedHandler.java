package com.mgt.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgt.common.utils.Code;
import com.mgt.common.utils.ResponseMessage;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义403响应的内容
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp,
                       AccessDeniedException e) throws IOException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ResponseMessage responseMessage = new ResponseMessage(Code.CODE_NOAUTH,"权限不足，请联系管理员!");
        out.write(new ObjectMapper().writeValueAsString(responseMessage));
        out.flush();
        out.close();
    }
}
