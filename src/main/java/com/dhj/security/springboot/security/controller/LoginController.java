package com.dhj.security.springboot.security.controller;


import com.dhj.security.springboot.security.utils.SecurityContextUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {


    @RequestMapping(value = "/success-form",produces = "text/plain;charset=utf-8")
    public String loginSuccess(){
        UserDetails authtication = SecurityContextUtil.getAuthtication();
        return authtication.getUsername()+"登陆成功";
    }

    @RequestMapping(value = "/res/res1",produces = "text/plain;charset=utf-8")
    //@PreAuthorize("hasAuthority('res1')")//开启方法授权才有效
    public String reqResource1(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.println(principal.toString());
        return "访问资源服务1";
    }
    @RequestMapping(value = "/res/res2",produces = "text/plain;charset=utf-8")
    //@PreAuthorize("hasAuthority('res2')")
    public String reqResource2(HttpSession session){

        return "访问资源服务2";
    }


}
