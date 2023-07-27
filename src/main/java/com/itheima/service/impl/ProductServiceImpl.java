package com.itheima.service.impl;

import com.itheima.entity.Product;
import com.itheima.mapper.ProductMapper;
import com.itheima.page.Page;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductServiceImpl
implements ProductService {

@Autowired
 private ProductMapper productMapper ;


    @Override
    public Page queryProductPage(Page page, Product product) {
        //查询商品行数
        Integer count = productMapper.findProductRowCount(product);
        //分页查询商品
        List<Product> productList = productMapper.findProductPage(page, product);
        //组装信息

        page.setTotalNum(count);
        page.setResultList(productList);
        return page;


    }
}
