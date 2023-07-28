package com.itheima.service.impl;

import com.itheima.entity.Supply;
import com.itheima.mapper.SupplyMapper;
import com.itheima.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@CacheConfig(cacheNames = "com.itheima.service.impl.SupplyServiceImpl")
public class SupplyServiceImpl implements SupplyService {
    @Autowired
    private SupplyMapper    supplyMapper ;
    @CacheEvict(key = "'all:supply'")
    @Override
    public List<Supply> findAllSupplyList() {

        List<Supply> supplyList = supplyMapper.queryAllSupplyList();

return supplyList ;

    }
}
