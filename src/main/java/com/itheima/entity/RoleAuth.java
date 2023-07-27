package com.itheima.entity;

import java.io.Serializable;

/**
    * 角色权限表
    */
public class RoleAuth implements Serializable {
    private Integer roleAuthId;

    private Integer roleId;

    private Integer authId;

    private static final long serialVersionUID = 1L;

    public Integer getRoleAuthId() {
        return roleAuthId;
    }

    public void setRoleAuthId(Integer roleAuthId) {
        this.roleAuthId = roleAuthId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }
}