package com.itheima.service;

import com.itheima.entity.ProductType;

import java.util.List;

public  interface   ProductTypeService {


    //查询商品分类树的业务方法

    public List<ProductType> productTypeTree();


}
