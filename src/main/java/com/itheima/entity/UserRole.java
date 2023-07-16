package com.itheima.entity;

import java.io.Serializable;

/**
    * 用户角色表
    */
public class UserRole implements Serializable {
    private Integer userRoleId;

    private Integer roleId;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}