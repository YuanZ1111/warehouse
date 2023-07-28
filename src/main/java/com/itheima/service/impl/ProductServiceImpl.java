package com.itheima.service.impl;

import com.itheima.entity.Product;
import com.itheima.entity.Result;
import com.itheima.mapper.ProductMapper;
import com.itheima.page.Page;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Value("${file.access-path}")
    private String fileAccessPath  ;
    
    @Override
    public Result addProduct(Product product) {

        //判断商品型号是否存在

        Product flag = productMapper.findProductById(product.getProductNum());
if (flag != null) {
    return Result.err(Result.CODE_ERR_BUSINESS,"商品已经存在");
}
        String path = fileAccessPath + product.getImgs();
product.setImgs(path);
        int i = productMapper.insertProduct(product);
        if(i>0){

            
            return Result.ok("添加成功");

        }
        return Result.err(Result.CODE_ERR_BUSINESS,"商品添加失败");
    }

    @Override
    public Result updateStateByPid(Product product) {


        int i = productMapper.changeProductStateByPid(product.getProductId(), product.getUpDownState());
        if (i>0){
            return Result.ok("修改状态成功");
        }

        return Result.err(Result.CODE_ERR_BUSINESS,"修改状态失败");


    }

    @Override
    public Result deleteProductByIds(List<Integer> productIds) {

        int i = productMapper.removeProductByIds(productIds);
        if (i>0){

            return Result.ok("商品删除成功");
        }

        return Result.err(Result.CODE_ERR_BUSINESS,"商品删除失败");



    }

    @Override
    public Result setProductById(Product product) {
        Product prod = productMapper.findProductById(product.getProductNum());

        // 商品型号修改了同时修改的型号已经存在
        //判断修改后的型号是否存在
        if (prod!=null  && !(prod.getProductId().equals(product.getProductId()))){
            return Result.err(Result.CODE_ERR_BUSINESS,"修改后的型号已经存在");
        }

        //处理图片地址 判断图片是否被修改了 如果修改了 处理访问路径

        if (!product.getImgs().contains(fileAccessPath))
        {
            product.setImgs(fileAccessPath + product.getImgs());

        }

        int i = productMapper.setProductById(product);
        if (i>0){
            return Result.ok("商品修改成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS,"商品修改失败");








    }
}
