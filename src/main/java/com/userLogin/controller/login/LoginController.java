package com.userLogin.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhang_htao on 2019/9/9.
 */
@Controller
public class LoginController {

    @RequestMapping("loginSelf")
    public String login(){
        return "login/login";
    }

    @RequestMapping("error")
    public String error(){
        return "error/AccessDenied";
    }

    @RequestMapping("loginSuccess")
    public String success() {
        return "login/login-success";
    }

    @RequestMapping("randomCode")
    public String randomCode(){
        return "login/randomCode/randomCode";
    }

}
