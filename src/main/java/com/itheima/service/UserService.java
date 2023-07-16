package com.itheima.service;

import com.itheima.dto.AssignRoleDto;
import com.itheima.entity.Result;
import com.itheima.entity.User;
import com.itheima.page.Page;

import java.awt.image.RescaleOp;

public interface UserService {
  public int saveUser(User user,String token); ;

    //根据id查用户

    public User queryUserByCode (String userCode);




    //分页查询用户的业务方法

    public Page queryUserByPage(Page page , User user);


   public int updateState(User user ,String token);




public void assignUser(AssignRoleDto assignRoleDto);




   //给用户分配角色 的 业务方法








}
