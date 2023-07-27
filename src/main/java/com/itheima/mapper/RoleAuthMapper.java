package com.itheima.mapper;

import com.itheima.entity.RoleAuth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleAuthMapper {



    //从角色权限中间表删除角色权限关系


    //根据角色iD 删除 角色权限关系

    public int removeRoleAuthByRid(Integer roleId);


    //根据角色id查询角色分配的所有菜单权限
   public List<Integer> findAuthIdsByRId(Integer roleId);

   //添加角色权限关系
   public int insertRoleAuth(RoleAuth roleAuth);

}