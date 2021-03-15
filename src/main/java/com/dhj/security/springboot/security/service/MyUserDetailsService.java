package com.dhj.security.springboot.security.service;

import com.dhj.security.springboot.security.dao.UserDao;
import com.dhj.security.springboot.security.model.SysPermission;
import com.dhj.security.springboot.security.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = userDao.querySysUser(userName);

        if (sysUser == null){
            throw new RuntimeException("用户不存在");
        }
        List<SysPermission> sysPermissions = userDao.queryPermissionListByName(userName);
        List<String> stringList = new ArrayList<>();
        sysPermissions.forEach(sysPermission -> stringList.add(sysPermission.getPerTag()) );
        String[] sysPerArray=new String[stringList.size()];
        String[] strings = stringList.toArray(sysPerArray);
        UserDetails build = User.withUsername(sysUser.getUsername()).password(sysUser.getPassword()).authorities(strings).build();
        return build;
    }
}
