package com.itheima.service;

import com.itheima.dto.AssignAuthDto;
import com.itheima.entity.Result;
import com.itheima.entity.Role;
import com.itheima.page.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public  interface RoleService {

    public List<Role> findAllRoles();


    public List<Role> findUserRoleByUid(Integer userid);

//分页查询角色

    public Page queryRolePage(Page page, Role role);

    //添加角色的业务方法

    public Result saveRole(Role role);

    //启用禁用角色的方法

    public Result setRoleState(Role role);

    //根据id删除角色
    public Result removeRoleByid(Integer roleId);

    //查询角色分配的所有权限菜单ID的业务方法

    public  List<Integer> queryRoleAuthIds(Integer roleId);




    //给角色分配权限
    public void saveRoleAuth(AssignAuthDto assignAuthDto);





    //修改角色
    public Result setRoleByRid(Role role );
}
