package com.userLogin.controller;

import com.userLogin.dao.sysrole.SysRoleMapper;
import com.userLogin.entity.sysrole.SysRole;
import com.userLogin.entity.sysrole.SysRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhang_htao on 2019/9/7.
 */
@RestController
public class HelloController {
    @Autowired
    private SysRoleMapper roleDao;

    @RequestMapping("/roles")
    public List<SysRole> listRoles(){
        SysRoleExample sysRoleExample = new SysRoleExample();
        return roleDao.selectByExample(sysRoleExample);
    }
}
