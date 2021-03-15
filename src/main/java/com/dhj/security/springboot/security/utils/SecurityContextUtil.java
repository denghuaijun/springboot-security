package com.dhj.security.springboot.security.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityContextUtil {

    /**
     * 根据上下文获取对应的认证用户信息
     * @return
     */
    public static UserDetails  getAuthtication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null){
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            return userDetails;
        }else {
            return null;
        }
    }
}
