package com.itheima.controller;

import com.itheima.entity.Result;
import com.itheima.entity.Role;
import com.itheima.service.RoleService;
import com.itheima.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
@Autowired
    private RoleService roleService;

//查询所有角色的URL接口

    @GetMapping("/role-list")
    public Result roleList(){
        List<Role> allRoles = roleService.findAllRoles();

        return Result.ok(allRoles);
    }


}
