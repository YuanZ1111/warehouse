package com.itheima.mapper;

import com.itheima.entity.ProductType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 85839
* @description 针对表【product_type(商品分类表)】的数据库操作Mapper
* @createDate 2023-07-25 10:32:33
* @Entity com.itheima.entity.ProductType
*/
@Mapper
public interface ProductTypeMapper {

//查询分类树

    //查询所有商品分类
    public List<ProductType> findAllProductTypes();





}




