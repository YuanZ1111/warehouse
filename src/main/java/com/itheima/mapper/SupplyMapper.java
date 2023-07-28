package com.itheima.mapper;

import com.itheima.entity.Supply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 85839
* @description 针对表【supply(供货商)】的数据库操作Mapper
* @createDate 2023-07-25 10:33:37
* @Entity com.itheima.entity.Supply
*/
@Mapper
public interface SupplyMapper {



    //查询所有供应商
    public List<Supply> queryAllSupplyList();

}




