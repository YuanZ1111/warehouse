package com.itheima.service;

import com.itheima.entity.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {


    //查询所有仓库
    public List<Store> queryAllStore();


}
