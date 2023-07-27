package com.itheima.service;

import com.itheima.entity.Product;
import com.itheima.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
public interface ProductService {

    //分页查询商品的业务方法

    public Page queryProductPage(Page page , Product product);


}
