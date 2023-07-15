package com.itheima.mapper;

import com.itheima.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UserMapper {
//根据战壕查询用户登录

    public User findUserByCode(String userCode) ;

}
