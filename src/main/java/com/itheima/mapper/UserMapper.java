package com.itheima.mapper;

import com.itheima.entity.User;
import com.itheima.page.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface UserMapper {

//根据战壕查询用户登录

    public User findUserByCode(String userCode) ;

    //分页查询用户

    public List<User> findUserByPage( @Param("user") User user ,@Param("page") Page page);

    public  Integer findRowCount(@Param("user") User user);
}
