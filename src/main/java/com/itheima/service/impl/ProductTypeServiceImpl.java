package com.itheima.service.impl;

import com.itheima.entity.ProductType;
import com.itheima.mapper.ProductTypeMapper;
import com.itheima.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "com.itheima.service.impl.ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper ;

    //查询all商品分类树的业务方法
    //缓存到Redis

    @Override
    @CacheEvict(key = " 'all:typeTree'")
    public List<ProductType> productTypeTree() {

    //查出所有商品分类
        List<ProductType> allProductTypeList = productTypeMapper.findAllProductTypes();

        //将所有商品分类转成商品分类树
        List<ProductType> typeTreeList = allTypeToTypeTree(allProductTypeList, 0);

        return typeTreeList ;


    }


    //递归算法
    //将所有商品分类转成商品分类树
//pid 为上级分类id
     private List<ProductType> allTypeToTypeTree (List<ProductType> typeList , Integer pid){

         //拿到所有一级分类
         List<ProductType> firstLevelType = new ArrayList<>();
         //拿到每个分类
         for (ProductType productType : typeList) {
         if (productType.getParentId().equals(pid)){
             firstLevelType.add(productType);
         }

         }

         for (ProductType productType : firstLevelType) {
             List<ProductType> secondLevelType = allTypeToTypeTree(typeList, productType.getTypeId());
            productType.setChildProductCategory(secondLevelType);

         }
//循环结束之后每一个一级分类底下都保存了二级分类集合
return firstLevelType ;

     }


}
