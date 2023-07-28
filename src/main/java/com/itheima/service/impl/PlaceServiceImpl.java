package com.itheima.service.impl;

import com.itheima.entity.Place;
import com.itheima.mapper.PlaceMapper;
import com.itheima.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@CacheConfig(cacheNames = "com.itheima.service.impl.PlaceServiceImpl")
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceMapper placeMapper;
    @Override
    @CacheEvict(key = "'all:place'")
    public List<Place> getPlaceList() {

        List<Place> allPlace = placeMapper.findAllPlace();
        return  allPlace;


    }
}
