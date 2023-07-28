package com.itheima.controller;

import com.itheima.entity.*;
import com.itheima.mapper.UnitMapper;
import com.itheima.page.Page;
import com.itheima.service.*;
import com.itheima.utils.TokenUtils;
import com.itheima.utils.WarehouseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService
            productService;

    //查询所有仓库的Url接口
    @GetMapping("/store-list")
    public Result storeList() {

        List<Store> storeList = storeService.queryAllStore();
        return Result.ok(storeList);

    }

//查询所有品牌

    @GetMapping("brand-list")
    public Result brandList() {

        return Result.ok(brandService.queryAllBrand());
    }


    @RequestMapping("/product-page-list")
    public Result productListPage(Page page, Product product) {

        page = productService.queryProductPage(page, product);


        return Result.ok(page);
    }

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("/category-tree")
    public Result loadTypeTree() {


        List<ProductType> productTypes = productTypeService.productTypeTree();

        return Result.ok(productTypes);

    }


    @Autowired
    private SupplyService supplyService;

    @RequestMapping("/supply-list")

    public Result supplyList() {
        List<Supply> supplies = supplyService.findAllSupplyList();
        return Result.ok(supplies);

    }


    @Autowired
    private PlaceService placeService;

    @RequestMapping("/place-list")
    public Result placeList() {
        List<Place> placeList = placeService.getPlaceList();
        return Result.ok(placeList);

    }


    @Autowired
    private UnitMapper unitMapper;

    @RequestMapping("/unit-list")
    public Result unitList() {
        List<Unit> unitList = unitMapper.getUnitList();
        return Result.ok(unitList);


    }

    //MultipartFile  file 封装了 请求参数名为 file的上传图片
    @Value("${file.upload-path}")
    //图片上传位置
    private String uploadPath;

    @CrossOrigin//表示url接口 可以 跨域
    @RequestMapping("/img-upload")
    public Result uploadImage(MultipartFile file) {

        //图片上传
        //拿到图片上传到的目标路径的file对象
        try {
            File uploadDirFile = ResourceUtils.getFile(uploadPath);
            String uploadDirPath = uploadDirFile.getAbsolutePath();
            String filename = file.getOriginalFilename();

            String uploadFilePath = uploadDirPath + "\\" + filename;
            //上传文件
            file.transferTo(new File(uploadFilePath));
            return Result.ok("图片上传成功");
        } catch (Exception e) {
            return Result.err(Result.CODE_ERR_BUSINESS, "图片上传失败");
        }


    }


    @Autowired
    private
    TokenUtils tokenUtils;

    //添加商品url
    @RequestMapping("/product-add")
    public Result addProduct(@RequestBody Product product, @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token) {
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        product.setCreateBy(currentUser.getUserId());
        Result result = productService.addProduct(product);
        return result ;



    }
@RequestMapping("/state-change")
    public Result changeProductState(@RequestBody Product product){


    Result result = productService.updateStateByPid(product);
    return  result ;


}


//单独删除商品
@RequestMapping("/product-delete/{productId}")
    public Result deleteProduct(@PathVariable Integer productId)
{
    Result result = productService.deleteProductByIds(Arrays.asList(productId));
    return result ;



}

//批量删除商品

    @RequestMapping("/product-delete")
    public Result deleteProducts(@RequestBody List<Integer> productIdList)
    {
        Result result = productService.deleteProductByIds(productIdList);
        return result ;



    }




    @RequestMapping("/product-update")
    public Result updateProduct(@RequestBody Product product,@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token)
    {
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        product.setUpdateBy(currentUser.getUserId());
        Result result = productService.setProductById(product);
        return result ;



    }

}
