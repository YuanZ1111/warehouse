package com.itheima.controller;

import com.itheima.dto.AssignAuthDto;
import com.itheima.entity.Auth;
import com.itheima.entity.CurrentUser;
import com.itheima.entity.Result;
import com.itheima.entity.Role;
import com.itheima.page.Page;
import com.itheima.service.RoleService;
import com.itheima.service.UserRoleService;
import com.itheima.utils.TokenUtils;
import com.itheima.utils.WarehouseConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {
@Autowired
    private RoleService roleService;
@Autowired
    private TokenUtils tokenUtils ;



//查询所有角色的URL接口

    @GetMapping("/role-list")
    public Result roleList(){
        List<Role> allRoles = roleService.findAllRoles();

        return Result.ok(allRoles);
    }



    @RequestMapping("/role-page-list")
    public Result roleListPage(Page page , Role role ){

        page = roleService.queryRolePage(page, role);

   return Result.ok(page);

    }

    @PostMapping("/role-add")
    //根据角色名称 或者 角色代码查询是否已经有角色存在
public Result addRole(@RequestBody Role role ,@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token ){

        //拿到当前登录的用户id
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);

        int createBy = currentUser.getUserId();
role.setCreateBy(createBy);

        Result result = roleService.saveRole(role);
        return result;
    }




    //启用或者禁用角色url接口
    @PutMapping("/role-state-update")
    public Result updateRoleState (@RequestBody Role role ){


        Result result = roleService.setRoleState(role);

       return result ;

    }


    @DeleteMapping("role-delete/{roleId}")
public Result deleteRoleById(@PathVariable Integer roleId)
    {
        Result result = roleService.removeRoleByid(roleId);
        return result ;

    }

@RequestMapping("/role-auth")
    public Result roleAuth(Integer roleId){
        //执行业务

    List<Integer> IdsList = roleService.queryRoleAuthIds(roleId);
    log.info("List ====== >>>>>>> :{}",IdsList);
    return Result.ok(IdsList);

}

@PutMapping("/auth-grant")
public Result grantAuth(@RequestBody AssignAuthDto assignAuthDto){

        //先删除然后重新添加
roleService.saveRoleAuth(assignAuthDto);
return Result.ok("权限分配成功");



}



@RequestMapping("/role-update")
    public Result updateRole(@RequestBody  Role role ,@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token)
{


    CurrentUser currentUser = tokenUtils.getCurrentUser(token);
    int userId = currentUser.getUserId();

    role.setUpdateBy(userId);

    Result result = roleService.setRoleByRid(role);
    return result ;



}
}
