package com.userLogin.dao.sysrolepermission;

import com.userLogin.entity.sysrolepermission.sysRolePermission;
import com.userLogin.entity.sysrolepermission.sysRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermissionMapper {
    long countByExample(sysRolePermissionExample example);

    int deleteByExample(sysRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(sysRolePermission record);

    int insertSelective(sysRolePermission record);

    List<sysRolePermission> selectByExample(sysRolePermissionExample example);

    sysRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") sysRolePermission record, @Param("example") sysRolePermissionExample example);

    int updateByExample(@Param("record") sysRolePermission record, @Param("example") sysRolePermissionExample example);

    int updateByPrimaryKeySelective(sysRolePermission record);

    int updateByPrimaryKey(sysRolePermission record);
}