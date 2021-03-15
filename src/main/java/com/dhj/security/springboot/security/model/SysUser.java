package com.dhj.security.springboot.security.model;

import lombok.Data;

@Data
public class SysUser {
    private Long id;
    private String username;
    private String password;
    private String realname;
    private int age;
}
