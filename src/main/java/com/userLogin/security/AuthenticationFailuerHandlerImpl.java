package com.userLogin.security;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by zhang_htao on 2019/9/9.
 */
public class AuthenticationFailuerHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("statusCode","0");
        objectObjectHashMap.put("msg",exception.getMessage());
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(objectObjectHashMap));
    }
}
