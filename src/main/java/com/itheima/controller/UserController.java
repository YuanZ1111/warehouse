package com.itheima.controller;

import com.itheima.dto.AssignRoleDto;
import com.itheima.entity.Result;
import com.itheima.entity.Role;
import com.itheima.entity.User;
import com.itheima.entity.UserRole;
import com.itheima.mapper.RoleMapper;
import com.itheima.mapper.UserRoleMapper;
import com.itheima.page.Page;
import com.itheima.service.RoleService;
import com.itheima.service.UserRoleService;
import com.itheima.service.UserService;
import com.itheima.utils.WarehouseConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


@PostMapping("/addUser")
public  Result saveUser(@RequestBody User user ,@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){

    int flag = userService.saveUser(user, token);

if (flag >0){
    return Result.ok("成功添加");
}else {
    return Result.err(Result.CODE_ERR_BUSINESS,"添加失败(可能是用户名已经存在),请重试");
}

}

@PutMapping("/updateState")
 public Result updateState(@RequestBody User user , @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){

    int flag = userService.updateState(user, token);
if (flag >0){return Result.ok("修改成功");}else {
    return Result.err(Result.CODE_ERR_BUSINESS,"修改失败");
}

}
    @Autowired
        private
RoleService roleService;

    @GetMapping("/user-role-list/{userId}")

    public Result userRoleList (@PathVariable Integer userId){
    //执行业务

        List<Role> list = roleService.findUserRoleByUid(userId);
        return Result.ok(list);
    }
//给用户分配

@PutMapping("/assignRole")
    public Result assignRole (@RequestBody AssignRoleDto assignRoleDto)
{

userService.assignUser(assignRoleDto);
     return Result.ok("分配权限成功") ;
        }

}


