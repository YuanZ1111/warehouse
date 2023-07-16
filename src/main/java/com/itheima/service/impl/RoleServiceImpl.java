package com.itheima.service.impl;

import com.itheima.entity.Role;
import com.itheima.mapper.RoleMapper;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//指定缓存名称 ----> redis的键的前缀
@Service
@CacheConfig(cacheNames = "com.itheima.service.impl.RoleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

//指定缓存的键
    @Cacheable(key = "'all:role'")
    @Override
    public List<Role> findAllRoles() {
        List<Role> allRole = roleMapper.findAllRole();
        return allRole;
    }

    @Override
    public List<Role> findUserRoleByUid(Integer userid) {


        List<Role> roleList = roleMapper.findUserRoleByUid(userid);


        return roleList;


    }


}
