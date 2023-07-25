package com.itheima.mapper;

import com.itheima.entity.Result;
import com.itheima.entity.Role;
import com.itheima.page.Page;
import com.itheima.service.RoleService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Mapper
public interface RoleMapper {

    
    
    
    
  //根据用户ID查询用户分配的所有角色

public List<Role> findUserRoleByUid (Integer userId);

    List<Role> findAllRole();




    //根据角色名查询角色ID的方法
    public Integer findRoleIdByName (String roleName);



    //查询角色行数的方法

    public Integer findRoleRowCount (Role role );


    //分页查询角色的方法
    public List<Role> findRolePage(@Param("page") Page page , @Param("role") Role role );


    //根据角色名称或者角色代码查询角色的方法

    public Role findRoleByNameOrCode(String roleName ,String roleCode) ;


    //添加角色方法

    public int inserRole(Role role );

    //根据角色id修改角色状态的方法
    public int setRoleStateByRid(Integer roleId , String roleState);

    //根据id删除角色

    public int removeRoleByid(Integer roleId );

    //根据角色id修改角色描述

    public int setDescByRid(Role role );


}