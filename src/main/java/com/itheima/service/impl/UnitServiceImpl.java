package com.itheima.service.impl;

import com.itheima.entity.Unit;
import com.itheima.mapper.UnitMapper;
import com.itheima.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "com.itheima.service.impl.UnitServiceImpl")
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitMapper unitMapper ;
@CacheEvict(key = "'all:unit'")
    @Override
    public List<Unit> getAllUnit() {
        List<Unit> o = unitMapper.getUnitList();
        return o  ;
    }
}
