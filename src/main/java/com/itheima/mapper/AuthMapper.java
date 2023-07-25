package com.itheima.mapper;

import com.itheima.entity.Auth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthMapper {


    //根据USERID查询用户权限下所有菜单]


    public List<Auth> findAuthById(Integer userid) ;

//查询所有权限菜单 的 方法
    public List<Auth> findAllAuth();
//根据角色id查询分配的所有权限菜单的方法
    public List<Auth> findAuthByRid(Integer roleId);

}
