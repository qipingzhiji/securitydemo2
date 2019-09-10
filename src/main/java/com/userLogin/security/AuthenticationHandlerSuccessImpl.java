package com.userLogin.security;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 认证成功处理
 * Created by zhang_htao on 2019/9/9.
 */
public class AuthenticationHandlerSuccessImpl implements AuthenticationSuccessHandler{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("statusCode","1");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(result));
    }
}
