package com.userLogin.security;

import com.userLogin.security.exception.ImageCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhang_htao on 2019/9/9.
 */
public class ImageCodeAuthenticationPre extends OncePerRequestFilter {

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    private static final  Logger logger = LoggerFactory.getLogger(ImageCodeAuthenticationPre.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (request.getRequestURL().toString().contains("securityLogin")) {
                String imageCode = request.getParameter("imageCode");
                String randomcode = (String) request.getSession().getAttribute("imageRandomCode");
                if(StringUtils.isEmpty(imageCode)){
                    throw new ImageCodeException("验证码没有输入");
                }

                if(!imageCode.equals(randomcode)){
                    throw new ImageCodeException("验证码不一致，请重新进行输入");
                }
            }
        } catch (AuthenticationException e) {
            logger.error(e.toString());
            authenticationFailureHandler.onAuthenticationFailure(request,response,e);
            //出现异常后，停止过滤器链的执行
            return;
        }
        filterChain.doFilter(request,response);
    }
}
