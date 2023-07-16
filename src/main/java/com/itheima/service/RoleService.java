package com.itheima.service;

import com.itheima.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public  interface RoleService {

    public List<Role> findAllRoles();


    public List<Role> findUserRoleByUid(Integer userid);
}
