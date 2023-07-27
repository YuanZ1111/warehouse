package com.itheima.service.impl;

import com.itheima.entity.Store;
import com.itheima.mapper.StoreMapper;
import com.itheima.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@CacheConfig(cacheNames = "com.itheima.service.impl.StoreServiceImpl")
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
  private   StoreMapper storeMapper;

    @Cacheable(key = "'all:store'")
    @Override
    public List<Store> queryAllStore() {


        return storeMapper.findAllStore();

    }
}
