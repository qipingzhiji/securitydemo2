package com.userLogin.security;

import com.userLogin.entity.syspermission.SysPermission;
import com.userLogin.entity.syspermission.SysPermissionExample;
import com.userLogin.entity.sysuser.SysUser;
import com.userLogin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_htao on 2019/9/8.
 */

public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userInfoService.getUserInfoByUserName(username);
         if(sysUser!=null){
            List<SysPermission> permissionByUserName = userInfoService.getPermissionByUserName(sysUser.getId());

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (SysPermission sysPermission : permissionByUserName) {
                grantedAuthorities.add(new SimpleGrantedAuthority(sysPermission.getRoledesc()));
            }

            User user = new User(username,sysUser.getPassword(),sysUser.getEnabled(),sysUser.getAccountnonexpired(),sysUser.getCredentialsnonexpired(),sysUser.getAccountnonlocked(),grantedAuthorities);
            return user;
        }
        return null;
    }
}
