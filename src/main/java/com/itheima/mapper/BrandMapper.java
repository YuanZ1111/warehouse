package com.itheima.mapper;

import com.itheima.entity.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 85839
* @description 针对表【brand(品牌)】的数据库操作Mapper
* @createDate 2023-07-25 10:25:27
* @Entity .com.itheima.entity.Brand
*/
@Mapper
public interface BrandMapper {

    //查询所有品牌的方法

    public List<Brand> findAllBrand();
}




