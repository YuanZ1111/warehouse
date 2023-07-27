package com.itheima.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.PhantomReference;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
//接收给角色分配权限请求的json数据的dto类
public class AssignAuthDto {
//接收角色id
    private Integer roleId ;
    //接收给角色分配的所有菜单权限的id
    private List<Integer> authIds ;



}
