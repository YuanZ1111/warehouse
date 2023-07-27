package com.itheima.mapper;

import com.itheima.entity.Product;
import com.itheima.page.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 85839
* @description 针对表【product(商品表)】的数据库操作Mapper
* @createDate 2023-07-25 11:22:48
* @Entity com.itheima.entity.Product
*/
@Mapper
public interface ProductMapper {



//查询商品行数

    public Integer findProductRowCount(Product product);


    //分页查询商品行数的方法
    public List<Product> findProductPage(@Param("page") Page page , @Param("product") Product product     );


}




