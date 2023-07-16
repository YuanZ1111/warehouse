package com.itheima.service.impl;

import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import com.itheima.page.Page;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper ;

    @Override
    public User queryUserByCode(String userCode) {
        User user = userMapper.findUserByCode(userCode);
        return user;
    }

    @Override
    public Page queryUserByPage(Page page, User user) {


        Integer count = userMapper.findRowCount(user);
List<User> userList = userMapper.findUserByPage(user,page);


//page

        page.setTotalNum(count);
        page.setResultList(userList);


return page ;


    }
}
