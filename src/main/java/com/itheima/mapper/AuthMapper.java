package com.itheima.mapper;

import com.itheima.entity.Auth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthMapper {


    //根据USERID查询用户权限下所有菜单]


    public List<Auth> findAuthById(Integer userid) ;


}
