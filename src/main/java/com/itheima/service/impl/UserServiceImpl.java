package com.itheima.service.impl;

import com.itheima.dto.AssignRoleDto;
import com.itheima.entity.CurrentUser;
import com.itheima.entity.Result;
import com.itheima.entity.User;
import com.itheima.entity.UserRole;
import com.itheima.mapper.RoleMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.mapper.UserRoleMapper;
import com.itheima.page.Page;
import com.itheima.service.UserService;
import com.itheima.utils.DigestUtil;
import com.itheima.utils.TokenUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.sampled.Line;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleMapper  roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

@Autowired
private UserMapper userMapper ;
@Autowired
private TokenUtils tokenUtils ;
    @Override
    public int  saveUser(User user,String token) {

        User u = userMapper.findUserByCode(user.getUserCode());
if (u != null) {
    return 0 ;
}
        //新增用户 需要给用户添加属性
        //userid usercode username pwd type state
        //createtime
        // updateby updatetime isdelete

       user.setUserPwd(DigestUtil. hmacSign(user.getUserPwd()));
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        int create = currentUser.getUserId();
       user.setCreateBy(create);
        log.info("new user :{}",user.toString());


        int flag = userMapper.saveUser(user);
        if (flag>0){
            return 1;
        }else {return 0;}

    }

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

    @Override
    public int updateState(User user, String token) {
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
user.setUpdateBy(currentUser.getUserId());



      return   userMapper.updateState(user);





    }
   @Transactional
    @Override
    public void assignUser(AssignRoleDto assignRoleDto) {



userRoleMapper.deleteRoleByUid(assignRoleDto.getUserId());
        List<String> roleNameList = assignRoleDto.getRoleCheckList();
        for (String roleName : roleNameList) {
            Integer roleId = roleMapper.findRoleIdByName(roleName);
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(assignRoleDto.getUserId());
            userRoleMapper.saveUserRole(userRole);
        }
    }


}
