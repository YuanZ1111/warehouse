package com.itheima.controller;

import com.itheima.entity.Product;
import com.itheima.entity.Result;
import com.itheima.entity.Store;
import com.itheima.page.Page;
import com.itheima.service.BrandService;
import com.itheima.service.ProductService;
import com.itheima.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

@Autowired
    private StoreService storeService;
@Autowired
private BrandService brandService;

@Autowired
private ProductService productService;

//查询所有仓库的Url接口
@GetMapping("/store-list")
public Result storeList(){

    List<Store> storeList = storeService.queryAllStore();
return Result.ok(storeList) ;

}

//查询所有品牌

    @GetMapping("brand-list")
    public Result brandList(){

    return Result.ok(brandService.queryAllBrand());
    }



    @RequestMapping("/product-page-list")
    public Result productListPage(Page page , Product product){

        page = productService.queryProductPage(page, product);


        return Result.ok(page);
    }




}
