package com.itheima.service.impl;

import com.itheima.entity.UserRole;
import com.itheima.mapper.UserRoleMapper;
import com.itheima.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
@Autowired
  private   UserRoleMapper userRoleMapper ;

}
