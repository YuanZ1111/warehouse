package com.itheima.controller;


import com.itheima.entity.Auth;
import com.itheima.entity.Result;
import com.itheima.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/auth")
@RestController

public class AuthController {

@Autowired
    private AuthService authService ;

//查询所有权限菜单树的url接口/auth/auth-tree

    @RequestMapping("/auth-tree")
public Result loadAllauthTree(){
        List<Auth> allAuthTree = authService.allAuthTree() ;
        return Result.ok(allAuthTree) ;

    }


}
