package com.itheima.controller;

import com.itheima.entity.Result;
import com.itheima.entity.User;
import com.itheima.page.Page;
import com.itheima.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
    private UserService userService;


//分页查询用户的url接口
@GetMapping("/user-list")
    public Result getUserList(Page page , User user){



log.info("===>>>usercode:{}" , user.getUserCode() );
   page = userService.queryUserByPage(page, user);

    return Result.ok(page);

}





}
