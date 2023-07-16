package com.itheima.mapper;

import com.itheima.entity.UserRole;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

public interface UserRoleMapper {

    //删除用户已经分配的角色
public int deleteRoleByUid(Integer userId);


   //添加用户角色关系的方法
    public int saveUserRole(UserRole userRole) ;

}