package com.userLogin.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by zhang_htao on 2019/9/9.
 */
public class ImageCodeException extends AuthenticationException{
    public ImageCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ImageCodeException(String msg) {
        super(msg);
    }
}
