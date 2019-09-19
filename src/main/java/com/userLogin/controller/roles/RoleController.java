package com.userLogin.controller.roles;

import com.userLogin.dao.sysrole.SysRoleMapper;
import com.userLogin.entity.sysrole.SysRole;
import com.userLogin.entity.sysrole.SysRoleExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhang_htao on 2019/9/11.
 */
@Api(tags = "角色模块")
@RestController
public class RoleController {

    @Autowired
    private SysRoleMapper roleMapper;

    @ApiOperation(value = "查询所有的角色信息",httpMethod = "get")
    @GetMapping(value = "roles")
    public Object listRoles(){
        SysRoleExample sysRoleExample = new SysRoleExample();
        List<SysRole> sysRoles = roleMapper.selectByExample(sysRoleExample);
        return sysRoles;
    }

}
