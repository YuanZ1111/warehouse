package com.itheima.service.impl;

import com.itheima.dto.AssignAuthDto;
import com.itheima.entity.Result;
import com.itheima.entity.Role;
import com.itheima.entity.RoleAuth;
import com.itheima.mapper.AuthMapper;
import com.itheima.mapper.RoleAuthMapper;
import com.itheima.mapper.RoleMapper;
import com.itheima.page.Page;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author 85839
 */ //指定缓存名称 ----> redis的键的前缀
@Service
@CacheConfig(cacheNames = "com.itheima.service.impl.RoleServiceImpl")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private AuthMapper authMapper;


    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleAuthMapper roleAuthMapper;
//指定缓存的键
    @Cacheable(key = "'all:role'")
    @Override
    public List<Role> findAllRoles() {
        List<Role> allRole = roleMapper.findAllRole();
        return allRole;
    }

    @Override
    public List<Role> findUserRoleByUid(Integer userid) {


        List<Role> roleList = roleMapper.findUserRoleByUid(userid);


        return roleList;


    }

    @Override
    public Page queryRolePage(Page page, Role role) {

        Integer count = roleMapper.findRoleRowCount(role);

        //分页查询角色
        List<Role> roleList = roleMapper.findRolePage(page, role);

        //组装分页信息

        page.setTotalNum(count);

        page.setResultList(roleList);

        return page ;


    }
@CacheEvict(key = "'all:role'")
    @Override
    public Result saveRole(Role role) {

        //判断角色是否已经存在
        Role r = roleMapper.findRoleByNameOrCode(role.getRoleName(), role.getRoleCode());

    if (r != null){
        return Result.err(Result.CODE_ERR_BUSINESS,"角色已经存在");
    }
    //角色不存在
        int i = roleMapper.inserRole(role);
    if (i>0){

        return Result.ok("角色添加成功");

    }
    return Result.err(Result.CODE_ERR_BUSINESS,"添加失败");
    }

    @CacheEvict(key = "'all:role'")
    @Override
    public Result setRoleState(Role role) {

        int i = roleMapper.setRoleStateByRid(role.getRoleId(), role.getRoleState());
        if(i>0){
            return Result.ok("角色启用或者禁用成功!");
        }
        return Result.err(Result.CODE_ERR_BUSINESS,"角色启用或者禁用失败!");


    }

    @Override
    public Result removeRoleByid(Integer roleId) {

        int i = roleMapper.removeRoleByid(roleId);
        if (i>0){
            roleAuthMapper.removeRoleAuthByRid(roleId);
            return Result.ok("删除成功");
        }

        return Result.err(Result.CODE_ERR_BUSINESS,"删除失败")
;


    }

    @Override
    public List<Integer> queryRoleAuthIds(Integer roleId) {

        return roleAuthMapper.findAuthIdsByRId(roleId);
    }

    @Override
    @Transactional

    public void saveRoleAuth(AssignAuthDto assignAuthDto) {

        roleAuthMapper.removeRoleAuthByRid(assignAuthDto.getRoleId());


        List<Integer> authIds = assignAuthDto.getAuthIds();

        for (Integer authId : authIds) {


            RoleAuth roleAuth = new RoleAuth();
            roleAuth.setRoleId(assignAuthDto.getRoleId());
            roleAuth.setAuthId(authId);
            roleAuthMapper.insertRoleAuth(roleAuth);


        }


    }

    @CacheEvict(key = "'all:role'")
    @Override
    public Result setRoleByRid(Role role) {

        int i = roleMapper.setDescByRid(role);
        if (i>0){
            return Result.ok("角色修改成功");
        }

        return Result.err(Result.CODE_ERR_BUSINESS,"角色修改失败");



    }


}
