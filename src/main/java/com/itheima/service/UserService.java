package com.itheima.service;

import com.itheima.entity.User;
import com.itheima.page.Page;

public interface UserService {
  public int saveUser(User user,String token); ;

    //根据id查用户

    public User queryUserByCode (String userCode);




    //分页查询用户的业务方法

    public Page queryUserByPage(Page page , User user);


   public int updateState(User user ,String token);
}
