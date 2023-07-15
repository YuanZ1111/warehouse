package com.itheima.service;

import com.itheima.entity.User;

public interface UserService {

    //根据id查用户

    public User queryUserByCode (String userCode);
}
