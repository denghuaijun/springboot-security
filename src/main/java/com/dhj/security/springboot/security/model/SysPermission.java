package com.dhj.security.springboot.security.model;

import lombok.Data;

@Data
public class SysPermission {
    private Long id;
    private String perTag;
    private String perUrl;
}
