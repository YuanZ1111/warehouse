package com.itheima.service;

import com.itheima.entity.Product;
import com.itheima.entity.Result;
import com.itheima.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

public interface ProductService {

    //分页查询商品的业务方法

    public Page queryProductPage(Page page , Product product);


    //添加商品
    public Result addProduct(Product product);



    //更改商品上下架状态

    public Result updateStateByPid(Product product);

    //删除商品

    public Result deleteProductByIds(List<Integer> productIds);

    //修改商品的业务方法

    public Result setProductById(Product product) ;


}
