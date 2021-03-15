package com.dhj.security.springboot.security;

import com.dhj.security.springboot.security.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSecurityApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println(userDao.querySysUser("admin"));
        System.out.println(userDao.queryPermissionListByName("admin"));
    }

}
