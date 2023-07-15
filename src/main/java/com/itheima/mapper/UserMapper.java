package com.itheima.mapper;

import com.itheima.entity.User;

public interface UserMapper {
//根据战壕查询用户登录

    public User findUserByCode(String userCode) ;

}
