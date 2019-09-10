package com.userLogin.service;

import com.userLogin.entity.syspermission.SysPermission;
import com.userLogin.entity.sysuser.SysUser;

import java.util.List;

/**
 * Created by zhang_htao on 2019/9/8.
 */
public interface UserInfoService {
    SysUser getUserInfoByUserName(String userName);
    List<SysPermission> getPermissionByUserName(Integer id);
}

