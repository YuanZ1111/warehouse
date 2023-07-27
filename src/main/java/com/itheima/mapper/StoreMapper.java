package com.itheima.mapper;


import com.itheima.entity.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 85839
* @description 针对表【store(仓库表)】的数据库操作Mapper
* @createDate 2023-07-25 10:30:15
* @Entity entity.Store
*/
@Mapper
public interface StoreMapper {

//查询所有仓库

    public List<Store> findAllStore();
}




