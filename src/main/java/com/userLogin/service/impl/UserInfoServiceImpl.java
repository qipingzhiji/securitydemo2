package com.userLogin.service.impl;

import com.userLogin.dao.syspermission.SysPermissionMapper;
import com.userLogin.dao.sysrolepermission.SysRolePermissionMapper;
import com.userLogin.dao.sysuser.SysUserMapper;
import com.userLogin.dao.sysuserrole.SysUserRoleMapper;
import com.userLogin.entity.syspermission.SysPermission;
import com.userLogin.entity.syspermission.SysPermissionExample;
import com.userLogin.entity.sysrolepermission.sysRolePermission;
import com.userLogin.entity.sysrolepermission.sysRolePermissionExample;
import com.userLogin.entity.sysuser.SysUser;
import com.userLogin.entity.sysuser.SysUserExample;
import com.userLogin.entity.sysuserrole.SysUserRole;
import com.userLogin.entity.sysuserrole.SysUserRoleExample;
import com.userLogin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_htao on 2019/9/8.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Autowired
    private SysPermissionMapper permissionMapper;


    @Override
    public SysUser getUserInfoByUserName(String userName) {
        //根据用户名查询用户信息
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(userName);
        List<SysUser> sysUsers = userMapper.selectByExample(sysUserExample);
        if(sysUsers.size()>0){
            SysUser sysUser = sysUsers.get(0);
            return sysUser;
        }
       return null;
    }

    @Override
    public List<SysPermission> getPermissionByUserName(Integer id) {
        ArrayList<SysPermission> sysPermissions = new ArrayList<>();
        //查询用户拥有的角色信息
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andUserIdEqualTo(id);
        List<SysUserRole> sysUserRoles = userRoleMapper.selectByExample(sysUserRoleExample);
        //查询角色的权限信息
        for(SysUserRole sysUserRole : sysUserRoles) {
            sysRolePermissionExample sysRolePermissionExample = new sysRolePermissionExample();
            sysRolePermissionExample.createCriteria().andRoleIdEqualTo(sysUserRole.getRoleId());
            List<sysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(sysRolePermissionExample);
            for (sysRolePermission sysRolePermission : sysRolePermissions) {
                SysPermission sysPermission = permissionMapper.selectByPrimaryKey(sysRolePermission.getPermId());
                sysPermissions.add(sysPermission);
            }
        }
        return sysPermissions;
    }
}
