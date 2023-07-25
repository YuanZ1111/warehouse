package com.itheima.service;

import com.itheima.entity.Auth;
import com.itheima.mapper.AuthMapper;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthService {

    //查询用户的菜单树

    public List<Auth> authTreeById(Integer userId);


    //查询所有权限菜单树的方法

    public List<Auth> allAuthTree();
}
