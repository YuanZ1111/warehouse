package com.itheima.mapper;

import com.itheima.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    
    
    
    
  //根据用户ID查询用户分配的所有角色

public List<Role> findUserRoleByUid (Integer userId);

    List<Role> findAllRole();




    //根据角色名查询角色ID的方法
    public Integer findRoleIdByName (String roleName);





}