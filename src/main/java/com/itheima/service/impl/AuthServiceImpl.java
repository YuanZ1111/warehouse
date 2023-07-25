package com.itheima.service.impl;

import com.alibaba.fastjson.JSON;
import com.itheima.entity.Auth;
import com.itheima.mapper.AuthMapper;
import com.itheima.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
@Slf4j
//指定缓存的名称(缓存的键的前缀 一般是标注@cacheconfig的注解类)
@CacheConfig(cacheNames = {"com.itheima.service.impl.AuthServiceImpl"})
@Service
public class AuthServiceImpl implements AuthService {

    @Override
    //查出所有权限菜单
    //查询方法上标注cacheable注解 并指定缓存的键
    @Cacheable(key = "'all:authTree'")
    public List<Auth> allAuthTree() {
        List<Auth> allAuthList = authMapper.findAllAuth();

        //将所有权限菜单List<Auth> 转成 权限菜单树List
        List<Auth> authTreeList = allAuthToAuthTree(allAuthList, 0);
        return authTreeList ;



    }
    @Autowired
    private AuthMapper authMapper;

@Autowired
private StringRedisTemplate redisTemplate;

    //向redis缓存  -- 键   authTree:userId  值 List<Auth>转的JSON串
    @Override
    public List<Auth> authTreeById(Integer userId) {


//先从redis中查询缓存的用户菜单树

        String authTreejson = redisTemplate.opsForValue().get("authTree" + userId);


        if (StringUtils.hasText(authTreejson)){
            //有缓存
            //List<Auth>转的JSON串 转回去
            List<Auth> authTreeList = JSON.parseArray(authTreejson, Auth.class);
return authTreeList ;

        }
//没有缓存
       //查询用户权限下的所有菜单


        List<Auth> allAuthList = authMapper.findAuthById(userId);
        //allAuthList 转成菜单List<Auth>
        //递归算法
        List<Auth> authTreeList = allAuthToAuthTree(allAuthList, 0);

        String authTreeListJSON = JSON.toJSONString(authTreeList);
log.info("service"+authTreeListJSON);
        redisTemplate.opsForValue().set("authTree" + userId,authTreeListJSON);

        return authTreeList ;



    }


    private List<Auth> allAuthToAuthTree(List<Auth> allAuthList, int parentId){
        //获取父权限(菜单)id为参数parentId的所有权限(菜单)
        //【parentId最初为0,即最初查的是所有一级权限(菜单)】
        List<Auth> authList = new ArrayList<>();
        for (Auth auth : allAuthList) {
            if(auth.getParentId()==parentId){
                authList.add(auth);
            }
        }
        //查询List<Auth> authList中每个权限(菜单)的所有子级权限(菜单)
        for (Auth auth : authList) {
            List<Auth> childAuthList = allAuthToAuthTree(allAuthList, auth.getAuthId());
            auth.setChildAuth(childAuthList);
        }
        return authList;
    }
    }