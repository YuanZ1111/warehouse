package com.itheima.service;

import com.itheima.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {


    //查找所有品牌

    public List<Brand> queryAllBrand();
}
